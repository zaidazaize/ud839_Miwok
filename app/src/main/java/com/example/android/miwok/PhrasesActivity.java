package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity implements NumberAdapter.OnListItemClickedMiwok  {

    /**
     *Global mediaplayer object for playing audio clips.
     */
    MediaPlayer mediaPlayer;
    /**
     * global adapter for recycleview
     */
    NumberAdapter numberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        //create a list of word
        // Create a list of words
        ArrayList<LangData> words = new ArrayList<>();
        words.add(new LangData("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new LangData("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new LangData("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        words.add(new LangData("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new LangData("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new LangData("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new LangData("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new LangData("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        words.add(new LangData("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new LangData("Come here.", "әnni'nem",R.raw.phrase_come_here));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        numberAdapter = new NumberAdapter(words, this);
        recyclerView.setAdapter(new NumberAdapter(words,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onListItemClicked(View view, int position) {
        cleanMediaResource();
        mediaPlayer = MediaPlayer.create(this,
                numberAdapter.getClickedWord(position).getmAudioResourseId());
        mediaPlayer.setOnCompletionListener(mp -> cleanMediaResource());
        mediaPlayer.start();
    }


    /**
     * clean up the media player by releasing the resource.
     */
    private void cleanMediaResource() {
        // If the media player is not null, then it may be currently playing a sound
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}