package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        // Create a list of words
        ArrayList<LangData> words = new ArrayList<LangData>();
        words.add(new LangData("red", "weṭeṭṭi", R.drawable.color_red));
        words.add(new LangData("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
        words.add(new LangData("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        words.add(new LangData("green", "chokokki", R.drawable.color_green));
        words.add(new LangData("brown", "ṭakaakki", R.drawable.color_brown));
        words.add(new LangData("gray", "ṭopoppi", R.drawable.color_gray));
        words.add(new LangData("black", "kululli", R.drawable.color_black));
        words.add(new LangData("white", "kelelli", R.drawable.color_white));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        recyclerView.setAdapter(new NumberAdapter(words));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}