package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //create a list of word
        ArrayList<LangData> words = new ArrayList<>();
        words.add(new LangData("one", "lutti", R.drawable.number_one));
        words.add(new LangData("two", "otiiko", R.drawable.number_two));
        words.add(new LangData("three", "tolookosu", R.drawable.number_three));
        words.add(new LangData("four", "oyyisa", R.drawable.number_four));
        words.add(new LangData("five", "massokka", R.drawable.number_five));
        words.add(new LangData("six", "temmokka", R.drawable.number_six));
        words.add(new LangData("seven", "kenekaku", R.drawable.number_seven));
        words.add(new LangData("eight", "kawinta", R.drawable.number_eight));
        words.add(new LangData("nine", "wo’e", R.drawable.number_nine));
        words.add(new LangData("ten", "na’aacha", R.drawable.number_ten));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        recyclerView.setAdapter(new NumberAdapter(words));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}