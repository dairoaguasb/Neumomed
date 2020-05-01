package dairo.aguas.data.remote.retrofit

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody

object ErrorHandler {

    inline fun <reified T> parseError(responseBody: ResponseBody?, moshi: Moshi): T? {
        val parser = moshi.adapter(T::class.java)
        val response = responseBody?.string()
        if (response != null)
            try {
                return parser.fromJson(response)
            } catch (e: JsonDataException) {
                e.printStackTrace()
            }
        return null
    }
}