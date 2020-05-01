package dairo.aguas.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dairo.aguas.data.model.post.Post
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productList: List<Post>)

    @Query("SELECT * FROM post")
    fun getPostList(): Flow<List<Post>>
}