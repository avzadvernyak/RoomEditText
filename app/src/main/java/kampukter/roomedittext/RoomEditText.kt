package kampukter.roomedittext

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.roomedittext.*
import androidx.room.Room
import kampukter.roomedittext.db.Field
import kampukter.roomedittext.db.FieldsDatabase

lateinit var db: FieldsDatabase


class RoomEditText : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.roomedittext)

        db = Room.databaseBuilder(
            this,
            FieldsDatabase::class.java,
            "fields"
        ).allowMainThreadQueries().build()

        db.fieldDao().startFields()

        addButton.setOnClickListener {

            if (!fieldEditText.text.toString().isEmpty()) {

                val inputField = Field(fieldEditText.text.toString())
                db.fieldDao().insertField(inputField)
                Log.d("blablabla", "----------------- Add Field To Room -----------------")
                fieldEditText.text.clear()
            }
        }

        delAllButton.setOnClickListener {
            db.fieldDao().deleteAllFields()
            Log.d("blablabla", "-----------------Deleted All Field To Room -----------------")
        }


    }
}