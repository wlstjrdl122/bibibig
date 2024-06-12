// InputActivity

package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    Button btnout, btnin;
    private EditText[] editTexts = new EditText[5];
    String[] text = new String[5];

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.type);
        Integer[] editIds = {R.id.edithak1,R.id.edithak2,R.id.editgwa,R.id.editprofessor,R.id.editgrade};
        for(int j=0; j<editIds.length; j++) {
            editTexts[j] = (EditText) findViewById(editIds[j]);
        }
        btnout = findViewById(R.id.btnout);
        btnin = findViewById(R.id.btnin); // this code was missing

        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InputActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("grades",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                for(int i=0;i<editTexts.length;i++) {
                    text[i] = editTexts[i].getText().toString();
                    editor.putString("grade"+i, text[i]);
                }
                editor.apply();
                Intent intent = new Intent(InputActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
