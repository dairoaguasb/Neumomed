package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.user.UserRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class GetUserByIdAPI(private val userRepository: UserRepository) {

    suspend fun execute(idUser: Int) =
        userRepository.getUserById(idUser)
}