package kampukter.roomedittext.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kampukter.roomedittext.db.Field
import kotlinx.android.synthetic.main.field_item.view.*

class FieldViewHolder(fieldView: View) : RecyclerView.ViewHolder(fieldView) {
    fun bind(field: Field, itemClickListener: ItemClickListener<String>?){
        with(itemView) {
            nameTextView.text = field.name
            setOnClickListener { itemClickListener?.invoke(field.name) }
        }
    }
}