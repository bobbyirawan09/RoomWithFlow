package bobby.irawan.roomflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_cat.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatActivity : AppCompatActivity() {

    private val viewModel by viewModel<CatViewModel>()
    private val adapter = CatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)

        setView()
        observerViewModel()
        viewModel.getAllCat()
    }

    private fun observerViewModel() {
        viewModel.cats.observe(this) {cats ->
            adapter.setData(cats = cats)
        }
    }

    private fun setView() {
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter) { catEntity ->
            viewModel.deleteCat(catEntity)
        })
        itemTouchHelper.attachToRecyclerView(recycler_view_cat)
        recycler_view_cat.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler_view_cat.adapter = adapter
    }
}