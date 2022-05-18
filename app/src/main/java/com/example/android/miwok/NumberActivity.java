package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.android.miwok.adapter.NumberAdapter;
import com.example.android.miwok.dataclass.LangData;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NumberActivity extends AppCompatActivity implements NumberAdapter.OnListItemClickedMiwok {

    /**
     *Global mediaplayer object for playing audio clips.
     */
    MediaPlayer mediaPlayer;
    /**
     * global adapter for recycleview
     */
    NumberAdapter numberAdapter;

    /**
     * Global Audio manager variable
     */
//    AudioManager audioManager;

//    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
//            new AudioManager.OnAudioFocusChangeListener() {
//                @Override
//                public void onAudioFocusChange(int focusChange) {
//                    //we have gain the audio focus start palying the sound
//                    if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                        mediaPlayer.start();
//                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
//                        //we have lost the focus pause the sound and restart again.
//                        mediaPlayer.pause();
//                        mediaPlayer.seekTo(0);
//                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                        //we have lost the focus clean the resources.
//                        cleanMediaResource();
//                    }
//
//                }
//            };

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        context = this;

        //Initialise the audio manager
//        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        //create a list of word
        ArrayList<LangData> words = new ArrayList<>();
        words.add(new LangData("one", "lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new LangData("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new LangData("three", "tolookosu", R.drawable.number_three,R.raw.number_three));
        words.add(new LangData("four", "oyyisa", R.drawable.number_four,R.raw.number_four));
        words.add(new LangData("five", "massokka", R.drawable.number_five,R.raw.number_five));
        words.add(new LangData("six", "temmokka", R.drawable.number_six,R.raw.number_six));
        words.add(new LangData("seven", "kenekaku", R.drawable.number_seven,R.raw.number_six));
        words.add(new LangData("eight", "kawinta", R.drawable.number_eight,R.raw.number_seven));
        words.add(new LangData("nine", "wo’e", R.drawable.number_nine,R.raw.number_eight));
        words.add(new LangData("ten", "na’aacha", R.drawable.number_ten,R.raw.number_nine));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.numbersrecycleview);
        Log.d("numberActivity", "words done");
        numberAdapter = new NumberAdapter(words,this);
        recyclerView.setAdapter(numberAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("numberActivity", "numberAdapter");
    }

    @Override
    public void onListItemClicked(View view, int position) {
        cleanMediaResource();

        //Initialise the media player with the audio resource file.
        mediaPlayer = MediaPlayer.create(this,
                numberAdapter.getClickedWord(position).getmAudioResourseId());

        //Free the resource when media player is done playing.
        mediaPlayer.setOnCompletionListener(mp -> cleanMediaResource());

        //Start playing
        mediaPlayer.start();

        //Request the audio focus for playing the music.
//        audioManager.requestAudioFocus(audioFocusChangeListener,
//                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

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
//            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    /**
     *Release the resources when activity stops.
     */
    @Override
    protected void onStop() {
        super.onStop();
        cleanMediaResource();
    }
}