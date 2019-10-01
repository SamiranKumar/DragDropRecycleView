package com.skh.samir.dragdroprecycleview;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
/**
 * Created by samir on 3/20/2017.
 */

public class InterfaceItem {

/**
        * Interface to listen for a move or dismissal event from a {@link ItemTouchHelper.Callback}.
            *
            * @author Paul Burke (ipaulpro)
 */

    public interface ItemTouchHelperAdapter {

        /**
         * Called when an item has been dragged far enough to trigger a move. This is called every time
         * an item is shifted, and <strong>not</strong> at the end of a "drop" event.<br/>
         * <br/>
         * Implementations should call {@link RecyclerView.Adapter#notifyItemMoved(int, int)} after
         * adjusting the underlying data to reflect this move.
         *
         * @param fromPosition The start position of the moved item.
         * @param toPosition   Then resolved position of the moved item.
         * @return True if the item was moved to the new adapter position.
         *
         * @see RecyclerView#getAdapterPositionFor(RecyclerView.ViewHolder)
         * @see RecyclerView.ViewHolder#getAdapterPosition()
         */
        boolean onItemMove(int fromPosition, int toPosition);


        /**
         * Called when an item has been dismissed by a swipe.<br/>
         * <br/>
         * Implementations should call {@link RecyclerView.Adapter#notifyItemRemoved(int)} after
         * adjusting the underlying data to reflect this removal.
         *
         * @param position The position of the item dismissed.
         *
         * @see RecyclerView#getAdapterPositionFor(RecyclerView.ViewHolder)
         * @see RecyclerView.ViewHolder#getAdapterPosition()
         */
        void onItemDismiss(int position);
    }

    /**
     * Interface to notify an item ViewHolder of relevant callbacks from {@link
     * androidx.recyclerview.widget.ItemTouchHelper.Callback}.
     *
     * @author Paul Burke (ipaulpro)
     */

    public interface ItemTouchHelperViewHolder {

        /**
         * Called when the {@link ItemTouchHelper} first registers an item as being moved or swiped.
         * Implementations should update the item view to indicate it's active state.
         */
        void onItemSelected();


        /**
         * Called when the {@link ItemTouchHelper} has completed the move or swipe, and the active item
         * state should be cleared.
         */
        void onItemClear();
    }


    /**
     * Listener for manual initiation of a drag.
     */
    public interface OnStartDragListener {

        /**
         * Called when a view is requesting a start of a drag.
         *
         * @param viewHolder The holder of the view to drag.
         */
        void onStartDrag(RecyclerView.ViewHolder viewHolder);

    }

}
