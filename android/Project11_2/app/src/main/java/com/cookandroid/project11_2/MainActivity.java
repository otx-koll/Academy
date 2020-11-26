package com.cookandroid.project11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

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
            R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
            R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
            R.drawable.mov17, R.drawable.mov18, R.drawable.mov19,
            R.drawable.mov20
        };

        String[] posterTitle = {
            "여인의 향기", "쥬라기 공원", "포레스트 검프",
            "사랑의 블랙홀", "혹성탈출", "아름다운 비행",
            "내 이름은 칸", "해리포터", "마더", "킹콩을 들다"
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

                    // 토스트로 제목을 띄워준다
                    // 1. 토스트 객체 생성
                    // 2. 뷰를 인플레이터 해서 xml을 java 객체로
                    // 3. 뷰안의 위젯(뷰)를 바인딩

                    // 1.
                    Toast toast = new Toast(MainActivity.this);
                    // 2.
                    View toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                    // 3.
                    TextView toastText = (TextView) toastView.findViewById(R.id.posTitle);

                    toastText.setText(posterTitle[pos]);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });

            return imageView;
        }
    }
}