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

        Intent inIntent = getIntent();
        final int hapAdd = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        final int hapMinus = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        final int hapMul = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        final int hapDiv = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);



        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                if(idAdd.){
                    outIntent.putExtra("Hap", hapAdd);
                } else if(minus.isChecked()) {
                    outIntent.putExtra("Hap", hapMinus);
                } else if(mul.isChecked()) {
                    outIntent.putExtra("Hap", hapMul);
                } else if(div.isChecked()) {
                    outIntent.putExtra("Hap", hapDiv);
                }
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
