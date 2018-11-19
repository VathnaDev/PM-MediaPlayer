package com.example.luther.androidmediaplayer.dummy;

import android.content.Context;
import android.net.Uri;

import com.example.luther.androidmediaplayer.model.Song;

import java.util.ArrayList;
import java.util.List;

public class MusicFactory {
    public static List<Song> getSongs(Context context){
        List<Song> songs = new ArrayList<>();
        songs.add(
                new Song("Wrecking ball",
                        "Miley Cyrus",
                        "https://www.usmagazine.com/wp-content/uploads/2018/11/miely-cyrus-fire.jpg?w=300",
                        Uri.parse("android.resource://"+context.getPackageName()+"/raw/wreckingball"))
        );
        songs.add(
                new Song("Kiss You",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/kissyou"))
        );
        songs.add(
                new Song("Come and Get it",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comeandgetit"))
        );
        songs.add(
                new Song("Come back to me",
                        "Unknow",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comebacktome"))
        );
        songs.add(
                new Song("Let her go ",
                        "Passenger",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJqpnFAfbZHyfGAHFvtLmTHcSgMY9dnhaEfXMnD1_5GfIvPdpD",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/lethergo"))
        );
        songs.add(
                new Song("Love yo like a love song",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/loveyoulikealovesong"))
        );
        songs.add(
                new Song("Slow Down",
                        "Selena Gomez",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/slowdon"))
        );songs.add(
                new Song("Thai Song",
                        "GestureNova",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/song"))
        );songs.add(
                new Song("Story of my life",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/storyofmylife"))
        );
        songs.add(
                new Song("Take your shirt off",
                        "T-Pain",
                        "https://www.billboard.com/files/styles/article_main_image/public/media/t-pain-2017-billboard-cr-DirectedByBANK-1548.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/takeyourshirtoff"))
        );

        songs.add(
                new Song("T.H.E",
                        "Will i am",
                        "https://i.pinimg.com/originals/0b/cf/83/0bcf83cb7023934f37aaad23f444dd5c.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/the"))
        );



        songs.add(
                new Song("Wrecking ball",
                        "Miley Cyrus",
                        "https://www.usmagazine.com/wp-content/uploads/2018/11/miely-cyrus-fire.jpg?w=300",
                        Uri.parse("android.resource://"+context.getPackageName()+"/raw/wreckingball"))
        );
        songs.add(
                new Song("Kiss You",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/kissyou"))
        );
        songs.add(
                new Song("Come and Get it",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comeandgetit"))
        );
        songs.add(
                new Song("Come back to me",
                        "Unknow",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comebacktome"))
        );
        songs.add(
                new Song("Let her go ",
                        "Passenger",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJqpnFAfbZHyfGAHFvtLmTHcSgMY9dnhaEfXMnD1_5GfIvPdpD",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/lethergo"))
        );
        songs.add(
                new Song("Love yo like a love song",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/loveyoulikealovesong"))
        );
        songs.add(
                new Song("Slow Down",
                        "Selena Gomez",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/slowdon"))
        );songs.add(
                new Song("Thai Song",
                        "GestureNova",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/song"))
        );songs.add(
                new Song("Story of my life",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/storyofmylife"))
        );
        songs.add(
                new Song("Take your shirt off",
                        "T-Pain",
                        "https://www.billboard.com/files/styles/article_main_image/public/media/t-pain-2017-billboard-cr-DirectedByBANK-1548.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/takeyourshirtoff"))
        );

        songs.add(
                new Song("T.H.E",
                        "Will i am",
                        "https://i.pinimg.com/originals/0b/cf/83/0bcf83cb7023934f37aaad23f444dd5c.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/the"))
        );
        songs.add(
                new Song("Wrecking ball",
                        "Miley Cyrus",
                        "https://www.usmagazine.com/wp-content/uploads/2018/11/miely-cyrus-fire.jpg?w=300",
                        Uri.parse("android.resource://"+context.getPackageName()+"/raw/wreckingball"))
        );
        songs.add(
                new Song("Kiss You",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/kissyou"))
        );
        songs.add(
                new Song("Come and Get it",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comeandgetit"))
        );
        songs.add(
                new Song("Come back to me",
                        "Unknow",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comebacktome"))
        );
        songs.add(
                new Song("Let her go ",
                        "Passenger",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJqpnFAfbZHyfGAHFvtLmTHcSgMY9dnhaEfXMnD1_5GfIvPdpD",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/lethergo"))
        );
        songs.add(
                new Song("Love yo like a love song",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/loveyoulikealovesong"))
        );
        songs.add(
                new Song("Slow Down",
                        "Selena Gomez",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/slowdon"))
        );songs.add(
                new Song("Thai Song",
                        "GestureNova",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/song"))
        );songs.add(
                new Song("Story of my life",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/storyofmylife"))
        );
        songs.add(
                new Song("Take your shirt off",
                        "T-Pain",
                        "https://www.billboard.com/files/styles/article_main_image/public/media/t-pain-2017-billboard-cr-DirectedByBANK-1548.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/takeyourshirtoff"))
        );

        songs.add(
                new Song("T.H.E",
                        "Will i am",
                        "https://i.pinimg.com/originals/0b/cf/83/0bcf83cb7023934f37aaad23f444dd5c.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/the"))
        );



        songs.add(
                new Song("Wrecking ball",
                        "Miley Cyrus",
                        "https://www.usmagazine.com/wp-content/uploads/2018/11/miely-cyrus-fire.jpg?w=300",
                        Uri.parse("android.resource://"+context.getPackageName()+"/raw/wreckingball"))
        );
        songs.add(
                new Song("Kiss You",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/kissyou"))
        );
        songs.add(
                new Song("Come and Get it",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comeandgetit"))
        );
        songs.add(
                new Song("Come back to me",
                        "Unknow",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/comebacktome"))
        );
        songs.add(
                new Song("Let her go ",
                        "Passenger",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJqpnFAfbZHyfGAHFvtLmTHcSgMY9dnhaEfXMnD1_5GfIvPdpD",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/lethergo"))
        );
        songs.add(
                new Song("Love yo like a love song",
                        "Selena",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/loveyoulikealovesong"))
        );
        songs.add(
                new Song("Slow Down",
                        "Selena Gomez",
                        "https://assets.teenvogue.com/photos/596775d914b7b375cd34f44e/master/pass/selena%20gomez.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/slowdon"))
        );songs.add(
                new Song("Thai Song",
                        "GestureNova",
                        "https://www.praisecharts.com/themes/praisecharts/images/layout/music-placeholder.png",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/song"))
        );songs.add(
                new Song("Story of my life",
                        "One Direction",
                        "https://images.8tracks.com/cover/i/002/642/428/You___I-7729.jpg?rect=97,0,1405,1405&q=98&fm=jpg&fit=max&w=640&h=640",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/storyofmylife"))
        );
        songs.add(
                new Song("Take your shirt off",
                        "T-Pain",
                        "https://www.billboard.com/files/styles/article_main_image/public/media/t-pain-2017-billboard-cr-DirectedByBANK-1548.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/takeyourshirtoff"))
        );

        songs.add(
                new Song("T.H.E",
                        "Will i am",
                        "https://i.pinimg.com/originals/0b/cf/83/0bcf83cb7023934f37aaad23f444dd5c.jpg",
                        Uri.parse("android.resource://"+context.getPackageName()+ "/raw/the"))
        );
        return songs;
    }


}
