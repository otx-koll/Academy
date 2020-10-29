package com.cookandroid.project6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getSupportActionBar() : 액티비티 제목 또는 액티비티의 기본 도구 모음
        // Nav icon, Title, Actions, Overflow menu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 생성
        getSupportActionBar().setIcon(R.drawable.web);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);

        web.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true); // 줌 아이콘 사용가능

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });
    }
    // 커서 CookWebViewClient 안에 두고 code - override methods 클릭하면 오버라이딩 가능한 메소드 목록 뜸
    class CookWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // shouldOverrideUrlLoading : 웹 로드를 컨트롤 하겠다
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
