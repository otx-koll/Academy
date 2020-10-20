package com.cookandroid.project4_2_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch swAgree;
    RadioGroup rGroup1;
    //    RadioButton rdoOreo, rdoPie, rdoQ;
    RadioButton rdoArr[] = new RadioButton[3];
    Button btnFinish, btnInit;
    ImageView imgAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        swAgree = (Switch) findViewById(R.id.start);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
//        rdoOreo = (RadioButton) findViewById(R.id.RdoOreo);
//        rdoPie = (RadioButton) findViewById(R.id.RdoPie);
//        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        rdoArr[0] = (RadioButton) findViewById(R.id.RdoOreo);
        rdoArr[1] = (RadioButton) findViewById(R.id.RdoPie);
        rdoArr[2] = (RadioButton) findViewById(R.id.RdoQ);

        btnFinish = (Button) findViewById(R.id.BtnFinish);
        btnInit = (Button) findViewById(R.id.BtnInit);
        imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);

        swAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swAgree.isChecked()) {
                    // android.view.View가 import 되었기 때문에 android.view 생략 가능
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnFinish.setVisibility(View.VISIBLE);
                    btnInit.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                } else if (!swAgree.isChecked()) {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnFinish.setVisibility(View.INVISIBLE);
                    btnInit.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 배열로 만들기
        int nDrawable[] = {R.drawable.oreo, R.drawable.pie, R.drawable.q10};

        for (int i = 0; i < nDrawable.length; i++) {
           final int index = i;
            rdoArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgAndroid.setImageResource(nDrawable[index]);
                }
            });
        }
        // imgAndroid.setImageResource(nDrawable[i]) 안에 있는 i가 오류인 이유
            // for 영역과 setOnClickListener영역과 다르다. 각 영역은 독립적이다. {}로 구분되어 있다.
            // 그렇기 때문에 for문 안에 다시 변수지정을 해줘야 함. int index = i;
        // final로 만들어야 하는 이유


//        rdoOreo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgAndroid.setImageResource(R.drawable.oreo);
//            }
//        });
//
//        rdoPie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgAndroid.setImageResource(R.drawable.pie);
//            }
//        });
//
//        rdoQ.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgAndroid.setImageResource(R.drawable.q10);
//            }
//        });

        // 종료 및 종료 알림창 띄우기
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료 알림창").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // 액티비티를 종료
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("종료 알림창");
                alert.show();
            }
        });

        // 리셋 버튼
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swAgree.setChecked(false);
                rGroup1.clearCheck(); // radiogroup의 버튼 리셋

                // R. : 내부적으로 정수형으로 다룬다.
                // imgAndroid.setImageResource(R.drawable.oreo);
                imgAndroid.setImageResource(0);
            }
        });
    }
}
