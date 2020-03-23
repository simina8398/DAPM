package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.mybutton1);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myFancyMethod(v);
            }
        });

        Log.d("myApp", "onCreate");
    }


    protected void onRestart() {
        super.onRestart();
        Log.v("myApp", "onRestart");
    }

    protected void onStart() {
        super.onStart();
        Log.v("myApp", "onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.v("myApp", "onResume");
    }
    protected void onPause() {
        super.onPause();
        Log.v("myApp", "onPause");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.v("myApp", "onDestroy");
    }

    public void push(View view){
        Toast.makeText(this, "You pushed the button from push function", Toast.LENGTH_SHORT).show();
    }

    public void myFancyMethod(View v) {
        Toast.makeText(MainActivity.this,"You pushed the second button from on create", Toast.LENGTH_LONG).show();
    }
}
