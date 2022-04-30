package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        //create a list of word
        // Create a list of words
        Log.d("phrases activity", "before array");
        ArrayList<LangData> words = new ArrayList<>();
        words.add(new LangData("Where are you going?", "minto wuksus"));
        words.add(new LangData("What is your name?", "tinnә oyaase'nә"));
        words.add(new LangData("My name is...", "oyaaset..."));
        words.add(new LangData("How are you feeling?", "michәksәs?"));
        words.add(new LangData("I’m feeling good.", "kuchi achit"));
        words.add(new LangData("Are you coming?", "әәnәs'aa?"));
        words.add(new LangData("Yes, I’m coming.", "hәә’ әәnәm"));
        words.add(new LangData("I’m coming.", "әәnәm"));
        words.add(new LangData("Let’s go.", "yoowutis"));
        words.add(new LangData("Come here.", "әnni'nem"));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        Log.d("phrases activity", "after recycler view");
        recyclerView.setAdapter(new NumberAdapter(words));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("phrases activity", "after layoutmanager view");

    }
}