package dairo.aguas.data.remote.comment

import com.squareup.moshi.Moshi
import dairo.aguas.data.model.comment.Comment
import dairo.aguas.data.model.retrofit.ErrorResponse
import dairo.aguas.data.model.vo.Result
import dairo.aguas.data.remote.ApiServices
import dairo.aguas.data.remote.retrofit.ErrorHandler

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class CommentDatasource(private val apiServices: ApiServices, private val moshi: Moshi) {

    suspend fun getCommentListByIdPost(idPost: Int): Result<List<Comment>> {
        try {
            apiServices.getCommentList(idPost).run {
                return if (isSuccessful && body() != null)
                    Result.Success(body() as List<Comment>)
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