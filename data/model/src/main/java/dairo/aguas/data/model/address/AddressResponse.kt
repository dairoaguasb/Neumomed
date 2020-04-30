package dairo.aguas.data.model.address

import com.squareup.moshi.Json
import dairo.aguas.data.model.geo.GeoResponse

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
data class AddressResponse(
    @Json(name = "street") val street: String = "",
    @Json(name = "suite") val suite: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "zipcode") val zipcode: String = "",
    @Json(name = "geo") val geoResponse: GeoResponse = GeoResponse()
)