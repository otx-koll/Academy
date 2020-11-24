package net.ricerich.movie;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

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

        final TabHost tabHost = getTabHost();

        itHome = new Intent(getApplicationContext(), HomeActivity.class);
        tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈").setContent(itHome);
        tabHost.addTab(tabSpecHome);

        itTicket = new Intent(getApplicationContext(), TicketActivity.class);
        tabSpecTicket = tabHost.newTabSpec("Ticket").setIndicator("예매").setContent(itTicket);
        tabHost.addTab(tabSpecTicket);

        itSnack = new Intent(getApplicationContext(), SnackActivity.class);
        tabSpecSnack = tabHost.newTabSpec("Snack").setIndicator("스낵").setContent(itSnack);
        tabHost.addTab(tabSpecSnack);

        itInfo = new Intent(getApplicationContext(), InfoActivity.class);
        tabSpecInfo = tabHost.newTabSpec("Info").setIndicator("내정보").setContent(itInfo);
        tabHost.addTab(tabSpecInfo);

        tabHost.setCurrentTab(0);

// 탭호스트 슬라이드
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                View currentView = tabHost.getCurrentView();
//                currentView.setAnimation(R.anim.);
//            }
//        });
    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        overridePendingTransition(R.anim.silde_in_left, R.anim.slide_out_left);
//    }
}