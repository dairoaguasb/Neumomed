package dairo.aguas.data.remote.post

import com.squareup.moshi.Moshi
import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.retrofit.ErrorResponse
import dairo.aguas.data.remote.ApiServices
import dairo.aguas.data.remote.retrofit.ErrorHandler
import dairo.aguas.data.model.vo.Result


/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class PostDatasource(private val apiServices: ApiServices, private val moshi: Moshi) {

    suspend fun getPostList(): Result<List<Post>> {
        try {
            apiServices.getPostList().run {
                return if (isSuccessful && body() != null)
                    Result.Success(body() as List<Post>)
                else
                    Result.Failure(
                        Exception(
                            ErrorHandler.parseError<ErrorResponse>(errorBody(), moshi)?.message
                        )
                    )
            }
        } catch (e: Exception) {
            return Result.Failure(e)
        }
    }
}