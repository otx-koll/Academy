package com.cookandroid.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 메뉴 파일 등록
        super.onCreateOptionsMenu(menu);

        // 방법1 - xml로 작성
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        // inflate : xml에 표기된 레이아웃들을 메모리에 객체화시키는 행동

        // 방법2 - 자바로 작성
//        menu.add(0, 1, 0, "배경색 (빨강)");
//        menu.add(0, 2, 0, "배경색 (초록)");
//        menu.add(0, 3, 0, "배경색 (파랑)");
//
//        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
//        sMenu.add(0, 4, 0, "버튼 45도 회전");
//        sMenu.add(0, 5, 0, "버튼 2배 확대");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // 메뉴 선택 시 작동할 내용 코딩
        switch (item.getItemId()) {
            // 방법1 - xml로 작성
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button1.setRotation(45); // 회전
                return true;
            case R.id.subSize:
                button1.setScaleX(2); // x축을 따라 수평방향으로 요소 크기 조절
                return true;

            // 방법2 - 자바로 작성
//            case 1:
//                baseLayout.setBackgroundColor(Color.RED);
//                return true;
//            case 2:
//                baseLayout.setBackgroundColor(Color.GREEN);
//                return true;
//            case 3:
//                baseLayout.setBackgroundColor(Color.BLUE);
//                return true;
//            case 4:
//                button1.setRotation(45);
//                return true;
//            case 5:
//                button1.setScaleX(2);
//                return true;
        }
        return false;
    }
}
