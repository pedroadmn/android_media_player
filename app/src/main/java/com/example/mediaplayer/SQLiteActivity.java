package com.example.mediaplayer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        try {
            SQLiteDatabase database = openOrCreateDatabase("app", MODE_PRIVATE, null);

//            database.execSQL("CREATE TABLE IF NOT EXISTS people (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INT(3))");
//            database.execSQL("DROP TABLE people");

//            database.execSQL("INSERT INTO people (name, age) VALUES ('Jamilton', 30)");
//            database.execSQL("INSERT INTO people (name, age) VALUES ('Maria', 35)");
//            database.execSQL("INSERT INTO people (name, age) VALUES ('Mariana', 18)");
//            database.execSQL("INSERT INTO people (name, age) VALUES ('Pedro', 50)");

//            database.execSQL("UPDATE people SET age = 19, name = 'Mariana Silva' WHERE id = 3");

            database.execSQL("DELETE FROM people WHERE id = 2");

//            String query = "SELECT name, age " +
//                            "FROM people " +
//                            "WHERE name = 'Jamilton' AND age = 30";

//            String query = "SELECT name, age " +
//                            "FROM people " +
//                            "WHERE age >= 35 OR age = 18";

//            String query = "SELECT name, age " +
//                            "FROM people " +
//                            "WHERE age IN (18, 35)";

//            String query = "SELECT name, age " +
//                            "FROM people " +
//                            "WHERE age BETWEEN 18 AND 35";

//            String filter = "MARIA";
//            String query = "SELECT name, age " +
//                            "FROM people " +
//                            "WHERE name LIKE '" + filter + "%'";

            String query = "SELECT * " +
                            "FROM people " +
                            "ORDER BY age ASC   ";

            Cursor cursor = database.rawQuery(query, null);

            int indexId = cursor.getColumnIndex("id");
            int indexName = cursor.getColumnIndex("name");
            int indexAge = cursor.getColumnIndex("age");

            cursor.moveToFirst();
            while (cursor !=  null) {
                String id = cursor.getString(indexId);
                String name = cursor.getString(indexName);
                String age = cursor.getString(indexAge);


                Log.i("Resultado - id: ", id + "  name: " + name + ", idade: " + age);

                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}