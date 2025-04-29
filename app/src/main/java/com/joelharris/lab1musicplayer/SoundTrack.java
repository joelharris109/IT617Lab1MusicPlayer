package com.joelharris.lab1musicplayer;

import android.content.Context;
import android.icu.lang.UProperty;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SoundTrack
{



    public SoundTrack()
    {
        ArrayList<String> copyright = new ArrayList<String>();

        String title;
        String artist;

    }

    MediaPlayer mediaPlayer = new MediaPlayer();

    public void Soundtrack1(Context context, View view) {
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer = MediaPlayer.create(context, R.raw.luke_bergs_tropical_soul);
            mediaPlayer.start();
        }
        else
        {
            mediaPlayer.pause();
        }
    }

    public void Soundtrack2(Context context, View view) {
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer = MediaPlayer.create(context, R.raw.maxkomusic_heroism);
            mediaPlayer.start();
        }
        else
        {
            mediaPlayer.pause();
        }
    }

    public void Soundtrack3(Context context, View view) {
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer = MediaPlayer.create(context, R.raw.powerful_trap);
            mediaPlayer.start();
        }
        else
        {
            mediaPlayer.pause();
        }
    }

    public void SoundtrackPause(Context context, View view)
    {
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.start();
        }
        else
        {
            mediaPlayer.pause();
        }
    }
}
