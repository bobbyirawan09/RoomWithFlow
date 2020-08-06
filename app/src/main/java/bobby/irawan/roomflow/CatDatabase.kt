package bobby.irawan.roomflow

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
@Database(entities = arrayOf(CatEntity::class), version = 1, exportSchema = false)
abstract class CatDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
}