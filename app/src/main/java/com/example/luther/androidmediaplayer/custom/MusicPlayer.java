package com.example.luther.androidmediaplayer.custom;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

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
        if (instance == null) {
            instance = new MusicPlayer();
            instance.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        return instance;
    }

    public void changeSong(final Context context, final int songIndex) {
        try {
            if (songs.size() == 0) return;
            reset();
            currentPlayingSong = songs.get(songIndex);
            setDataSource(context, currentPlayingSong.getSongUri());
            prepare();
            setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (isRepeat)
                        changeSong(context, songIndex);
                    else if (isShuffle) {
                        changeSong(context, rand.nextInt(songs.size()));
                    } else
                        changeSong(context, songIndex + 1);
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onNextSong(Context context) {
        int currentIndex = songs.indexOf(currentPlayingSong);
        int nextIndex = currentIndex + 1;
        if (currentIndex == getSongs().size() - 1)
            nextIndex = 0;
        if (isShuffle) {
            nextIndex = rand.nextInt(songs.size());
        }
        changeSong(context, nextIndex);
    }

    public void onPreviouseSong(Context context) {
        int currentIndex = songs.indexOf(currentPlayingSong);
        int preIndex = currentIndex - 1;
        if (currentIndex == 0)
            preIndex = getSongs().size() - 1;
        changeSong(context, preIndex);
    }

    public Song getCurrentPlayingSong() {
        return currentPlayingSong;
    }

    public void setSongs(List<Song> songs) {
        this.songs.clear();
        this.songs.addAll(songs);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public int getCurrentSongIndex() {
        if (songs != null && songs.size() > 0) {
            return songs.indexOf(currentPlayingSong);
        }
        return 0;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public boolean isShuffle() {
        return isShuffle;
    }

    public void setShuffle(boolean shuffle) {
        isShuffle = shuffle;
    }
}
