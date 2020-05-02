package dairo.aguas.data.model.user

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
object ConvertUser {

    fun convertUserResponseInUser(userResponse: UserResponse) =
        User(
            id = userResponse.id,
            name = userResponse.name,
            username = userResponse.username,
            email = userResponse.email,
            phone = userResponse.phone,
            website = userResponse.website,
            lat = userResponse.address.geo.lat,
            lng = userResponse.address.geo.lng
        )
}