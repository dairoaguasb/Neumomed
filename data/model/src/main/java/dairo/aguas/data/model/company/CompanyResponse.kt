package dairo.aguas.data.model.company

import com.squareup.moshi.Json

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
data class CompanyResponse(
    @Json(name = "name") val name: String = "",
    @Json(name = "catchPhrase") val catchPhrase: String = "",
    @Json(name = "bs") val bs: String = ""
)