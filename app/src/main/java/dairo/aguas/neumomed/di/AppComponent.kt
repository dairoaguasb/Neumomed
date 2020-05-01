package dairo.aguas.neumomed.di

import dairo.aguas.common.utils.Constants
import dairo.aguas.data.local.di.localModule
import dairo.aguas.data.remote.di.createRemoteModule
import dairo.aguas.feature.main.di.mainModule
import dairo.aguas.neumomed.BuildConfig

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val appComponent = listOf(
    createRemoteModule(baseUrl = Constants.BASE_URL, debugMode = BuildConfig.DEBUG),
    mainModule,
    localModule
)