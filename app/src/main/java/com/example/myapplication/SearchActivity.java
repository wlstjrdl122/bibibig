package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchActivity extends AppCompatActivity {
    Button btnMain, btnInput,btnSearch;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.search);
         btnMain=findViewById(R.id.goMainBtn);
         btnInput= findViewById(R.id.goInputGradesBtn);
         btnSearch = findViewById(R.id.btnSearch);
         btnMain.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(SearchActivity.this,MainActivity.class);
                 startActivity(i);

             }
         });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("grades",MODE_PRIVATE);
                String[] grades = new String[5];
                for(int i=0; i<5; i++) {
                    grades[i] = sharedPreferences.getString("grade"+i, "No grade found");
                }
            }
        });

    }

}