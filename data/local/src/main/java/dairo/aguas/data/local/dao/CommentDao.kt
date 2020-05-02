package dairo.aguas.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import dairo.aguas.data.model.comment.Comment

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(commentList: List<Comment>)
}