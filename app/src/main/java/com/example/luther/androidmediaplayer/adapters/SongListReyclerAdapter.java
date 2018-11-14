package com.example.luther.androidmediaplayer.adapters;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luther.androidmediaplayer.R;
import com.example.luther.androidmediaplayer.fragments.SongListFragment;
import com.example.luther.androidmediaplayer.model.Song;

import java.util.List;

public class SongListReyclerAdapter extends RecyclerView.Adapter<SongListReyclerAdapter.ViewHolder> {

    private List<Song> songList;
    private SongListFragment.OnSongClickListener onSongClickListener;
    public SongListReyclerAdapter(List<Song> songs, SongListFragment.OnSongClickListener songClickListener){
        this.songList = songs;
        this.onSongClickListener = songClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Song song = songList.get(i);
        final int index = i;
        viewHolder.tvSongTitle.setText(song.getTitle());
        viewHolder.tvArtistName.setText(song.getArtistName());
        viewHolder.songItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSongClickListener.onSongClicked(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvSongTitle = itemView.findViewById(R.id.tvSongTitle);
        TextView tvArtistName = itemView.findViewById(R.id.tvArtistName);
        ConstraintLayout songItemLayout = itemView.findViewById(R.id.song_item_layout);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
