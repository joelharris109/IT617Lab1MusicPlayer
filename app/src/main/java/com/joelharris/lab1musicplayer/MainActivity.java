package com.joelharris.lab1musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    public String song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.action_playing);
        setSupportActionBar(toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_playing){
            Intent intent = new Intent(this, NowPlaying.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    SoundTrack st = new SoundTrack();
    NowPlaying np = new NowPlaying();

    public void Soundtrack1(View view) {
        setContentView(R.layout.activity_now_playing);
        st.Soundtrack1(this, view);
        TextView song_name = findViewById(R.id.music_name);
        song_name.setText("Tropical Soul");
    }

    public void Soundtrack2(View view) {
        setContentView(R.layout.activity_now_playing);
        st.Soundtrack2(this, view);
        TextView song_name = findViewById(R.id.music_name);
        song_name.setText("Heroism");
    }

    public void Soundtrack3(View view) {
        setContentView(R.layout.activity_now_playing);
        st.Soundtrack3(this, view);
        TextView song_name = findViewById(R.id.music_name);
        song_name.setText("Powerful Trap");
    }

    public void SoundtrackControl(View view)
    {
        st.SoundtrackPause(view);
    }

    public void SoundTrackStop(View view)
    {
        st.SoundtrackStop(view);
        setContentView(R.layout.activity_main);
    }

}