package com.cookandroid.exs7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    EditText ed1;
    ImageView img;
    MenuItem hanrasan, chuzado, bumsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        ed1 = (EditText) findViewById(R.id.ed1);
        img = (ImageView) findViewById(R.id.img);
        hanrasan = (MenuItem) findViewById(R.id.hanrasan);
        chuzado = (MenuItem) findViewById(R.id.chuzado);
        bumsum = (MenuItem) findViewById(R.id.bumsum);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            switch (item.getItemId()) {
                case R.id.hanrasan:
                    img.setImageResource(R.drawable.jeju1);
                    item.setChecked(true);
                    break;
                case R.id.chuzado:
                    img.setImageResource(R.drawable.jeju2);
                    item.setChecked(true);
                    break;
                case R.id.bumsum:
                    img.setImageResource(R.drawable.jeju3);
                    item.setChecked(true);
                    break;
                case R.id.rotation:
                    img.setRotation(Integer.parseInt(ed1.getText().toString()));
                    break;
            }
        } catch (Exception e) {
            if (!item.isChecked()) {
                ed1.requestFocus();
                Toast.makeText(this, "이미지와 각도를 입력해주세요", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }
}
