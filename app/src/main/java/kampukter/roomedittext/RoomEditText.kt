package kampukter.roomedittext

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.roomedittext.*
import android.widget.ArrayAdapter
import androidx.room.Room
import kampukter.roomedittext.db.Field
import kampukter.roomedittext.db.FieldsDatabase
import java.util.concurrent.Executors

lateinit var db: FieldsDatabase

class RoomEditText : AppCompatActivity() {

    private var listFromRoom: List<String> = listOf("Empty")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.roomedittext)

        db = Room.databaseBuilder(
            this,
            FieldsDatabase::class.java,
            "fields"
        ).build()
        Log.d("blablabla", "-----------------------------------------")
        Executors.newSingleThreadExecutor().submit {
            Log.d("blablabla", "************************************")
            val fields = db.fieldDao().fieldsFromRoom()
            Log.d("blablabla", "${fields.size}")
        }

        //Executors.newSingleThreadExecutor().submit { listFromRoom = db.fieldDao().fieldsFromRoom() }
        //val fields = db.fieldDao().fieldsFromRoom()
        //Log.d("blablabla", "${fields.size}")
        fromRoomListView.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, listFromRoom
        )

        addButton.setOnClickListener {

            if (!fieldEditText.text.toString().isEmpty()) {
                val inputField = Field(fieldEditText.text.toString())
                Executors.newSingleThreadExecutor().submit { db.fieldDao().insert(inputField) }
            }
        }


    }
}