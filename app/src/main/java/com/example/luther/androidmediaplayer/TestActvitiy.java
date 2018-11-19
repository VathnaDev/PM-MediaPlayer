package com.example.luther.androidmediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luther.androidmediaplayer.custom.MusicPlayer;
import com.example.luther.androidmediaplayer.dummy.MusicFactory;
import com.example.luther.androidmediaplayer.model.Song;

import java.io.IOException;
import java.util.List;

public class TestActvitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_actvitiy);
    }

    @Override
    protected void onStart() {
        super.onStart();
                    MusicPlayer mMediaPlayer = MusicPlayer.newInstance();
        List<Song> songs=(MusicFactory.getSongs(this));

        try {
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDataSource(this,Uri.parse("android.resource://"+getPackageName()+"/raw/song"));
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
