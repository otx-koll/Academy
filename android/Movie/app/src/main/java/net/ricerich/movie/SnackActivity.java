package net.ricerich.movie;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SnackActivity extends Activity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack);

       btnTest = (Button) findViewById(R.id.btnSnack);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackActivity.this, "snack", Toast.LENGTH_SHORT).show();
            }
        });
    }
}