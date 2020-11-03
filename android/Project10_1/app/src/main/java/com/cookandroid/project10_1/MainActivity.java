package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton second, third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        second = (RadioButton) findViewById(R.id.second);
        third = (RadioButton) findViewById(R.id.third);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSecond = new Intent(getApplicationContext(), SecondActivity.class);
                Intent iThird = new Intent(getApplicationContext(), ThirdActivity.class);
                // intent : 컴포넌트간에 데이터를 주고 받기 위한 메시지 객체
                // new Intent(from(여기에서), to(여기로 이동)

                if(second.isChecked()) {
                    startActivity(iSecond); // 새로운 액티비티를 화면에 띄울 때
                } else if (third.isChecked()) {
                    startActivity(iThird);
                }
            }
        });
    }
}