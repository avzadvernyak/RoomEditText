package kampukter.roomedittext.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kampukter.roomedittext.R
import kampukter.roomedittext.db.Field

typealias ItemClickListener<T> = (T) -> Unit

class FieldAdapter (private val itemClickListener: ItemClickListener<String>? = null
) : RecyclerView.Adapter<FieldViewHolder>() {

    private var fields: List<Field>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldViewHolder {
        return FieldViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.field_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return fields?.size ?: 0
    }

    override fun onBindViewHolder(holder: FieldViewHolder, position: Int) {
        fields?.get(position)?.let { fields ->
            holder.bind(fields, itemClickListener)
        }
    }

    fun setFields(fields: List<Field>) {
        this.fields = fields
        notifyDataSetChanged()
    }
}