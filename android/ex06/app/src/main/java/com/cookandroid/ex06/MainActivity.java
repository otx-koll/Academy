package com.cookandroid.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.ex06_01);
        setContentView(R.layout.ex06_02);
        setContentView(R.layout.ex06_03);
        setContentView(R.layout.ex06_12);
        setContentView(R.layout.ex06_13);
        setContentView(R.layout.ex06_14);
    }
}