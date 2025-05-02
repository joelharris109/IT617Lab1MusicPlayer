package com.joelharris.lab1musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

public class SoundTrack
{

    public static String CurrentSong;
    public SoundTrack()
    {

    }

    static MediaPlayer mediaPlayer = new MediaPlayer();

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void Soundtrack1(Context context) {
        mediaPlayer.stop();
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.luke_bergs_tropical_soul);
        mediaPlayer.start();
    }

    public void Soundtrack2(Context context) {
        mediaPlayer.stop();
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.maxkomusic_heroism);
        mediaPlayer.start();
    }

    public void Soundtrack3(Context context) {
        mediaPlayer.stop();
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
        }
    }
}
