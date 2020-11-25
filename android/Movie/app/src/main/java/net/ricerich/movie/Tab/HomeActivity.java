package net.ricerich.movie.Tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.ricerich.movie.R;

public class HomeActivity extends Activity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_home);

       btnTest = (Button) findViewById(R.id.btnHome);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });
    }
}