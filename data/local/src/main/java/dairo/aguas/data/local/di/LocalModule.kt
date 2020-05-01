package dairo.aguas.data.local.di

import dairo.aguas.data.local.NeumomedDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val localModule = module {
    single { NeumomedDatabase.buildDatabase(androidContext()) }
    factory { (get() as NeumomedDatabase).postDao() }
}