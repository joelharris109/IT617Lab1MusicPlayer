package com.joelharris.lab1musicplayer;

import static com.joelharris.lab1musicplayer.SoundTrack.mediaPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NowPlaying extends AppCompatActivity {
    public static String songName;
    public static int trackId = -1;
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
        String tmpSongName =  intent.getStringExtra("song_name");
        if(tmpSongName != null){
            songName = intent.getStringExtra("song_name");
        }
        trackId = intent.getIntExtra("track_id", trackId);

        TextView song_name = findViewById(R.id.music_name);
        song_name.setText(songName);

        String string = "";
        StringBuilder stringBuilder = new StringBuilder();
        TextView copyright_info = findViewById(R.id.copyright_info);
        InputStream is;
        BufferedReader reader;

        switch (trackId) {
            case 1:
                mediaPlayer.stop();
                if(!mediaPlayer.isPlaying()) {
                    st.Soundtrack1(this);
                }
                is = this.getResources().openRawResource(R.raw.luke_bergs_tropical_soul_copyright);
                reader = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    try {
                        if ((string = reader.readLine()) == null) break;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    stringBuilder.append(string).append(" ");
                    copyright_info.setText(stringBuilder);
                }
                //is.close();
                break;
            case 2:
                mediaPlayer.stop();
                if(!mediaPlayer.isPlaying()) {
                    st.Soundtrack2(this);
                }
                is = this.getResources().openRawResource(R.raw.maxkomusic_heroism_copyright);
                reader = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    try {
                        if ((string = reader.readLine()) == null) break;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    stringBuilder.append(string).append(" ");
                    copyright_info.setText(stringBuilder);
                }
                //is.close();
                break;
            case 3:
                mediaPlayer.stop();
                st.Soundtrack3(this);
                is = this.getResources().openRawResource(R.raw.powerful_trap_copyright);
                reader = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    try {
                        if ((string = reader.readLine()) == null) break;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    stringBuilder.append(string).append(" ");
                    copyright_info.setText(stringBuilder);
                }
                //is.close();
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
        //mediaPlayer.release();
        trackId = -1;
        songName = null;
        st.SoundtrackStop(view);
        finish();
    }

    public void SoundTrackExit(View view)
    {
        finish();
    }

}