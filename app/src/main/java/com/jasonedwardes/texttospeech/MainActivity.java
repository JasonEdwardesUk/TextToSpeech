package com.jasonedwardes.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.jasonedwardes.texttospeech.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding binding;
    TextToSpeech textToSpeech;

   // Locale locale = new Locale("ENGLAND");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // check view.binding is working
        //binding.idTxt.setText("test");

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    //could add array of Languages on spinner.

                   // textToSpeech.setLanguage(locale);
                   textToSpeech.setLanguage(Locale.ENGLISH);
                }

            }

            //binding.idBtn.setOnClickListener();
        });
            binding.idBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = binding.idEditTxt.getText().toString();
                     textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);

                }
            });
    }
}