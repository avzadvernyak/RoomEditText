package kampukter.roomedittext.db

import androidx.room.OnConflictStrategy
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface FieldDao {

    @Query("select field from fields")
    fun fieldsFromRoom(): List<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(field: Field)

    @Query("DELETE FROM fields")
    fun deleteAll()
}