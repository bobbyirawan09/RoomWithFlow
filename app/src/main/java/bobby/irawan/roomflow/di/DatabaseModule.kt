package bobby.irawan.roomflow.di

import androidx.room.Room
import bobby.irawan.roomflow.CatDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by bobbyirawan09 on 06/08/20.
 */

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), CatDatabase::class.java, "cat_database")
            .build()
    }

    single {
        get<CatDatabase>().catDao()
    }
}