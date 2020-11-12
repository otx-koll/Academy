package com.cookandroid.project14_1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();
//        android.util.Log.i("서비스 테스트", "onCreate()");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestory()", Toast.LENGTH_SHORT).show();
//        android.util.Log.i("서비스 테스트", "onDestory()");
        mp.stop(); // 음악 중지 코드
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand()", Toast.LENGTH_SHORT).show();
//        android.util.Log.i("서비스 테스트", "onStartCommand()");
        mp = MediaPlayer.create(this, R.raw.song1); // mp3 파일 시작하는 코드
        mp.setLooping(true); // 계속 반복
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
