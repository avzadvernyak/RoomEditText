package kampukter.roomedittext.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fields")
data class Field (
    @PrimaryKey
    @ColumnInfo(name = "field")
    val name: String
)