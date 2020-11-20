package com.cookandroid.ex06_17;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost(); // 생성한 탭호스트를 가져온다.

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별"); // 탭 이름 지정후 새로운 탭스펙 생성하고
        tabSpecSong.setContent(R.id.tabSong); // 레이아웃과 연결
        tabHost.addTab(tabSpecSong); // 탭호스트에 탭스텍을 추가하면 탭 "home" 생성

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecSong.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ARTIST").setIndicator("앨범별");
        tabSpecSong.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);

    }
}
















