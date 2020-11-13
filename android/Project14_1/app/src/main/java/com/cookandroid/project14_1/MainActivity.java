package com.cookandroid.project14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("서비스 테스트 예제");

        intent = new Intent(this, MusicService.class); // 인텐트 변수를 생성하면서 MusicService클래스를 생성자에 넘김
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
                Toast.makeText(MainActivity.this, "startService", Toast.LENGTH_SHORT).show();
//                android.util.Log.i("서비스 테스트", "startService()");
                finish();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
                Toast.makeText(MainActivity.this, "stopService", Toast.LENGTH_SHORT).show();
//                android.util.Log.i("서비스 테스트", "stopService()");
            }
        });
    }
}
