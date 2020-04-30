package dairo.aguas.neumomed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dairo.aguas.libraries.actions.Actions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Actions.openSplashIntent(this).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }
}
