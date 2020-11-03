package com.cookandroid.project10_2;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    TextView tvBest;
    ImageView imgBest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent(); // 메인 액티비티에서 보낸 인텐트 받고
        int[] voteResult = intent.getIntArrayExtra("VoteCount"); // 넘겨받은 투표 결과 배열과
        String[] imageName = intent.getStringArrayExtra("ImageName"); // 그림 이름 배열 저장

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvId[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarId[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvId[i]);
            rbar[i] = (RatingBar) findViewById(rbarId[i]);
        }

        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating(voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Integer imageFiledId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        tvBest = (TextView) findViewById(R.id.tvBest);
        imgBest = (ImageView) findViewById(R.id.imgBest);

        int max = 0;
        for (int i = 0; i < voteResult.length; i++) {
            if (voteResult[i] > voteResult[max]) {
                max = i;
            }
        }
        tvBest.setText(imageName[max]);
        imgBest.setImageResource(imageFiledId[max]);
    }
}
