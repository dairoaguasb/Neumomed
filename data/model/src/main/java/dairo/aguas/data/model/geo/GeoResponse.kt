package dairo.aguas.data.model.geo

import com.squareup.moshi.Json

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
data class GeoResponse(
    @Json(name = "lng") val lng: String = "",
    @Json(name = "lat") val lat: String = ""
)