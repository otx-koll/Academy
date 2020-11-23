package net.ricerich.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends TabActivity {

    TabHost.TabSpec tabSpecHome, tabSpecTicket, tabSpecSnack, tabSpecInfo;
    Intent itHome, itTicket, itSnack, itInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

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
    }
}