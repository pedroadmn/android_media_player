package com.example.mediaplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class UserPreferencesActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private Button saveButton;
    private TextView textResult;
    private static final String PREFERENCES_FILE = "PreferenceFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);

        editTextName = findViewById(R.id.editTextName);
        saveButton = findViewById(R.id.saveButton);
        textResult = findViewById(R.id.textResult);

        saveButton.setOnClickListener(view -> {
            SharedPreferences sharedPreferences =  getSharedPreferences(PREFERENCES_FILE, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            String name = editTextName.getText().toString();

            if (name.equals("")) {
                Toast.makeText(getApplicationContext(), "Fill the name", Toast.LENGTH_LONG).show();
            } else {
                editor.putString("userName", name);
                editor.apply();
                textResult.setText(name);
            }
        });

        SharedPreferences sharedPreferences =  getSharedPreferences(PREFERENCES_FILE, 0);

        if (sharedPreferences.contains("userName")) {
            textResult.setText(sharedPreferences.getString("userName", "Hello, user is not defined"));
        } else {
            textResult.setText("Hello, user is not defined");
        }

    }
}