package dairo.aguas.data.repository.user

import dairo.aguas.data.remote.user.UserDatasource

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class UserRepositoryImpl(
    private val userDatasource: UserDatasource
) : UserRepository {

    override suspend fun getUserById(idUser: Int) =
        userDatasource.getUserById(idUser)
}