package com.cookandroid.ex06_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String items[] = {"CSI-뉴욕", "CSI-라그베가스", "CSI-마이애미", "Friends", "Fringe", "Lost"};

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        // ArrayAdapter : 데이터를 ArrayList에 넣고 ArrayAdapter로 어떻게 보여줄지 지정. ListView에 보여주기 위해 사용
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        // CommaTokenizer : ','(쉼표) TokenLizer 등록
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);

    }
}