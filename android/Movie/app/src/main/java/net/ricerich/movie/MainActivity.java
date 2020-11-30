package net.ricerich.movie;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import net.ricerich.movie.Tab.HomeActivity;
import net.ricerich.movie.Tab.InfoActivity;
import net.ricerich.movie.Tab.SnackActivity;

public class MainActivity extends TabActivity {

    TabHost.TabSpec tabSpecHome, tabSpecSnack, tabSpecInfo;
    Intent itHome, itSnack, itInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        View view = new View(this);
//
//        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        final TabHost tabHost = getTabHost();

        itHome = new Intent(getApplicationContext(), HomeActivity.class);
        tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈").setContent(itHome);
        tabHost.addTab(tabSpecHome);

        itSnack = new Intent(getApplicationContext(), SnackActivity.class);
        tabSpecSnack = tabHost.newTabSpec("Snack").setIndicator("스낵").setContent(itSnack);
        tabHost.addTab(tabSpecSnack);

        Intent intent = getIntent();
        int countRes = intent.getIntExtra("Count", 0);

        if (countRes == 1) {
            itInfo = new Intent(getApplicationContext(), InfoActivity.class);
        } else if (countRes == 0) {
            itInfo = new Intent(getApplicationContext(), LoginActivity.class);
        }
        tabSpecInfo = tabHost.newTabSpec("Info").setIndicator("내정보").setContent(itInfo);
        tabHost.addTab(tabSpecInfo);

        tabHost.setCurrentTab(0);
    }
}