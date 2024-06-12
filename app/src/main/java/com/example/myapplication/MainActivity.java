package com.example.myapplication;

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

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    private TextView[] result = new TextView[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        Integer[] textIds = {R.id.result1, R.id.result2, R.id.result3, R.id.result4, R.id.result5};
        for (int i = 0; i < textIds.length; i++) {
            result[i] = findViewById(textIds[i]);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("grades", MODE_PRIVATE);
        for (int i = 0; i < result.length; i++) {
            String grade = sharedPreferences.getString("grade" + i, "No grade found");
            result[i].setText(grade);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent j = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(j);

                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
            });
        }
    }
}
