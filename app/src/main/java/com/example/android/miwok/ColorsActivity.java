package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity implements NumberAdapter.OnListItemClickedMiwok{

    NumberAdapter numberAdapter;
    MediaPlayer mediaPlayer ;
//    AudioManager audioManager  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        // Create a list of words
        ArrayList<LangData> words = new ArrayList<>();
        words.add(new LangData("red", "weṭeṭṭi", R.drawable.color_red,R.raw.color_red));
        words.add(new LangData("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new LangData("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new LangData("green", "chokokki", R.drawable.color_green,R.raw.color_green));
        words.add(new LangData("brown", "ṭakaakki", R.drawable.color_brown,R.raw.color_brown));
        words.add(new LangData("gray", "ṭopoppi", R.drawable.color_gray,R.raw.color_gray));
        words.add(new LangData("black", "kululli", R.drawable.color_black,R.raw.color_black));
        words.add(new LangData("white", "kelelli", R.drawable.color_white,R.raw.color_white));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);

        /*number adapter object declaration*/
        numberAdapter = new NumberAdapter(words,this);
        recyclerView.setAdapter(numberAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onListItemClicked(View view, int resourseId) {
        cleanMediaResource();
        mediaPlayer = MediaPlayer.create(this,
                numberAdapter.getClickedWord(resourseId).getmAudioResourseId());
        //Clear the resources when mediaPlayer finishes playing.
        mediaPlayer.setOnCompletionListener(mp -> cleanMediaResource());
        mediaPlayer.start();
    }

    /**
     * clean up the media player by releasing the resource.
     */
    private void cleanMediaResource() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        cleanMediaResource();
    }
}