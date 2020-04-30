package dairo.aguas.data.model.user

import com.squareup.moshi.Json
import dairo.aguas.data.model.address.AddressResponse
import dairo.aguas.data.model.company.CompanyResponse

data class UserResponse(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "name") val name: String = "",
    @Json(name = "username") val username: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "phone") val phone: String = "",
    @Json(name = "website") val website: String = "",
    @Json(name = "address") val address: AddressResponse = AddressResponse(),
    @Json(name = "company") val company: CompanyResponse = CompanyResponse()
)
