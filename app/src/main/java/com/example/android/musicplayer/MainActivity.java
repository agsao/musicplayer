package com.example.android.musicplayer;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.musicplayer.R;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer ;
//    private int length = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        releaseMediaPlayer();

        Button playButton = (Button) findViewById(R.id.play_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);

        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                if (mediaPlayer ==null) {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.maryam);}

//                mediaPlayer.seekTo(length);
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                        releaseMediaPlayer();
                    } // end of OnCompletion method
                }); // end of setOnCompletionListener constructor
            } // end of Onclick method
        }); // end of setOnClickListener constructor

        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
//                length = mediaPlayer.getCurrentPosition();
                mediaPlayer.pause();
            }
        }); // end of setOnClickListener constructor
    } // end of Create Method
    private void releaseMediaPlayer(){ // Release Method declaration
        if (mediaPlayer !=null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    } // End of Release Method
}