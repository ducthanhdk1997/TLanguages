package com.example.tlanguage.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tlanguage.R;
import com.example.tlanguage.fragment.dummy.DummyContent.DummyItem;
import com.example.tlanguage.model.Language;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLanguageRecyclerViewAdapter extends RecyclerView.Adapter<MyLanguageRecyclerViewAdapter.ViewHolder> {

    private final List<Language> mListLanguages;

    public MyLanguageRecyclerViewAdapter(List<Language> items) {
        mListLanguages = items;
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvLanguage, tvCount;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvLanguage = (TextView) view.findViewById(R.id.tvLanguage);
            tvCount = (TextView) view.findViewById(R.id.tvCount);
        }
    }
}