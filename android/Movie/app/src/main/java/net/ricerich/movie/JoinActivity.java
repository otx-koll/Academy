package net.ricerich.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.ricerich.movie.Network.JoinRequest;

public class JoinActivity extends AppCompatActivity {

    private Button checkBtn, joinBtn, canselBtn;
    private Custom_Adapter adapter;
    TextView tvPasswdCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        checkBtn = (Button) findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(JoinActivity.this, "확인되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

        tvPasswdCheck = (TextView) findViewById(R.id.passcheckEdt);
        tvPasswdCheck.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String password = ((EditText) findViewById(R.id.passEdt)).getText().toString();
                String passwordCheck = ((EditText) findViewById(R.id.passcheckEdt)).getText().toString();

                if (hasFocus == false) {
                    if (!(password.equals(passwordCheck)))
                        Toast.makeText(JoinActivity.this, "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        joinBtn = (Button) findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = ((EditText) findViewById(R.id.idEdt)).getText().toString();
                String name = ((EditText) findViewById(R.id.nameEdt)).getText().toString();
                String password = ((EditText) findViewById(R.id.passEdt)).getText().toString();
                String passwordCheck = ((EditText) findViewById(R.id.passcheckEdt)).getText().toString();

                if (name.equals("") || id.equals("") || password.equals("") || passwordCheck.equals("")) {
                    Toast.makeText(JoinActivity.this, "입력하지 않은 값이 있습니다", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    new JoinRequest(adapter).execute(id, name, password);
                    Toast.makeText(JoinActivity.this, "가입성공!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        canselBtn = (Button) findViewById(R.id.cancelBtn);
        canselBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}