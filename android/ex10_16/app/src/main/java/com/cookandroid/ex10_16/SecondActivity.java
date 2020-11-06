package com.cookandroid.ex10_16;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
//    RadioButton add, minus, mul, div;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("second 액티비티");

        android.util.Log.d("액티비티1", "ssss11111");
        
        Intent inIntent = getIntent();
        final int hapAdd = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        final int hapMinus = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        final int hapMul = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        final int hapDiv = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);

        String getRdValue = inIntent.getStringExtra("RadioButton");

        android.util.Log.d("액티비티1", "11111");

        // id로 넘기는거 시도해봤으나 애초에 activity_main.xml 아이디랑 second.xml 아이디는 별개의 값임
        // 그래서 그냥 값으로 가져오는게 나음

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                if(getRdValue.equals("더하기")){
                    outIntent.putExtra("Hap", hapAdd);
                } else if(getRdValue.equals("빼기")) {
                    outIntent.putExtra("Hap", hapMinus);
                } else if(getRdValue.equals("곱하기")) {
                    outIntent.putExtra("Hap", hapMul);
                } else if(getRdValue.equals("나누기")) {
                    outIntent.putExtra("Hap", hapDiv);
                }

                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
