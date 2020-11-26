package net.ricerich.movie;

import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

import net.ricerich.movie.Tab.HomeActivity;
import net.ricerich.movie.Tab.InfoActivity;
import net.ricerich.movie.Tab.SnackActivity;
import net.ricerich.movie.Tab.TicketActivity;

public class MainActivity extends TabActivity {

    TabHost.TabSpec tabSpecHome, tabSpecTicket, tabSpecSnack, tabSpecInfo;
    Intent itHome, itTicket, itSnack, itInfo;

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
//        tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈").setContent(R.id.tabHome);
        tabHost.addTab(tabSpecHome);

        itTicket = new Intent(getApplicationContext(), TicketActivity.class);
        tabSpecTicket = tabHost.newTabSpec("Ticket").setIndicator("예매").setContent(itTicket);
//        tabSpecTicket = tabHost.newTabSpec("Ticket").setIndicator("예매").setContent(R.id.tabTicket);
        tabHost.addTab(tabSpecTicket);

        itSnack = new Intent(getApplicationContext(), SnackActivity.class);
        tabSpecSnack = tabHost.newTabSpec("Snack").setIndicator("스낵").setContent(itSnack);
//        tabSpecSnack = tabHost.newTabSpec("Snack").setIndicator("스낵").setContent(R.id.tabSnack);
        tabHost.addTab(tabSpecSnack);

        Intent intent = getIntent();
        int countRes = intent.getIntExtra("Count", 0);

        if (countRes == 1) {
            itInfo = new Intent(getApplicationContext(), InfoActivity.class);
        } else if (countRes == 0) {
            itInfo = new Intent(getApplicationContext(), LoginActivity.class);
        }
        tabSpecInfo = tabHost.newTabSpec("Info").setIndicator("내정보").setContent(itInfo);
//        tabSpecInfo = tabHost.newTabSpec("Info").setIndicator("내정보").setContent(R.id.tabInfo);
        tabHost.addTab(tabSpecInfo);

        tabHost.setCurrentTab(0);
    }
}