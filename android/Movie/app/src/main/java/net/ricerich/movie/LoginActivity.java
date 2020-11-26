package net.ricerich.movie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.ricerich.movie.JoinActivity;
import net.ricerich.movie.Network.JsonParser;
import net.ricerich.movie.Network.LoginRequest;
import net.ricerich.movie.R;
import net.ricerich.movie.Tab.InfoActivity;
import net.ricerich.movie.Tab.SnackActivity;

public class LoginActivity extends Activity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_login);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((EditText) findViewById(R.id.idEdt)).getText().toString().trim();
                String password = ((EditText) findViewById(R.id.passEdt)).getText().toString().trim();

                Intent intId = new Intent(getApplicationContext(), InfoActivity.class);
                intId.putExtra("Id", id);
                startActivity(intId);

                try {
                    String res = new LoginRequest().execute(id, password).get();
                    int count = JsonParser.getResultJson(res);

                    if (count == 1) {
                        Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(getApplicationContext(), MainActivity.class);
                        login.putExtra("Count", count);

                        startActivity(login);
                    } else if (count == 0) {
                        Toast.makeText(LoginActivity.this, "아이디나 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "존재하지 않는 아이디입니다", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button joinBtn = (Button) findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });
    }
}