package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button goCheckGradesBtn, goInputGradesBtn; // intuitive variable name
    private TextView[] result = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goCheckGradesBtn = findViewById(R.id.goCheckGradesBtn);
        goInputGradesBtn = findViewById(R.id.goInputGradesBtn);

        Integer[] textIds = {R.id.schoolLevlTextView, R.id.smesterTextView, R.id.subjectTextView, R.id.professorTextView, R.id.gradeTextView};
        for (int i = 0; i < textIds.length; i++) {
            result[i] = findViewById(textIds[i]);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("grades", MODE_PRIVATE);
        for (int i = 0; i < result.length; i++) {
            String grade = sharedPreferences.getString("grade" + i, "No grade found");
            result[i].setText(grade);
        }

        // move the click listener out of `for loop`
        goCheckGradesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(j);
            }
        });

        goInputGradesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InputActivity.class);
                startActivity(i);
            }
        });
    }
}
