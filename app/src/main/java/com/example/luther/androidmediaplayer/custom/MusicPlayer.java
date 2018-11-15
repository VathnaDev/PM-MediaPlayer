package com.example.luther.androidmediaplayer.custom;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.luther.androidmediaplayer.R;
import com.example.luther.androidmediaplayer.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer extends MediaPlayer {
    private static MusicPlayer instance;

    private boolean isRepeat;
    private boolean isShuffle;

    private List<Song> songs;

    private Song currentPlayingSong;
    private Random rand;

    private MusicPlayer() {
        songs = new ArrayList<>();
        currentPlayingSong = new Song();
        rand = new Random();
    }

    public static MusicPlayer newInstance() {
        if (instance == null){
            instance = new MusicPlayer();
            instance.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        return instance;
    }

    public void setSongs(List<Song> songs) {
        this.songs.clear();
        this.songs.addAll(songs);
    }

    public List<Song> getSongs() {
        return songs;
    }
}
