package com.jasonedwardes.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jasonedwardes.texttospeech.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // check view.binding is working
        binding.idTxt.setText("test");
    }

    @Override
    public void onClick(View view) {

    }
}