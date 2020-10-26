package com.cookandroid.ex06_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// 1.
// 액션바(Acrtion Bar)
//      : 태블릿, 스마트폰 등 다양한 크기의 화면을 디자인 하는데 활용
// 프래그먼트(Fragment)
//      : 액티비티보다 작은 단위의 화면
//      : 프래그먼트 사용시 대형 화면에서 액티비티 화면을 분할해서 표현 가능
//      : 스마트폰과 같은 소형화면에선 화면의 분할보단 실행 중에 화면을 동적으로 추가, 제거하는데 더 많이 활용
//
// 2. 액션바와 프래그먼트를 활용하여 화면 구현
// ActionBar bar = getActionBar(); // 상단에 표시할 액션바 준비
// // 탭호스트와 같이 탭의 모양을 가지도록 설정
// bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
// tabSong = bar.newTab(); // 탭을 액션바에 생성
// tabSong.setText("음악별"); // 탭의 글자를 설정
// tabSong.setTabListener(this); // 탭을 터치하면 작동하는 리스너 지정
// bar.addTab(tabSong); // 탭을 액션바에 추가

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}