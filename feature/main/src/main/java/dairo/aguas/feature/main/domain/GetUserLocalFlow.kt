package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.user.UserRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class GetUserLocalFlow(private val userRepository: UserRepository) {

    fun execute(idUser: Int) =
        userRepository.getUserLocalFlow(idUser)
}