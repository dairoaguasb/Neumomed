package dairo.aguas.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import dairo.aguas.data.model.post.Post

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productList: List<Post>)
}