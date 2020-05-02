package dairo.aguas.feature.main.domain

import dairo.aguas.data.model.user.ConvertUser
import dairo.aguas.data.model.user.UserResponse
import dairo.aguas.data.repository.user.UserRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class SetUserLocal(private val userRepository: UserRepository) {

    suspend fun execute(userResponse: UserResponse) {
        userRepository.setUserLocal(ConvertUser.convertUserResponseInUser(userResponse))
    }
}