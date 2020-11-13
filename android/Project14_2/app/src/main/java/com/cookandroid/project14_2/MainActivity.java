package com.cookandroid.project14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Image;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView ivBattery;
    EditText edtBattery;

    MyBR mBR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배터리 상태 체크");

        ivBattery = (ImageView) findViewById(R.id.ivBattery);
        edtBattery = (EditText) findViewById(R.id.edtBattery);

        mBR = new  MyBR(ivBattery, edtBattery);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBR); // br 등록 해제
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter iFilter = new IntentFilter(); // 인텐트 필터 생성 후
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED); // ACTION_BATTERY_CHANGED 액션 추가 한 후
        registerReceiver(mBR, iFilter); // br에 등록
    }
}