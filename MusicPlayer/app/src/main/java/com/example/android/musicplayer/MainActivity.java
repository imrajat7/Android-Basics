package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.song1), getString(R.string.artist1)));
        songs.add(new Song(getString(R.string.song2), getString(R.string.artist2)));
        songs.add(new Song(getString(R.string.song3), getString(R.string.artist3)));
        songs.add(new Song(getString(R.string.song4), getString(R.string.artist4)));
        songs.add(new Song(getString(R.string.song5), getString(R.string.artist5)));
        songs.add(new Song(getString(R.string.song6), getString(R.string.artist6)));
        songs.add(new Song(getString(R.string.song7), getString(R.string.artist7)));
        songs.add(new Song(getString(R.string.song8), getString(R.string.artist8)));
        songs.add(new Song(getString(R.string.song9), getString(R.string.artist9)));
        songs.add(new Song(getString(R.string.song10), getString(R.string.artist10)));
        songs.add(new Song(getString(R.string.song11), getString(R.string.artist11)));
        songs.add(new Song(getString(R.string.song12), getString(R.string.artist12)));
        songs.add(new Song(getString(R.string.song13), getString(R.string.artist13)));
        songs.add(new Song(getString(R.string.song14), getString(R.string.artist14)));
        songs.add(new Song(getString(R.string.song15), getString(R.string.artist15)));
        songs.add(new Song(getString(R.string.song16), getString(R.string.artist16)));
        songs.add(new Song(getString(R.string.song17), getString(R.string.artist17)));
        songs.add(new Song(getString(R.string.song18), getString(R.string.artist18)));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song s = songs.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("SONG", s);

                Intent intent = new Intent(getBaseContext(), DescriptionActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}