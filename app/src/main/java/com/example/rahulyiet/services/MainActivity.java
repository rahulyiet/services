package com.example.rahulyiet.services;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stop;
    MediaPlayer myplayer;
    int length;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        stop=findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myplayer = MediaPlayer.create(MainActivity.this,R.raw.song);
                if(myplayer.isPlaying()){

                }else{
                    myplayer.seekTo(length);
                    myplayer.start();
                }


            }
        });


          pause.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                 myplayer.pause();
                 length = myplayer.getCurrentPosition();
              }
          });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myplayer.stop();
            }
        });

    }
}
