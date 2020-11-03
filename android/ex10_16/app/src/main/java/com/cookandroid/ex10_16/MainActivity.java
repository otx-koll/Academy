package com.cookandroid.ex10_16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rdGroup;
    RadioButton add, minus, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

                rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
                add = (RadioButton) findViewById(R.id.add);
                minus = (RadioButton) findViewById(R.id.minus);
                mul = (RadioButton) findViewById(R.id.mul);
                div = (RadioButton) findViewById(R.id.div);

                // 뭐야이게
                // ;;;
//                String rdId1 = add.getText().toString();
//                rdId1 = rdId1.equals("더하기")? "" : rdId1;

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));



                intent.putExtra("Add", Integer.parseInt(add.getText().toString()));
                intent.putExtra("Minus", Integer.parseInt(minus.getText().toString()));
                intent.putExtra("Mul", Integer.parseInt(mul.getText().toString()));
                intent.putExtra("Div", Integer.parseInt(div.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}