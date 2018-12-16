package kampukter.roomedittext.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kampukter.roomedittext.Ob.Emitter
import kampukter.roomedittext.Ob.Observer
import kampukter.roomedittext.R
import kampukter.roomedittext.db.Field
import kotlinx.android.synthetic.main.field_recycler_fragment.*


val fieldEmitter: Emitter<List<Field>> = Emitter()

class FieldFragment: Fragment(), Observer<List<Field>> {

    private var fieldAdapter: FieldAdapter? = null

    init {
        fieldEmitter.subscribe(this)
    }

    override fun onChanged(data: List<Field>) {
        // do something with city
        fieldAdapter?.setFields(data)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? { return inflater.inflate(R.layout.field_recycler_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fieldAdapter = FieldAdapter()
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = fieldAdapter
        }
    }
}