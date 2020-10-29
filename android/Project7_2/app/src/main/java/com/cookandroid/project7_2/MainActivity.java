package com.cookandroid.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // 방법1 - xml로 만듦
        MenuInflater mInflater = getMenuInflater();
        if(v == button1) {
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.icon1);
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == button2) {
            mInflater.inflate(R.menu.menu2, menu);
        }

        // 방법2 - 자바 코드로 만듦
//        if (v == button1) {
//            menu.setHeaderTitle("배경색 변경");
//            menu.add(0, 1, 0, "배경색 (빨강)");
//            menu.add(0, 2, 0, "배경색 (초록)");
//            menu.add(0, 3, 0, "배경색 (파랑)");
//        }
//        if (v == button2) {
//            menu.add(0, 4, 0, "버튼 45도 회전");
//            menu.add(0, 5, 0, "버튼 2개 확대");
//        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // 방법1 - xml로 만듦
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

            // 방법2 - 자바로 만듦
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
//                button2.setRotation(45);
//                return true;
//            case 5:
//                button1.setScaleX(2);
//                button2.setScaleX(2);
//                return true;
        }
        return false;
    }
}
