package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button mic, listen;
    TextView text;
    TextToSpeech ttobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mic = findViewById(R.id.mic);
        listen = findViewById(R.id.listen);
        text = findViewById(R.id.text);

        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySpeechRecognizer();
            }
        });

        ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    ttobj.setLanguage(Locale.UK);
                }
            }
        });

        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!text.getText().toString().isEmpty())
                    ttobj.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                else
                    Toast.makeText(MainActivity.this, "nothing to listen to", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final int REQ_CODE_SPEECH_INPUT = 100;
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-En");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something");
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
        Intent data) {
            if (requestCode == REQ_CODE_SPEECH_INPUT && resultCode == RESULT_OK) {
                List<String> results = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                String spokenText = results.get(0);
                // Do something with spokenText
                text.setText(spokenText);
            }
            super.onActivityResult(requestCode, resultCode, data);
    }

    public void selectFrag(View view) {
        Fragment fr;

        if(view == findViewById(R.id.button2)) {
            fr = new FragmentTwo();
        }else {
            fr = new FragmentOne();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }
}
