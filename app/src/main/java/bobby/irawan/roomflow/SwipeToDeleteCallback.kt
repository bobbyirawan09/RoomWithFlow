package bobby.irawan.roomflow

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
class SwipeToDeleteCallback(
    private val adapter: CatAdapter,
    dragDirs: Int = 0,
    swipeDirs: Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
    private val action: (catEntity: CatEntity) -> Unit
) :
    ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val deleteData = adapter.getItemByPosition(viewHolder.adapterPosition)
        action(CatEntity(deleteData.id, deleteData.breed))
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        val itemView: View = viewHolder.itemView
        val backgroundCornerOffset =
            16 //so background is behind the rounded corners of itemView

        val icon = ContextCompat.getDrawable(
            AppController.getInstance(),
            R.drawable.ic_baseline_delete
        ) as Drawable
        val backgroundColor = ColorDrawable(Color.RED)

        val iconMargin: Int = (itemView.getHeight() - icon.getIntrinsicHeight()) / 2
        val iconTop: Int =
            itemView.getTop() + (itemView.getHeight() - icon.getIntrinsicHeight()) / 2
        val iconBottom: Int = iconTop + icon.getIntrinsicHeight()

        if (dX > 0) { // Swiping to the right
            val iconLeft = itemView.left + iconMargin
            val iconRight = itemView.left + iconMargin + icon.intrinsicWidth
            icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            backgroundColor.setBounds(
                itemView.getLeft(), itemView.getTop(),
                itemView.getLeft() + dX.toInt() + backgroundCornerOffset, itemView.getBottom()
            )
        } else if (dX < 0) { // Swiping to the left
            val iconLeft: Int = itemView.getRight() - iconMargin - icon.getIntrinsicWidth()
            val iconRight: Int = itemView.getRight() - iconMargin
            icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            backgroundColor.setBounds(
                itemView.getRight() + dX.toInt() - backgroundCornerOffset,
                itemView.getTop(), itemView.getRight(), itemView.getBottom()
            )
        } else { // view is unSwiped
            backgroundColor.setBounds(0, 0, 0, 0)
            icon.setBounds(0, 0, 0, 0)
        }

        backgroundColor.draw(c)
        icon.draw(c)
    }
}