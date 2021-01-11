package com.example.mediaplayer;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private Context context;
    private SharedPreferences sharedPreferences;
    private final String FILE_NAME = "notes.preferences";
    private SharedPreferences.Editor editor;
    private String KEY_NOTE = "note";

    public Preferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public void saveNote(String note) {
        editor.putString(KEY_NOTE, note);
        editor.commit();
    }

    public String loadNote() {
        return sharedPreferences.getString(KEY_NOTE, "");
    }
}
