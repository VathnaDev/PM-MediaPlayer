package com.example.luther.androidmediaplayer;

import android.content.Context;
import android.media.MediaPlayer;

public class Note {
    public static void main(String[] args) {

        //Create Instance of MediaPlayer
        Context context = null; //Suppose this is the app context
        MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.song);

        //Start media Palyer
        mediaPlayer.start();
        mediaPlayer.reset();

        //Add Event for complete listener
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                //Do Something
            }
        });

        //



    }
}
