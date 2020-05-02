package dairo.aguas.data.repository.user

import dairo.aguas.data.model.user.User
import dairo.aguas.data.model.user.UserResponse
import dairo.aguas.data.model.vo.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
interface UserRepository {

    suspend fun getUserById(idUser: Int): Result<UserResponse>

    fun getUserLocalFlow(idUser: Int): Flow<User>

    suspend fun setUserLocal(user: User)
}