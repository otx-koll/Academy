package com.cookandroid.project5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        1. 레이아웃 만들기(Linear)
//            1-1. 레이아웃 속성객체 만들기(param 객체)
//            1-2. 레이아웃 객체에 속성객체를 사용
//        2. 위젯 만들기(버튼, 텍스뷰, 에디트 텍스트)
//        3. 위젯 이벤트 달기(버튼, )
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));
        setContentView(baseLayout, params);

        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "코드로 생성한 버튼입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}