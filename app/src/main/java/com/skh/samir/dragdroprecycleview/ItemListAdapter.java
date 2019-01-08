package com.skh.samir.dragdroprecycleview;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by samir on 3/20/2017.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>
        implements InterfaceItem.ItemTouchHelperAdapter {

    private List<ListItem> mItems = new ArrayList<>();

    private final InterfaceItem.OnStartDragListener mDragStartListener;
    private ListItem listItem;

    public ItemListAdapter(Context context, InterfaceItem.OnStartDragListener dragStartListener, List<ListItem> listItem) {
        mDragStartListener = dragStartListener;
        mItems = listItem;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        ListItem item = mItems.get(position);

        holder.id_tv.setText(item.getId() + "");
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(item.getImg());

        // Start a drag whenever the handle view it touched
        holder.imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * Simple example of a view holder that implements {@link InterfaceItem.ItemTouchHelperViewHolder} and has a
     * "handle" view that initiates a drag event when touched.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder implements
            InterfaceItem.ItemTouchHelperViewHolder {

        public final TextView id_tv;
        public final TextView textView;
        public final ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            id_tv = itemView.findViewById(R.id.id_tv);
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.img_view);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }

    public List<ListItem> getAllList() {
        return mItems;
    }
}
