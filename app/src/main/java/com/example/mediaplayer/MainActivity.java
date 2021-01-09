package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar volumeSeekBar;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pix_mu_01a_new_day_begins);

        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnPause = findViewById(R.id.btnPause);
        Button btnStop = findViewById(R.id.btnStop);
        Button btnGoToVideoPlayer = findViewById(R.id.btnGoToVideoPlayer);
        Button btnGoToUserPreferences = findViewById(R.id.btnGoToUserPreferences);
        Button btnGoToMyNotes= findViewById(R.id.btnGoToMyNotes);
        btnPlay.setOnClickListener(view -> playSound());
        btnPause.setOnClickListener(view -> pauseSound());
        btnStop.setOnClickListener(view -> stopSound());
        btnGoToVideoPlayer.setOnClickListener(view -> goGoVideoPlayerScreen());
        btnGoToUserPreferences.setOnClickListener(view -> goGoUserPreferencesScreen());
        btnGoToMyNotes.setOnClickListener(view -> goGoMyNotes());

        initVolumeSeekBar();
    }

    private void initVolumeSeekBar() {
        volumeSeekBar = findViewById(R.id.seekVolume);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVoume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setProgress(currentVoume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void pauseSound() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stopSound() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pix_mu_01a_new_day_begins);
        }
    }

    public void goGoVideoPlayerScreen() {
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void goGoUserPreferencesScreen() {
        startActivity(new Intent(this, UserPreferencesActivity.class));
    }

    public void goGoMyNotes() {
        startActivity(new Intent(this, MyNotesActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopSound();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}