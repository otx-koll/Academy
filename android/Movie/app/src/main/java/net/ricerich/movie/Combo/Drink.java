package net.ricerich.movie.Combo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import net.ricerich.movie.R;

public class Drink extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combo_drink);

        GridView gv = (GridView) findViewById(R.id.gvDrink);
        MyGridAdpater gAdapter = new MyGridAdpater(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdpater extends BaseAdapter {
        Context context;

        public MyGridAdpater(Context c) { context = c; }

        @Override
        public int getCount() { return comId.length; }

        @Override
        public Object getItem(int position) { return null; }

        @Override
        public long getItemId(int position) { return 0; }

        Integer[] comId = {
                R.drawable.drink_softdrink_m, R.drawable.drink_softdrink_l, R.drawable.drink_ame_hot, R.drawable.drink_ame_ice, R.drawable.drink_icetea
        };

        String[] posterTitle = {"탄산음료(M)", "탄산음료(L)", "아메리카노(HOT)", "아메리카노(ICE)", "아이스티(M"};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(context);
            iv.setLayoutParams(new GridView.LayoutParams(400, 500));
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(5, 5, 5, 5);

            iv.setImageResource(comId[position]);

            final int pos = position;
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    View dialogView = (View) View.inflate(Combo.this, R.layout.dialog_combo, null);
//                    AlertDialog.Builder dlg = new AlertDialog.Builder(Combo.this);
//                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
//                    ivPoster.setImageResource(comId[pos]);
//                    dlg.setTitle(posterTitle[pos]);
//                    dlg.setView(dialogView);
//                    dlg.setNegativeButton("닫기", null);
//                    dlg.show();
                }
            });

            return iv;
        }
    }
}