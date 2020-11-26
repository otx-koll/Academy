package net.ricerich.movie.Tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import net.ricerich.movie.R;

public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_info);

        TextView idTv = (TextView) findViewById(R.id.tvId);

//        Intent intent = getIntent();
//
//        String id = intent.getStringExtra("Id");
//        idTv.setText(id);
    }
}