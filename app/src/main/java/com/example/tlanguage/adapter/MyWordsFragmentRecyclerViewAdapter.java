package com.example.tlanguage.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tlanguage.R;
import com.example.tlanguage.fragment.dummy.DummyContent.DummyItem;
import com.example.tlanguage.model.Word;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyWordsFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MyWordsFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<Word> mValues;

    public MyWordsFragmentRecyclerViewAdapter(List<Word> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvWord.setText(mValues.get(position).getWord());
        holder.tvMainMean.setText(mValues.get(position).getMean());
        holder.tvSubMean.setText("This is submean");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView tvWord, tvMainMean, tvSubMean;
        public Word mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvWord = (TextView) view.findViewById(R.id.tvWord);
            tvMainMean = (TextView) view.findViewById(R.id.tvMainMean);
            tvSubMean = (TextView) view.findViewById(R.id.tvSubMean);
        }
    }
}