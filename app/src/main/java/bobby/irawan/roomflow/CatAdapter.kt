package bobby.irawan.roomflow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_cat.view.*


/**
 * Created by bobbyirawan09 on 06/08/20.
 */
class CatAdapter :
    RecyclerView.Adapter<ViewHolder>() {

    private var cats = listOf<Cat>()

    fun setData(cats: List<Cat>) {
        this.cats = cats
        notifyDataSetChanged()
    }

    fun getItemByPosition(position: Int): Cat = cats[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is CatViewHolder -> holder.bind(cats[position])
        }
    }

    internal class CatViewHolder(itemView: View) :
        ViewHolder(itemView) {
        fun bind(cat: Cat) {
            itemView.text_view_breed.text = cat.breed
        }
    }
}