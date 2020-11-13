package com.cookandroid.project12_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnUpdate, btnDelete, btnSelect;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        myHelper = new myDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); // 읽고 쓰기용 DB열기. SQLiteDatabase 반환
                myHelper.onUpgrade(sqlDB, 1, 2); // groupTBL있으면 테이블 삭제 후 다시 생성
                sqlDB.close(); // 데이터베이스 닫기
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();

                if(edtName.getText().toString().equals("") || edtNumber.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "값을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                            + edtName.getText().toString() + "', "
                            + edtNumber.getText().toString() + ");");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                }

                btnSelect.callOnClick();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();

                if(edtName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "이름이 입력되지 않았습니다", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sqlDB.execSQL("UPDATE groupTBL SET gNumber = " +
                            Integer.parseInt(edtNumber.getText().toString()) +
                            " WHERE gName = " + "'" +
                            edtName.getText().toString() + "';");
                    sqlDB.close();
                    Toast.makeText(MainActivity.this, "수정됨", Toast.LENGTH_SHORT).show();
                }

                btnSelect.callOnClick();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();

                if(edtName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "삭제할 그룹이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = " + "'" +
                            edtName.getText().toString() + "';");
                    sqlDB.close();
                    Toast.makeText(MainActivity.this, "삭제됨", Toast.LENGTH_SHORT).show();
                }

                btnSelect.callOnClick();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null); // select 실행 후 커서 반환

                String strNames = "그룹 이름\r\n------------\r\n";
                String strNumbers = "인원\r\n------------\r\n";

                while (cursor.moveToNext()){ // 현재 커서의 다음 행으로 이동
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper(@Nullable Context context) {
            super(context, "groupDB", null, 1);
            // 생성자 정의. super에서 두번째 파라미터는 새로 생성될 데베 파일명 지정. 세번째는 데이터베이스 버전 지정
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY, gNumber INTEGER);"); // execSQL 메소드로 sql실
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL"); // 테이비ㅡㄹ 삭제하고 새로 생성. 초기화할 때 호출한다.
            onCreate(db);
        }
    }
}
