package net.ricerich.movie.Tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

import net.ricerich.movie.Combo.Combo;
import net.ricerich.movie.Combo.Drink;
import net.ricerich.movie.Combo.Popcorn;
import net.ricerich.movie.Combo.Snack;
import net.ricerich.movie.R;

public class SnackActivity extends TabActivity {

    TabHost.TabSpec tabSpecCombo, tabSpecPopcorn, tabSpecDrink, tabSpecSnack;
    Intent itCombo, itPopcorn, itDrink, itSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_snack);

        final TabHost tabHost = getTabHost();

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            ImageView imgLogo = (ImageView) findViewById(R.id.imgLogo);

            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("Combo")) {
                    imgLogo.setImageResource(R.drawable.combo_logo);
                } else if(tabId.equals("Popcorn")) {
                    imgLogo.setImageResource(R.drawable.popcorn_logo);
                } else if(tabId.equals("Drink")) {
                    imgLogo.setImageResource(R.drawable.drink_logo);
                } else if(tabId.equals("Snack")) {
                    imgLogo.setImageResource(R.drawable.snack_logo);
                }
            }
        });

        itCombo = new Intent(getApplicationContext(), Combo.class);
        tabSpecCombo = tabHost.newTabSpec("Combo").setIndicator("콤보").setContent(itCombo);
        tabHost.addTab(tabSpecCombo);

        itPopcorn = new Intent(getApplicationContext(), Popcorn.class);
        tabSpecPopcorn = tabHost.newTabSpec("Popcorn").setIndicator("팝콘").setContent(itPopcorn);
        tabHost.addTab(tabSpecPopcorn);

        itDrink = new Intent(getApplicationContext(), Drink.class);
        tabSpecDrink = tabHost.newTabSpec("Drink").setIndicator("음료").setContent(itDrink);
        tabHost.addTab(tabSpecDrink);

        itSnack = new Intent(getApplicationContext(), Snack.class);
        tabSpecSnack = tabHost.newTabSpec("Snack").setIndicator("스낵").setContent(itSnack);
        tabHost.addTab(tabSpecSnack);

        tabHost.setCurrentTab(0);
    }
}