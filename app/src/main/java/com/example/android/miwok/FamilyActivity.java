package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        //create a list of word
        ArrayList<LangData> words = new ArrayList<LangData>();
        words.add(new LangData("father", "әpә", R.drawable.family_father));
        words.add(new LangData("mother", "әṭa", R.drawable.family_mother));
        words.add(new LangData("son", "angsi", R.drawable.family_son));
        words.add(new LangData("daughter", "tune", R.drawable.family_daughter));
        words.add(new LangData("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new LangData("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new LangData("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new LangData("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new LangData("grandmother ", "ama", R.drawable.family_grandmother));
        words.add(new LangData("grandfather", "paapa", R.drawable.family_grandfather));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        recyclerView.setAdapter(new NumberAdapter(words));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}