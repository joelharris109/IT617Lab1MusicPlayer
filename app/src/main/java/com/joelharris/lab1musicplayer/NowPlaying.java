package com.joelharris.lab1musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NowPlaying extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_now_playing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String songName = intent.getStringExtra("song_name");
        int trackId = intent.getIntExtra("track_id", -1);

        TextView song_name = findViewById(R.id.music_name);
        song_name.setText(songName);

        switch (trackId) {
            case 1:
                st.Soundtrack1(this, null);
                break;
            case 2:
                st.Soundtrack2(this, null);
                break;
            case 3:
                st.Soundtrack3(this, null);
                break;
            default:
                break;
        }
    }

    SoundTrack st = new SoundTrack();

    public void SoundtrackControl(View view)
    {
        st.SoundtrackPause(view);
    }

    public void SoundTrackStop(View view)
    {
        st.SoundtrackStop(view);
    }

    public void SoundTrackExit(View view)
    {
        finish();
    }

}