package com.cookandroid.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 1. 멤버변수
    // 2. 생성자

    // 3. 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    // 4. 내부 클래스(MainActivity의 멤버)
    public class MyGridAdapter extends BaseAdapter {
        Activity act;

        Integer[] posterId = {
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                R.drawable.mov10
        };

        String[] posterTitle = {"써니", "완득이", "괴물", "라디오스타", "비열한 거리", "왕의 남자", "아일랜드", "웰컴투동막골", "헬보이", "백투더퓨처"};

        public MyGridAdapter(Activity act) {
            this.act = act;
        }

        // getCount() : 그리드뷰에 보여질 이미지의 개수를 반환하도록 수정
        // getView() : 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함
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

        // 한칸의 view. getView. 어댑터를 뷰에 꽂는다.
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 150)); // 이미지뷰의 크기 200 x 300으로 지정
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 각 그리드뷰 칸의 중앙에 배치
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterId[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterId[pos]);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView); //
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageView;
        }
    }
}
