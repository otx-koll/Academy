package net.ricerich.movie.Tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.ricerich.movie.R;

public class TicketActivity extends Activity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket);

       btnTest = (Button) findViewById(R.id.btnTicket);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TicketActivity.this, "ticket", Toast.LENGTH_SHORT).show();
            }
        });

    }
}