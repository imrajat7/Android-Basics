package com.example.android.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song song = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        ViewHolder holder = new ViewHolder();
        holder.songTextView = (TextView) convertView.findViewById(R.id.song_text_view);
        holder.songTextView.setText(song.getSongName());
        holder.artistTextView = (TextView) convertView.findViewById(R.id.artist_text_view);
        holder.artistTextView.setText(song.getArtistName());
        convertView.setTag(holder);

        return convertView;
    }

    static class ViewHolder {
        TextView songTextView;
        TextView artistTextView;
    }
}