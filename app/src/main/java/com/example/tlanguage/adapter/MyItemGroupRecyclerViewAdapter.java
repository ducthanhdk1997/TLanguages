package com.example.tlanguage.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tlanguage.R;
import com.example.tlanguage.action.ItemListener;
import com.example.tlanguage.model.Group;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemGroupRecyclerViewAdapter extends RecyclerView.Adapter<MyItemGroupRecyclerViewAdapter.ViewHolder> {

    private final List<Group> mValues;
    private ItemListener mListener;

    public MyItemGroupRecyclerViewAdapter(List<Group> items, ItemListener listener) {
        mValues = items;

        if (listener != null) {
            mListener = listener;
        } else throw new RuntimeException(listener.toString() + "You must implement ItemListener");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mGroup = mValues.get(position);
        holder.mGroupName.setText(mValues.get(position).getName());
        holder.mGroupCount.setText(mValues.get(position).getWords() +"");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public final View mView;
        public final TextView mGroupName, mGroupCount;
        public Group mGroup;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mView.setOnLongClickListener(this);
            mView.setOnClickListener(this);
            mGroupName = view.findViewById(R.id.tvGroupName);
            mGroupCount = view.findViewById(R.id.tvGroupCount);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mListener.itemClick(v, position);
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            mListener.itemClick(v, position);
            return false;
        }
    }
}