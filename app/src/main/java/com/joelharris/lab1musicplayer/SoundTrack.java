package com.joelharris.lab1musicplayer;

import android.media.MediaMetadataRetriever;
import android.net.Uri;

public class SoundTrack {

    String mediaPath;
    MediaMetadataRetriever mmr = new MediaMetadataRetriever();

    String title;

    String artist;
    String copyright;


    public SoundTrack()
    {
        mediaPath = String.valueOf(Uri.parse(String.valueOf(R.raw.luke_bergs_tropical_soul)));
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(mediaPath);

        title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    }
}
