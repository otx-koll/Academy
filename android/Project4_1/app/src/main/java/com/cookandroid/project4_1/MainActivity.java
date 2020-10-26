package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //4번-이너 클래스(내부 클래스)
//    class MyOnTouchListener implements View.OnTouchListener {
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            int result;
//            String str1, str2;
//            int n1, n2;
//            str1 = edt1.getText().toString();
//            str2 = edt2.getText().toString();
//            n1 = Integer.parseInt(str1);
//            n2 = Integer.parseInt(str2);//문자를 -> 숫자로
//
//            result = n1 - n2;
//
//            tv1.setText("계산 결과: " + result);
//            tv1.setTextSize(20);
//            return false;
//        }
//    }

    // 1번- 멤버 변수
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView textResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnMod = (Button) findViewById(R.id.BtnMod);

        textResult = (TextView) findViewById(R.id.TextResult);

//        View.OnTouchListener lis1 = new View.OnTouchListener() ;

//        View.OnTouchListener listener2 = new View.OnTouchListener (){
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int result;
//                String str1, str2;
//                int n1, n2;
//                str1 = edt1.getText().toString();
//                str2 = edt2.getText().toString();
//                n1 = Integer.parseInt(str1);
//                n2 = Integer.parseInt(str2);//문자를 -> 숫자로
//
//                result = n1 - n2;
//
//                tv1.setText("계산 결과: " + result);
//                tv1.setTextSize(20);
//                return false;
//            }
//        };

//        btn2.setOnTouchListener(listener2);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num1.trim().equals("")){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                    textResult.setTextSize(20);
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num1.trim().equals("")){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                    textResult.setTextSize(20);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num1.trim().equals("")){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                    textResult.setTextSize(20);
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.trim().equals("") || num1.trim().equals("")){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                } else{
                    if(num2.equals("0")){
                        Toast.makeText(MainActivity.this, "0으로 나눌 수 없습니다!", Toast.LENGTH_SHORT).show();
                    }
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                    textResult.setTextSize(20);
                }
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString(); // 문자를 숫자로

                if(num1.trim().equals("") || num1.trim().equals("")){
                    Toast.makeText(MainActivity.this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
//                    result = (int)(result * 100) / 100.0;
                    textResult.setText("계산 결과 : " + result.toString());
                    textResult.setTextSize(20);
                }
            }
        });
    }
}