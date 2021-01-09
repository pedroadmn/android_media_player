package com.example.mediaplayer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MyNotesActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private Button saveButton;
    private TextView textResult;
    private static final String PREFERENCES_FILE = "PreferenceFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);

        getSupportActionBar().hide();
    }
}