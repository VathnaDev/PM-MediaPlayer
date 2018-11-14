package com.example.luther.androidmediaplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.luther.androidmediaplayer.data.Pref;
import com.example.luther.androidmediaplayer.dummy.MusicFactory;
import com.example.luther.androidmediaplayer.fragments.SongListFragment;
import com.example.luther.androidmediaplayer.model.Song;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity implements SongListFragment.OnSongClickListener {

    @BindView(R.id.ivArtistProfile)
    CircleImageView ivArtistProfile;
    @BindView(R.id.tvSongTitle)
    TextView tvSongTitle;
    @BindView(R.id.tvArtistName)
    TextView tvArtistName;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.btnPlay)
    ImageButton btnPlay;
    @BindView(R.id.btnPre)
    ImageButton btnPre;
    @BindView(R.id.btnNext)
    ImageButton btnNext;
    @BindView(R.id.rootLayout)
    ConstraintLayout rootLayout;
    @BindView(R.id.btnRepeat)
    ImageButton btnRepeat;
    @BindView(R.id.btnSongList)
    ImageButton btnSongList;
    @BindView(R.id.skVolume)
    SeekBar skVolume;
    @BindView(R.id.btnShuffle)
    ImageButton btnShuffle;

    public final String IS_REPEAT = "is_repeat";
    public final String IS_SHUFFLE = "is_shuffle";

    private SongListFragment songListFragment;
    private AudioManager audioManager;
    private MediaPlayer mMediaPlayer;
    private Handler myHandler = new Handler();
    private Song currentPlayingSong;
    private List<Song> songs;
    private boolean isRepeat;
    private boolean isShuffle;
    private double startTime = 0;
    private double finalTime = 0;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initialize();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AudioManager audio = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            skVolume.setProgress(currentVolume + 1);
            return false;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            skVolume.setProgress(currentVolume - 1);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("DefaultLocale")
    private void changeSong(final int songIndex) {
        try {
            currentPlayingSong = songs.get(songIndex);
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(this, currentPlayingSong.getSongUri());
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (isRepeat)
                        changeSong(songIndex);
                    else if (isShuffle) {
                        Random rand = new Random();
                        int n = rand.nextInt(songs.size());
                        changeSong(n);
                    } else
                        changeSong(songIndex + 1);
                }
            });

            tvArtistName.setText(currentPlayingSong.getArtistName());
            tvSongTitle.setText(currentPlayingSong.getTitle());
            Picasso.get()
                    .load(currentPlayingSong.getArtistPhoto())
                    .into(ivArtistProfile);

            tvEndTime.setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()),
                    TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getDuration()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()))
            ));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("DefaultLocale")
    private void initialize() {
        songs = MusicFactory.getSongs(this);
        mMediaPlayer = MediaPlayer.create(this, songs.get(0).getSongUri());
        changeSong(0);
        btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));

        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        ivArtistProfile.startAnimation(rotateAnimation);

        tvArtistName.setText(currentPlayingSong.getArtistName());
        tvSongTitle.setText(currentPlayingSong.getTitle());
        Picasso.get()
                .load(currentPlayingSong.getArtistPhoto())
                .into(ivArtistProfile);

        tvEndTime.setText(String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()))
        ));

        seekbar.setProgress((int) startTime);
        seekbar.setMax(mMediaPlayer.getDuration() / 1000);
        seekbar.getThumb().mutate().setAlpha(0);

        myHandler.postDelayed(UpdateSongTime, 1000);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Setup Volume SeekBar
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        skVolume.setMax(audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        skVolume.setProgress(audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC));

        skVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Restore User Settings
        SharedPreferences pref = Pref.getSharedPreferences(this);
        isShuffle = pref.getBoolean(IS_SHUFFLE, false);
        isRepeat = pref.getBoolean(IS_REPEAT, false);

        int color = isRepeat ? R.drawable.ic_repeat_one : R.drawable.ic_repeat;
        btnRepeat.setImageDrawable(getResources().getDrawable(color));

        color = isShuffle ? R.color.colorGreen : android.R.color.white;
        btnShuffle.setImageTintList(getResources().getColorStateList(color));
    }

    private Runnable UpdateSongTime = new Runnable() {
        @SuppressLint("DefaultLocale")
        @Override
        public void run() {
            int currentPosition = mMediaPlayer.getCurrentPosition() / 1000;
            seekbar.setProgress(currentPosition);
            tvStartTime.setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getCurrentPosition()),
                    TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getCurrentPosition()) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getCurrentPosition()))
            ));
            myHandler.postDelayed(this, 1000);
        }
    };

    @OnClick(R.id.btnPlay)
    public void onBtnPlayClicked() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_circle));
        } else {
            mMediaPlayer.start();
            btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));
        }
    }

    @OnClick(R.id.btnPre)
    public void onBtnPreClicked() {
        int currentIndex = songs.indexOf(currentPlayingSong);
        int preIndex = currentIndex - 1;
        if (currentIndex == 0)
            preIndex = songs.size() - 1;
        changeSong(preIndex);
    }

    @OnClick(R.id.btnNext)
    public void onBtnNextClicked() {
        int currentIndex = songs.indexOf(currentPlayingSong);
        int nextIndex = currentIndex + 1;
        if (currentIndex == songs.size() - 1)
            nextIndex = 0;
        changeSong(nextIndex);
    }

    @OnClick(R.id.btnRepeat)
    public void onBtnRepeatClicked() {
        isRepeat = !isRepeat;
        int iconId = isRepeat ? R.drawable.ic_repeat_one : R.drawable.ic_repeat;
        btnRepeat.setImageDrawable(getResources().getDrawable(iconId));
    }

    @OnClick(R.id.btnSongList)
    public void onBtnSongListClicked() {
        songListFragment = SongListFragment.instance(songs, currentPlayingSong);
        songListFragment.show(getSupportFragmentManager(), "TAG");
    }


    @Override
    public void onSongClicked(int index) {
        changeSong(index);
        songListFragment.notifySongChanged(currentPlayingSong);
    }

    @OnClick(R.id.btnShuffle)
    public void onViewClicked() {
        isShuffle = !isShuffle;
        int color = isShuffle ? R.color.colorGreen : android.R.color.white;
        btnShuffle.setImageTintList(getResources().getColorStateList(color));
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Save user settings
        SharedPreferences.Editor editor = Pref.getEditor(this);
        editor.putBoolean(IS_REPEAT, isRepeat);
        editor.putBoolean(IS_SHUFFLE, isShuffle);
        editor.commit();
    }

}
