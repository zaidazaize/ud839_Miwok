package com.example.android.miwok.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    ArrayList<LangData> langData;

    public NumberAdapter(ArrayList<LangData> arrayList) {
        this.langData = arrayList;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NumberViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.number_listitem, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        LangData data = langData.get(position);
        holder.miwokTextView.setText(data.getMiwokWord());
        holder.engTextView.setText(data.getEngWord());
    }

    @Override
    public int getItemCount() {
        return langData.size();
    }

    public static class NumberViewHolder extends RecyclerView.ViewHolder {
        public final TextView engTextView,miwokTextView;
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            engTextView = itemView.findViewById(R.id.list_itemNumbersEng);
            miwokTextView = itemView.findViewById(R.id.list_itemNumbersMiwok);
        }
    }
}
