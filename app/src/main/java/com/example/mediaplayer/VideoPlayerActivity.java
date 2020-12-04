package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class VideoPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        ImageView ivPlayVideo = findViewById(R.id.ivPlayVideo);

        ivPlayVideo.setOnClickListener(view -> openVideo());
    }

    private void openVideo() {
        startActivity(new Intent(this, PlayerActivity.class));
    }
}