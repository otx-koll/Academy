package net.ricerich.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    Button checkBtn, canselBtn;
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

        canselBtn = (Button) findViewById(R.id.cancelBtn);
        canselBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}