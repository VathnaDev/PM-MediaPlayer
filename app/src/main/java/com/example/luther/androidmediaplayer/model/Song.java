package com.example.luther.androidmediaplayer.model;

import android.net.Uri;

public class Song {
    private String title;
    private String artistName;
    private String artistPhoto;
    private Uri songUri;

    public Song() {
    }

    public Song(String title, String artistName, String artistPhoto, Uri songUri) {
        this.title = title;
        this.artistName = artistName;
        this.artistPhoto = artistPhoto;
        this.songUri = songUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistPhoto() {
        return artistPhoto;
    }

    public void setArtistPhoto(String artistPhoto) {
        this.artistPhoto = artistPhoto;
    }

    public Uri getSongUri() {
        return songUri;
    }

    public void setSongUri(Uri songUri) {
        this.songUri = songUri;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artistName='" + artistName + '\'' +
                ", artistPhoto='" + artistPhoto + '\'' +
                ", songUri=" + songUri +
                '}';
    }
}
