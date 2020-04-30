package dairo.aguas.data.model.comment

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@Entity(tableName = "comment")
data class Comment(
    @PrimaryKey
    val id: Int = 0,
    val postId: Int = 0,
    val name: String = "",
    val email: String = "",
    val body: String = ""
)