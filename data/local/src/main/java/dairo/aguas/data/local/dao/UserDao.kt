package dairo.aguas.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import dairo.aguas.data.model.user.User

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
}