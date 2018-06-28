package com.example.rahulyiet.services;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stop,resume;
    MediaPlayer mediaplayer;

    String order =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        stop=findViewById(R.id.stop);
        resume=findViewById(R.id.resume);

        //Intially disable the button



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent intent=new Intent(MainActivity.this,MyService.class);
              order="play";
              intent.putExtra("order",order);
              startService(intent);



              play.setEnabled(false);
              resume.setEnabled(false);
              pause.setEnabled(true);
              stop.setEnabled(true);



            }
        });

         stop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 stop.setEnabled(false);
                 resume.setEnabled(false);

                 pause.setEnabled(true);
                 play.setEnabled(true);
                stopService(new Intent(MainActivity.this,MyService.class));


             }
         });
          pause.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(MainActivity.this,MyService.class);
                  order="pause";
                  intent.putExtra("order",order);
                  startService(intent);

                  pause.setEnabled(false);
                  stop.setEnabled(true);
                  play.setEnabled(false);
                  resume.setEnabled(true);


                  play.setEnabled(true);
              }


          });

            resume.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resume.setEnabled(false);
                    pause.setEnabled(true);
                    play.setEnabled(true);
                    stop.setEnabled(true);

                }
            });

    }
}
