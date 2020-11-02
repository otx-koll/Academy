package com.cookandroid.ex07_14;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);

        final boolean[] checkArray = new boolean[]{false, false, false}; // 변할 수 있는 변수화가 됨. 체크 유지되어있음

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 목록 대화상자 */
                final String[] versionArray = new String[]{"롤리팝", "마시멜로", "누가"};
                /* 체크목록 대화상자 */


                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);

//                dlg.setMessage("이곳이 내용입니다"); // 내용 하나

                /* setPositiveButton("문자열", 리스너) */
//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "확인되었습니다", Toast.LENGTH_SHORT).show();
//                    }
//                });

                /* 목록 대화상자 */
                /* setItems(목록, 리스너) */
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]);
//                    }
//                });

                /* 라디오버튼 목록 대화상자 */
                /* setSingleChoiceItems(목록, checkedItem, 리스너) */
//                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        button1.setText(versionArray[which]);
//                    }
//                });

                /* 체크박스 목록 대화상자 */
                /* setMultiChoiceItems(목록, checked여부 목록, 리스너) */
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        String str = "";
                        int cnt = 0;
                        for (int i = 0; i < checkArray.length; i++) {
                            if(checkArray[i]){
                                cnt++;
                                if(cnt != 1){
                                    str += ",";
                                }
                                str += versionArray[i];
                            }
                        }
                        button1.setText(str);

                        if(button1.getText().equals("")) {
                            button1.setText("선택없음");
                        }
                    }
                });

                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}