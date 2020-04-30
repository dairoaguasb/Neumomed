package dairo.aguas.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import dairo.aguas.libraries.actions.Actions

class SplashActivity : AppCompatActivity() {

    private val splashTime = 2000L
    private var myHandler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        myHandler.postDelayed({
            openMainActivity()
        }, splashTime)
    }

    private fun openMainActivity() {
        startActivity(Actions.openMainIntent(this).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }
}
