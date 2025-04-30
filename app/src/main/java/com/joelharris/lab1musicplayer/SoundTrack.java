package com.joelharris.lab1musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.View;

import java.util.ArrayList;

public class SoundTrack
{
    public String title;
    public String artist;

    public SoundTrack()
    {
        ArrayList<String> copyright = new ArrayList<String>();

        //String title;
        //String artist;
    }

    MediaPlayer mediaPlayer = new MediaPlayer();

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void Soundtrack1(Context context, View view) {
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.luke_bergs_tropical_soul);
        mediaPlayer.start();
    }

    public void Soundtrack2(Context context, View view) {
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.maxkomusic_heroism);
        mediaPlayer.start();
    }

    public void Soundtrack3(Context context, View view) {
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.powerful_trap);
        mediaPlayer.start();
    }

    public void SoundtrackPause(View view)
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

    public void SoundtrackStop(View view)
    {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            releaseMediaPlayer();
        }
    }
}
