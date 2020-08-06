package bobby.irawan.roomflow

import android.app.Application
import android.content.Context
import bobby.irawan.roomflow.di.databaseModule
import bobby.irawan.roomflow.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
class AppController : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(databaseModule, presentationModule)
        }
    }

    companion object {
        private lateinit var instance: AppController

        fun getInstance(): Context = instance.applicationContext
    }
}