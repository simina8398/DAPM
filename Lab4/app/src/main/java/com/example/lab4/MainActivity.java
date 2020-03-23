package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=(Button)findViewById(R.id.button);
        userName=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(userName.getText().toString(),password.getText().toString());
            }
        });
    }

    protected void login(String user, String pass){
        if (user.equals("student") && pass.equals("student")) {
            Intent intent= new Intent(this, Game.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Wrong credentials", Toast.LENGTH_LONG).show();

        }
    }
}