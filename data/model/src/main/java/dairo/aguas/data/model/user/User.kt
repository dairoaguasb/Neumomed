package dairo.aguas.data.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val phone: String = "",
    val website: String = "",
    val lng: Double = 0.0,
    val lat: Double = 0.0
)