package com.example.laba5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
{
    final private String TAG = "MainActivity";

    VideoView MyvideoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyvideoPlayer =  (VideoView)findViewById(R.id.videoView);

        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video1);
        MyvideoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        MyvideoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(MyvideoPlayer);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                MyvideoPlayer.start();
            }
        });
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MyvideoPlayer.pause();
            }
        });

        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MyvideoPlayer.stopPlayback();
                MyvideoPlayer.resume();
            }
        });
    }
}