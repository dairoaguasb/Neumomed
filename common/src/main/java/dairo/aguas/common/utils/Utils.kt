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

    fun openMap(lat: String, lnt: String, context: Context) {
        val gmmIntentUri = Uri.parse("geo:$lat,$lnt")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapIntent);
        }
    }
}