package com.example.luther.androidmediaplayer.data;

import android.content.Context;
import android.content.SharedPreferences;


public class Pref {

    private static final String PREFERENCES_NAME = "MyPref";

    public static SharedPreferences.Editor getEditor(Context context) {
        return context
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
                .edit();
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}
