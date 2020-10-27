package com.cookandroid.ex06_19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

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

public class MainActivity extends Activity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum;

    MyTabFragment myFrags[] = new MyTabFragment[3];

    public void onTabSelected(TabLayout.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()] == null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        }
        else
            myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getActionBar(); // 상단에 표시할 액션바 준비
        // 탭호스트와 같이 탭의 모양을 가지도록 설정
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab(); // 탭을 액션바에 생성
        tabSong.setText("음악별"); // 탭의 글자 설정
        tabSong.setTabListener(this); // 탭을 터치하면 작동하는 리스너 지정
        bar.addTab(tabSong); // 탭을 액션바에 추가

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        String tabName;
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }
        public View onCreateView(LayoutInflater inflater, ViewGroup contatiner, Bundle savedInstanceState) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName == "음악별") baseLayout.setBackgroundColor(Color.RED);
            if(tabName == "가수별") baseLayout.setBackgroundColor(Color.GREEN);
            if(tabName == "앨범별") baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        }
    }
}