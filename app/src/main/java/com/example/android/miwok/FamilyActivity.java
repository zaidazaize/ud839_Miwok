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

public class FamilyActivity extends AppCompatActivity implements NumberAdapter.OnListItemClickedMiwok {

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
        ArrayList<LangData> words = new ArrayList<>();
        words.add(new LangData("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new LangData("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
        words.add(new LangData("son", "angsi", R.drawable.family_son,R.raw.family_son));
        words.add(new LangData("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new LangData("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new LangData("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new LangData("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new LangData("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new LangData("grandmother ", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new LangData("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        numberAdapter = new NumberAdapter(words, this);
        recyclerView.setAdapter(numberAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onListItemClicked(View view, int position) {
        cleanMediaResource();
        mediaPlayer = MediaPlayer.create(this,
                numberAdapter.getClickedWord(position).getmAudioResourseId());
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