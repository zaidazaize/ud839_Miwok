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

        //create a list of word
        ArrayList<LangData> dataSourse = new ArrayList<>();
        for(int i=0;i<10;i++){
            dataSourse.add(new LangData(Integer.toString(i)));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        recyclerView.setAdapter(new NumberAdapter(dataSourse));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}