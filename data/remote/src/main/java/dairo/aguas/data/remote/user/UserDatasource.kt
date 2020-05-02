package dairo.aguas.data.remote.user

import com.squareup.moshi.Moshi
import dairo.aguas.data.model.retrofit.ErrorResponse
import dairo.aguas.data.model.user.UserResponse
import dairo.aguas.data.model.vo.Result
import dairo.aguas.data.remote.ApiServices
import dairo.aguas.data.remote.retrofit.ErrorHandler

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class UserDatasource(private val apiServices: ApiServices, private val moshi: Moshi) {

    suspend fun getUserById(idUser: Int): Result<UserResponse> {
        try {
            apiServices.getUser(idUser).run {
                return if (isSuccessful && body() != null)
                    Result.Success(body() as UserResponse)
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