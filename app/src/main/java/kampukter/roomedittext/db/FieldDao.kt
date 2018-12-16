package kampukter.roomedittext.db

import androidx.room.OnConflictStrategy
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kampukter.roomedittext.ui.fieldEmitter


@Dao
abstract class FieldDao {

    @Query("select * from fields")
    abstract fun fieldsFromRoom(): List<Field>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(field: Field)

    fun insertField(_field: Field) {
        insert(_field)
        fieldEmitter.emit(fieldsFromRoom())
    }

    @Query("DELETE FROM fields")
    abstract fun deleteAll()

    fun deleteAllFields() {
        deleteAll()
        fieldEmitter.emit(fieldsFromRoom())
    }

    fun startFields() {
        fieldEmitter.emit(fieldsFromRoom())
    }
}