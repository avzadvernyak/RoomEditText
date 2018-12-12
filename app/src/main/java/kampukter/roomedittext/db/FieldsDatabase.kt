package kampukter.roomedittext.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [
    Field::class
])
abstract class FieldsDatabase : RoomDatabase() {

    abstract fun fieldDao(): FieldDao

}