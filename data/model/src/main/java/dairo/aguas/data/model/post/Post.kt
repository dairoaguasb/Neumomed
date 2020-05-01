package dairo.aguas.data.model.post

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@Entity(tableName = "post")
data class Post(
    @PrimaryKey
    val id: Int = 0,
    val userId: Int = 0,
    val title: String = "",
    val body: String = "",
    var isRead: Boolean = true,
    var isFavorite: Boolean = false
)