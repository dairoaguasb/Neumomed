package dairo.aguas.neumomed

import android.app.Application
import dairo.aguas.neumomed.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class NeumomedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@NeumomedApplication)
            modules(appComponent)
        }
    }
}