package com.jasonedwardes.texttospeech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;


import com.jasonedwardes.texttospeech.databinding.ActivityMainBinding;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

//text to speech////////////////////////////////////////////
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
               binding.idEditTxt.setText("");
            }
        });
        ///////////////////////////end of text to speech//////////////////////
        ////////////////////start of speech to text///////////////////////////////
        binding.idBtnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start speaking");
                startActivityForResult(intent, 102);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data){
        super.onActivityResult(requestCode, resultCode,data);

        if (requestCode == 102 && resultCode == RESULT_OK){
            binding.idTxt.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));

        }
    }


}