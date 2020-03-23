package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MySharedPreferences share;
    EditText et;
    Button but, but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        share = new MySharedPreferences(this);
        but = findViewById(R.id.button);
        but2 = findViewById(R.id.button2);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                share.save(et.getText().toString());
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("ala bala","cel mai misto lab6 din lumeeee");
                startActivity(i);
            }
        });


    }
}
