package bobby.irawan.roomflow

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import bobby.irawan.roomflow.CatEntity.Companion.DATABASE_TABLE_NAME

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
@Entity(tableName = DATABASE_TABLE_NAME)
data class CatEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Int = 0,
    @ColumnInfo(name = COLUMN_BREED)
    var breed: String = ""
) {
    companion object {
        const val DATABASE_TABLE_NAME = "cat"
        const val COLUMN_ID = "id"
        const val COLUMN_BREED = "breed"

        fun preloadData(): List<CatEntity> {
            val cats = mutableListOf<CatEntity>()
            cats.add(CatEntity(
                breed = "Abyssinian"
            ))
            cats.add(CatEntity(
                breed = "Aegean"
            ))
            cats.add(CatEntity(
                breed = "American Bobtail"
            ))
            cats.add(CatEntity(
                breed = "American Curl"
            ))
            cats.add(CatEntity(
                breed = "American Shorthair"
            ))
            return cats
        }
    }
}