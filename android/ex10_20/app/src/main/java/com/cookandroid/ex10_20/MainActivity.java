package com.cookandroid.ex10_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnDial, btnWeb, btnGoogle, btnSearch, btnSms, btnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        btnDial = (Button) findViewById(R.id.btnDial);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSms = (Button) findViewById(R.id.btnSms);
        btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://www.hanbit.co.kr");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        btnGoogle.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.google.com/maps/@35.1572657,129.0584837,17.25z?hl=ko");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "안드로이드");
            startActivity(intent);
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.putExtra("sms_body", "안녕하세요?");
            intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-5678")));
            startActivity(intent);
        });

        btnPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath() + "/jeju1.jpg"));
//            intent.setDataAndType(uri, "image/jpeg");
            startActivity(intent);
        });
    }
}