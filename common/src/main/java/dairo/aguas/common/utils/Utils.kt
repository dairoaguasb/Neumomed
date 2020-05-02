package dairo.aguas.common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
object Utils {

    fun openWebSite(url: String, context: Context) {
        var urlWeb = url
        if (urlWeb.startsWith("http://").not())
            urlWeb = "http://$url"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb))
        context.startActivity(intent)
    }
}