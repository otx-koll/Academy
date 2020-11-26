package net.ricerich.movie.Tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.ricerich.movie.R;

public class HomeActivity extends Activity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }
    public class MyGalleryAdapter extends BaseAdapter {
        Activity act;

        public MyGalleryAdapter(Activity act) {
            this.act = act;
        }

        Integer[] posterId = {
                R.drawable.combo_double, R.drawable.combo_ggv, R.drawable.combo_large,
                R.drawable.combo_small
        };

        String[] posterTitle = {
                "여인의 향기", "쥬라기 공원", "포레스트 검프",
                "사랑의 블랙홀"
        };

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(act);
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 350));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterId[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterId[pos]);

                    return false;
                }
            });


            return imageView;
        }
    }
}