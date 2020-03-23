package com.example.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
MySharedPreferences share;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        share = new MySharedPreferences(this);
        tv = findViewById(R.id.textView2);
        Intent i = getIntent();
        tv.setText(share.getValue()+"\n"+i.getStringExtra("ala bala"));
    }
}
