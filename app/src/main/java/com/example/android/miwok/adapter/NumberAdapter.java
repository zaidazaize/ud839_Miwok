package com.example.android.miwok.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    /**
    * Interface for handling the click events in the list item is clicked.
    */
    public interface OnListItemClickedMiwok{
        void onListItemClicked(View view, int resourseId);
    }

    ArrayList<LangData> langData;
    OnListItemClickedMiwok onListItemClickedMiwok;

    public NumberAdapter(ArrayList<LangData> arrayList, OnListItemClickedMiwok onListItemClickedMiwok) {
        this.onListItemClickedMiwok = onListItemClickedMiwok;
        this.langData = arrayList;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("numberActivity", "view holder");
        return new NumberViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.number_listitem, parent, false),
                onListItemClickedMiwok);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        Log.d("numberActivity","DataBound");
        LangData data = langData.get(position);
        holder.miwokTextView.setText(data.getMiwokWord());
        holder.engTextView.setText(data.getEngWord());
        if (data.isImage) {
            holder.imageView.setImageResource(data.getmImageResourseId());
        }else holder.imageView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return langData.size();
    }


    /**
     * @param n position of list item that was clicked
     * @return the Language object corresponding with the position of the list element which has been clicked.
     */
    public LangData getClickedWord(int n) {
        return langData.get(n);

    }


    public static class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView engTextView, miwokTextView;
        public final ImageView imageView;
        OnListItemClickedMiwok clickedMiwok;


        /**
         * @param itemView the root view object of the list item xml file.
         * @param clickedMiwok the callback object which will be called when the listitem will be clicked
         * This constructor creates and initialises all the editable fields in the listitem which will be
         * bound with the data.This also attaches a click listener which will respond when list item will be clicked.
         *
         */
        public NumberViewHolder(@NonNull View itemView, OnListItemClickedMiwok clickedMiwok) {
            super(itemView);
            engTextView = itemView.findViewById(R.id.list_itemNumbersEng);
            miwokTextView = itemView.findViewById(R.id.list_itemNumbersMiwok);
            imageView = itemView.findViewById(R.id.list_itemimageview);
            this.clickedMiwok = clickedMiwok;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedMiwok.onListItemClicked(v,getAdapterPosition());
        }
    }
}
