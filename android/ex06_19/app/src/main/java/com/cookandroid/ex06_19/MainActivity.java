package com.cookandroid.ex06_19;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong;
    ActionBar.Tab tabArtist;
    ActionBar.Tab tabAlbum;

    MyTabFragment myFrags[] = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // seContentView(R.layout.activity_main); // View 대신에 Fragement 사용할 예정

        // 액션바 만들기
        ActionBar bar = getSupportActionBar();
        // 탭호스트와 같이 탭의 모양을 가지도록 설정
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // 1-1 탭 만들어서 액션바에 꽂기
        tabSong = bar.newTab(); // 탭을 액션바에 생성
        tabSong.setText("음악별"); // 탭의 글자 설정
        tabSong.setTabListener(this); // 탭을 터치하면 작동하는 리스너 지정
        bar.addTab(tabSong); // 탭을 액션바에 추가
        //
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
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()] == null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle(); // 번들 만들어서 데이터에 보냄
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        }
        else
            myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    //2.프레그먼트 만들기 -> 내부(이너) 클래스로 만든다, 외부에 만들어도 된다

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        String tabName;

        //프레그먼트가 만들어 질 때, 액티비티(OS)와 통신이 필요할 시 설정값 세팅
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        //프레그먼트가 만들어지고 나서, 뷰를 생성할 때, 화면과 관련된 코드 작성
        @Nullable
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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