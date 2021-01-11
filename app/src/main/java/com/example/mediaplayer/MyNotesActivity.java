package com.example.mediaplayer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MyNotesActivity extends AppCompatActivity {

    private TextInputEditText editTextName;
    private Button saveButton;
    private EditText edtTextNote;
    private static final String PREFERENCES_FILE = "PreferenceFile";

    private Preferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);

        preferences = new Preferences(getApplicationContext());

        edtTextNote = findViewById(R.id.edtTextNote);

        getSupportActionBar().hide();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);

        fab.setOnClickListener(view -> {
            String note = edtTextNote.getText().toString();

            if(!note.isEmpty()){
                preferences.saveNote(edtTextNote.getText().toString());
                Snackbar.make(view, "Your note was saved", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(view, "Type your note", Snackbar.LENGTH_SHORT).show();
            }
        });

        String annotation = preferences.loadNote();
        if (!annotation.isEmpty()) {
            edtTextNote.setText(annotation);
        }
    }
}