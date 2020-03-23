package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {
    Button btn;
    EditText nr;
    Random random;
    int randomNumber;
    int nrColor=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        btn=(Button)findViewById(R.id.button2);
        nr =(EditText)findViewById(R.id.nr);

        random = new Random();
        randomNumber = random.nextInt(11);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nrColor%2==0)
                    btn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                else btn.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                int i = Integer.parseInt(nr.getText().toString());
                guess(i);
            }
        });
    }

    public void guess(int i){
        if (i==randomNumber) {
            Toast.makeText(this,"You won! Try again", Toast.LENGTH_LONG).show();
            nrColor=0;
            Intent intent= new Intent(this, FindTheNumberActivity.class);
            startActivity(intent);
        } else if(i<randomNumber){
            nrColor++;
            Toast.makeText(this,"Higher", Toast.LENGTH_LONG).show();
        } else {
            nrColor++;
            Toast.makeText(this,"Lower", Toast.LENGTH_LONG).show();
        }
    }
}
