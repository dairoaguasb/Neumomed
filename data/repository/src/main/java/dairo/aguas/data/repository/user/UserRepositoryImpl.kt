package dairo.aguas.data.repository.user

import dairo.aguas.data.local.dao.UserDao
import dairo.aguas.data.model.user.User
import dairo.aguas.data.remote.user.UserDatasource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class UserRepositoryImpl(
    private val userDatasource: UserDatasource,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getUserById(idUser: Int) =
        userDatasource.getUserById(idUser)

    override fun getUserLocalFlow(idUser: Int) =
        userDao.getUserFlow(idUser)

    override suspend fun setUserLocal(user: User) {
        userDao.insert(user)
    }
}