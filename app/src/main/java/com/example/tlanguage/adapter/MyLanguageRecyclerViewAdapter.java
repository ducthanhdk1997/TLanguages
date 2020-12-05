package com.example.tlanguage.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tlanguage.R;
import com.example.tlanguage.action.ItemListener;
import com.example.tlanguage.model.Language;

import java.util.List;

public class MyLanguageRecyclerViewAdapter extends RecyclerView.Adapter<MyLanguageRecyclerViewAdapter.ViewHolder> {

    private final List<Language> mListLanguages;
    private ItemListener mListener;

    public MyLanguageRecyclerViewAdapter(List<Language> items, ItemListener listener) {
        mListLanguages = items;
        if (listener instanceof ItemListener) {
            this.mListener = listener;
        } else {
            throw new RuntimeException(listener.toString() + "must implement LanguageItemListener");
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvLanguage.setText(mListLanguages.get(position).getName());
        holder.tvCount.setText("100 words");
    }

    @Override
    public int getItemCount() {
        return mListLanguages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener{
        public final View mView;
        public final TextView tvLanguage, tvCount;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mView.setOnClickListener(this);
            mView.setOnLongClickListener(this);
            tvLanguage = view.findViewById(R.id.tvLanguage);
            tvCount = view.findViewById(R.id.tvCount);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mListener.itemClick(v, position);
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            mListener.itemLongClick(v, position);
            return false;
        }
    }
}