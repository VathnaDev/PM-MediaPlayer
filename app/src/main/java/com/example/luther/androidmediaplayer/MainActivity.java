package com.example.luther.androidmediaplayer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.luther.androidmediaplayer.custom.MusicPlayer;
import com.example.luther.androidmediaplayer.data.Pref;
import com.example.luther.androidmediaplayer.dummy.MusicFactory;
import com.example.luther.androidmediaplayer.fragments.SongListFragment;
import com.example.luther.androidmediaplayer.model.Song;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity implements SongListFragment.OnSongClickListener {

    //region Butter Knife
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
    @BindView(R.id.ivBackground)
    ImageView ivBackground;
    //endregion
    //region Public Constants
    public final String IS_REPEAT = "is_repeat";
    public final String IS_SHUFFLE = "is_shuffle";

    //endregion
    //region Global variable
    private ObjectAnimator animator;
    private SongListFragment songListFragment;
    private AudioManager audioManager;
    private Handler myHandler = new Handler();
    private MusicPlayer mMediaPlayer;
    //endregion

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //Remove status bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initialize();
    }

    @SuppressLint("DefaultLocale")
    private void initialize() {
        try {
            mMediaPlayer = MusicPlayer.newInstance();
            mMediaPlayer.setSongs(MusicFactory.getSongs(this));
            mMediaPlayer.setDataSource(this, mMediaPlayer.getSongs().get(0).getSongUri());
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

////        changeSong(0);
//        btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));
//
//
////        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
////        ivArtistProfile.startAnimation(rotateAnimation);
//
//
//        animator = ObjectAnimator.ofFloat(ivArtistProfile,"rotation",0f,360f);
//        animator.setDuration(5000);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatMode(ValueAnimator.RESTART);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.start();
//
//
//        tvEndTime.setText(String.format("%02d:%02d",
//                TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()),
//                TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getDuration()) -
//                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()))
//        ));
//
//        double startTime = 0;
//        seekbar.setProgress((int) startTime);
//        seekbar.setMax(mMediaPlayer.getDuration() / 1000);
//        seekbar.getThumb().mutate().setAlpha(0);
//
//        myHandler.postDelayed(UpdateSongTime, 1000);
//
//        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    mMediaPlayer.seekTo(progress * 1000);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        //Setup Volume SeekBar
//        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        skVolume.setMax(audioManager
//                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
//        skVolume.setProgress(audioManager
//                .getStreamVolume(AudioManager.STREAM_MUSIC));
//
//        skVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
//                            progress, 0);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

        //Restore User Settings
//        SharedPreferences pref = Pref.getSharedPreferences(this);
//        isShuffle = pref.getBoolean(IS_SHUFFLE, false);
//        isRepeat = pref.getBoolean(IS_REPEAT, false);
//
//        int color = isRepeat ? R.drawable.ic_repeat_one : R.drawable.ic_repeat;
//        btnRepeat.setImageDrawable(getResources().getDrawable(color));
//
//        color = isShuffle ? R.color.colorGreen : android.R.color.white;
//        btnShuffle.setImageTintList(getResources().getColorStateList(color));
        mMediaPlayer = MusicPlayer.newInstance();
        mMediaPlayer.setSongs(MusicFactory.getSongs(this));
        mMediaPlayer.changeSong(this, 0);
        updateSongUi();

        btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));
//        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
//        ivArtistProfile.startAnimation(rotateAnimation);

        animator = ObjectAnimator.ofFloat(ivArtistProfile, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();


        tvEndTime.setText(String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()))
        ));

        double startTime = 0;
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

        // Restore User Settings
        SharedPreferences pref = Pref.getSharedPreferences(this);
        mMediaPlayer.setShuffle(pref.getBoolean(IS_SHUFFLE, false));
        mMediaPlayer.setRepeat(pref.getBoolean(IS_REPEAT, false));

        int color = mMediaPlayer.isRepeat() ? R.drawable.ic_repeat_one : R.drawable.ic_repeat;
        btnRepeat.setImageDrawable(getResources().getDrawable(color));

        color = mMediaPlayer.isShuffle() ? R.color.colorGreen : android.R.color.white;
        btnShuffle.setImageTintList(getResources().getColorStateList(color));
    }

    @SuppressLint("DefaultLocale")
    private void updateSongUi() {
        Song currentPlayingSong = mMediaPlayer.getCurrentPlayingSong();
        tvArtistName.setText(currentPlayingSong.getArtistName());
        tvSongTitle.setText(currentPlayingSong.getTitle());
        Picasso.get()
                .load(currentPlayingSong.getArtistPhoto())
                .into(ivArtistProfile);
        Picasso.get()
                .load(currentPlayingSong.getArtistPhoto())
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        Blurry.with(MainActivity.this)
                                .sampling(1)
                                .color(Color.argb(66, 0, 200, 255))
                                .from(bitmap)
                                .into(ivBackground);
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        Log.d("TAG", "onBitmapFailed: " + e.getMessage());
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });

        tvEndTime.setText(String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()))
        ));
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
//        try {
//            currentPlayingSong = songs.get(songIndex);
//            mMediaPlayer.reset();
//            mMediaPlayer.setDataSource(this, currentPlayingSong.getSongUri());
//            mMediaPlayer.prepare();
//            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    mp.start();
//                }
//            });
//            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    if (isRepeat)
//                        changeSong(songIndex);
//                    else if (isShuffle) {
//                        changeSong(rand.nextInt(songs.size()));
//                    } else
//                        changeSong(songIndex + 1);
//                }
//            });
//
//            tvArtistName.setText(currentPlayingSong.getArtistName());
//            tvSongTitle.setText(currentPlayingSong.getTitle());
//            Picasso.get()
//                    .load(currentPlayingSong.getArtistPhoto())
//                    .into(ivArtistProfile);
//            Picasso.get()
//                    .load(currentPlayingSong.getArtistPhoto())
//                    .into(new Target() {
//                        @Override
//                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                            Blurry.with(MainActivity.this)
//                                    .sampling(1)
//                                    .color(Color.argb(66, 0, 200, 255))
//                                    .from(bitmap)
//                                    .into(ivBackground);
//                        }
//
//                        @Override
//                        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//                            Log.d("TAG", "onBitmapFailed: " + e.getMessage());
//                        }
//
//                        @Override
//                        public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//                        }
//                    });
//
//            tvEndTime.setText(String.format("%02d:%02d",
//                    TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()),
//                    TimeUnit.MILLISECONDS.toSeconds(mMediaPlayer.getDuration()) -
//                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mMediaPlayer.getDuration()))
//            ));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
            animator.pause();
            btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_circle));
        } else {
            mMediaPlayer.start();
            animator.resume();
            btnPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_circle));
        }
    }

    @OnClick(R.id.btnPre)
    public void onBtnPreClicked() {
//        int currentIndex = songs.indexOf(currentPlayingSong);
//        int preIndex = currentIndex - 1;
//        if (currentIndex == 0)
//            preIndex = songs.size() - 1;
//        changeSong(preIndex);
        mMediaPlayer.onPreviouseSong(this);
        updateSongUi();
    }

    @OnClick(R.id.btnNext)
    public void onBtnNextClicked() {
//        int currentIndex = songs.indexOf(currentPlayingSong);
//        int nextIndex = currentIndex + 1;
//        if (currentIndex == songs.size() - 1)
//            nextIndex = 0;
//        if(isShuffle){
//            nextIndex = rand.nextInt(songs.size());
//        }
//        changeSong(nextIndex);
        mMediaPlayer.onNextSong(this);
        updateSongUi();
    }

    @OnClick(R.id.btnRepeat)
    public void onBtnRepeatClicked() {
//        isRepeat = !isRepeat;
//        int iconId = isRepeat ? R.drawable.ic_repeat_one : R.drawable.ic_repeat;
//        btnRepeat.setImageDrawable(getResources().getDrawable(iconId));
        mMediaPlayer.setRepeat(!mMediaPlayer.isRepeat());
        int iconId = mMediaPlayer.isRepeat() ? R.drawable.ic_repeat_one : R.drawable.ic_repeat;
        btnRepeat.setImageDrawable(getResources().getDrawable(iconId));
    }

    @OnClick(R.id.btnSongList)
    public void onBtnSongListClicked() {
//        songListFragment = SongListFragment.instance(songs, currentPlayingSong);
//        songListFragment.show(getSupportFragmentManager(), "TAG");
        songListFragment = SongListFragment.instance(mMediaPlayer.getSongs(), mMediaPlayer.getCurrentPlayingSong());
        songListFragment.show(getSupportFragmentManager(), "TAG");
    }

    @Override
    public void onSongClicked(int index) {
//        changeSong(index);
//        songListFragment.notifySongChanged(currentPlayingSong);
        mMediaPlayer.changeSong(this, index);
        songListFragment.notifySongChanged(mMediaPlayer.getCurrentPlayingSong());
        updateSongUi();
    }

    @OnClick(R.id.btnShuffle)
    public void onViewClicked() {
//        isShuffle = !isShuffle;
//        int color = isShuffle ? R.color.colorGreen : android.R.color.white;
//        btnShuffle.setImageTintList(getResources().getColorStateList(color));
        mMediaPlayer.setShuffle(!mMediaPlayer.isShuffle());
        int color = mMediaPlayer.isShuffle() ? R.color.colorGreen : android.R.color.white;
        btnShuffle.setImageTintList(getResources().getColorStateList(color));
    }

    @Override
    protected void onStop() {
        super.onStop();
//        //Save user settings
//        SharedPreferences.Editor editor = Pref.getEditor(this);
//        editor.putBoolean(IS_REPEAT, isRepeat);
//        editor.putBoolean(IS_SHUFFLE, isShuffle);
//        editor.commit();
        //Save user settings
        SharedPreferences.Editor editor = Pref.getEditor(this);
        editor.putBoolean(IS_REPEAT, mMediaPlayer.isRepeat());
        editor.putBoolean(IS_SHUFFLE, mMediaPlayer.isRepeat());
        editor.commit();
    }

}
