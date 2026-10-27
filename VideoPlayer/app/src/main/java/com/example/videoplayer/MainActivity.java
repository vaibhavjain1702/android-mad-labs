package com.example.videoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button playButton, pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);

        // Set video path from raw folder
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample_video;
        videoView.setVideoURI(Uri.parse(videoPath));

        // Play button listener
        playButton.setOnClickListener(v -> videoView.start());

        // Pause button listener
        pauseButton.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
            }
        });
    }
}