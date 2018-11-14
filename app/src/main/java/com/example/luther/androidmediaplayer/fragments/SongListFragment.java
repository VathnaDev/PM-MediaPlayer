package com.example.luther.androidmediaplayer.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luther.androidmediaplayer.R;
import com.example.luther.androidmediaplayer.adapters.SongListReyclerAdapter;
import com.example.luther.androidmediaplayer.model.Song;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class SongListFragment extends BottomSheetDialogFragment {
    private OnSongClickListener listener;
    private static SongListFragment instance;
    private static List<Song> songs;
    private static Song currentPlayingSong;
    private SongListReyclerAdapter adapter;
    private RecyclerView rvSongList;
    private View contentView;
    private ImageView ivArtist;
    private TextView tvSongTitle;
    private TextView tvArtistName;


    @SuppressLint("RestrictedApi")
    @Override

    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        contentView = View.inflate(getContext(), R.layout.song_list_layout, null);
        dialog.setContentView(contentView);

        rvSongList = contentView.findViewById(R.id.rvSongList);
        ivArtist = contentView.findViewById(R.id.ivArtist);
        tvSongTitle = contentView.findViewById(R.id.tvSongTitle);
        tvArtistName = contentView.findViewById(R.id.tvArtistName);

        adapter = new SongListReyclerAdapter(songs,listener);
        rvSongList.setAdapter(adapter);
        rvSongList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        tvArtistName.setText(currentPlayingSong.getArtistName());
        tvSongTitle.setText(currentPlayingSong.getTitle());
        Picasso.get()
                .load(currentPlayingSong.getArtistPhoto())
                .into(ivArtist);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnSongClickListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " must implement OnSongClickListener");
        }
    }

    public static SongListFragment instance(List<Song> songList, Song currentSong) {
        songs = songList;
        currentPlayingSong = currentSong;
        if (instance == null)
            instance = new SongListFragment();
        return instance;
    }

    public void notifySongChanged(Song song){
        currentPlayingSong = song;
        tvArtistName.setText(currentPlayingSong.getArtistName());
        tvSongTitle.setText(currentPlayingSong.getTitle());
        Picasso.get()
                .load(currentPlayingSong.getArtistPhoto())
                .into(ivArtist);

    }

    public interface OnSongClickListener{
        void onSongClicked(int index);
    }
}
