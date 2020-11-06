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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        android.util.Log.d("액티비티1", "11111111");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.util.Log.d("액티비티1", "2222_클릭");

                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

                RadioGroup rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
                RadioButton rd = (RadioButton) findViewById(rdGroup.getCheckedRadioButtonId());
                String rdValue = rd.getText().toString();

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                intent.putExtra("RadioButton", rdValue);

                android.util.Log.d("액티비티1", "33333");

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