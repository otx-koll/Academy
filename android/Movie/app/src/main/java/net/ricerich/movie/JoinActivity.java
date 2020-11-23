package net.ricerich.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    private Button checkBtn, joinBtn, canselBtn;
    private Custom_Adapter adapter;

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

        joinBtn = (Button) findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ((EditText)findViewById(R.id.idEdt)).getText().toString();
                String name = ((EditText)findViewById(R.id.nameEdt)).getText().toString();
                String password = ((EditText)findViewById(R.id.passEdt)).getText().toString();

                new JoinRequest(adapter).execute(id, name, password);

                Toast.makeText(JoinActivity.this, "가입성공!", Toast.LENGTH_SHORT).show();
                finish();
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