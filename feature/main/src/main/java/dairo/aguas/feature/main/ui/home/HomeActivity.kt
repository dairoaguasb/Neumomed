package dairo.aguas.feature.main.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dairo.aguas.feature.main.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        configureToolbar()
    }


    private fun configureToolbar() {
        setSupportActionBar(toolbar)
    }
}
