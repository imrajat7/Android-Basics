package com.example.android.musicplayer;

import android.widget.TextView;

import java.io.Serializable;

public class Song implements Serializable {

    public String songName;
    public String artistName;

    public Song(String sName, String aName) {
        songName = sName;
        artistName = aName;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }
}