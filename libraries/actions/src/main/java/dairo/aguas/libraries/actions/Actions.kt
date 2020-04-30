package dairo.aguas.libraries.actions

import android.content.Context
import android.content.Intent
import dairo.aguas.common.utils.Constants

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
object Actions {

    fun openSplashIntent(context: Context) =
        internalIntent(context, Constants.actionSplash)

    fun openMainIntent(context: Context) =
        internalIntent(context, Constants.actionMain)

    private fun internalIntent(context: Context, action: String) =
        Intent(action).setPackage(context.packageName)
}