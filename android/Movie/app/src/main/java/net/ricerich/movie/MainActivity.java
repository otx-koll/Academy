package net.ricerich.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    TabHost.TabSpec tabSpecHome, tabSpecTicket, tabSpecSnack, tabSpecInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater in = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        in.inflate(R.layout.home, findViewById(R.id.tabHome), true);
        in.inflate(R.layout.ticket, findViewById(R.id.tabTicket), true);
        in.inflate(R.layout.snack, findViewById(R.id.tabSnack), true);
        in.inflate(R.layout.info, findViewById(R.id.tabInfo), true);

        TabHost tabHost = getTabHost();

        tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈").setContent(R.id.home);
        tabHost.addTab(tabSpecHome);

        tabSpecTicket = tabHost.newTabSpec("Ticket").setIndicator("예매").setContent(R.id.tabTicket);
        tabHost.addTab(tabSpecTicket);

        tabSpecSnack = tabHost.newTabSpec("Snack").setIndicator("스낵").setContent(R.id.tabSnack);
        tabHost.addTab(tabSpecSnack);

        tabSpecInfo = tabHost.newTabSpec("Info").setIndicator("내정보").setContent(R.id.tabInfo);
        tabHost.addTab(tabSpecInfo);

        tabHost.setCurrentTab(0);


    }
}