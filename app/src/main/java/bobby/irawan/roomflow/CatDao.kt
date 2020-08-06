package bobby.irawan.roomflow

import androidx.room.*
import bobby.irawan.roomflow.CatEntity.Companion.DATABASE_TABLE_NAME
import kotlinx.coroutines.flow.Flow

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
@Dao
interface CatDao {

    @Query("SELECT * FROM $DATABASE_TABLE_NAME")
    fun getCats(): Flow<List<CatEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCat(catEntity: List<CatEntity>)

    @Delete
    suspend fun deleteCat(cat: CatEntity)
}