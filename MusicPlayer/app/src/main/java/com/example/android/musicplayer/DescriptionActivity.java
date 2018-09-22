package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView sgName, arName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        sgName = findViewById(R.id.song_name_in_descp);
        arName = findViewById(R.id.artist_name_in_descp);

        Bundle bundle = getIntent().getExtras();
        Song s = (Song) bundle.getSerializable("SONG");

        sgName.setText("SONG : " + s.getSongName());
        arName.setText("ARTIST : " + s.getArtistName());

        TextView nowPlayingTextView = findViewById(R.id.now_playing);
        nowPlayingTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowPlayingIntent = new Intent(DescriptionActivity.this, PlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });
    }
}