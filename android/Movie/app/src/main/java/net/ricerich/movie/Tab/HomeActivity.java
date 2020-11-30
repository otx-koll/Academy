package net.ricerich.movie.Tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import net.ricerich.movie.JoinActivity;
import net.ricerich.movie.R;
import net.ricerich.movie.TicketActivity;

public class HomeActivity extends Activity {

    Button btnTicket;
    TextView tvTitle, tvKinds, tvOpen, tvAge, tvTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        ImageView load = (ImageView) findViewById(R.id.pos);
        Glide.with(this).load(R.drawable.poster_minion).into(load);

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }
    public class MyGalleryAdapter extends BaseAdapter {
        Activity act;

        public MyGalleryAdapter(Activity act) {
            this.act = act;
        }

        int[] posPic = {
                R.drawable.poster_neighbor_cousin, R.drawable.poster_dogul, R.drawable.poster_run,
                R.drawable.poster_freaky_death_day, R.drawable.poster_3_toic, R.drawable.poster_when_i_die
        };

        String[] posTitle = {
                "이웃 사촌", "도굴", "런",
                "프리디 데스 데이", "삼진 그룹영어 토익반", "내가 죽던 날"
        };

        String[] posKinds = {
                "드라마/코미디", "범죄/케피어필름", "미스터리/스릴러",
                "공포/코미디", "드라마/코미디", "드라마"
        };

        String[] posOpen = {
                "2020.11.25", "2020.11.04", "2020.11.20",
                "2020.11.25", "2020.10.21", "2020.11.12"
        };

        String[] posAge = {
                "12세 이상 관람가", "12세 이상 관람가", "15세 이상 관람가",
                "청소년 이용불가", "12세 이상 관람가", "12세 이상 관람가"
        };

        String[] posTime = {
                "2시간 10분", "1시간 55분", "1시간 29분",
                "1시간 43분", "1시간 50분", "1시간 56분"
        };

        @Override
        public int getCount() {
            return posPic.length;
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
            imageView.setImageResource(posPic[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    LinearLayout posLine = (LinearLayout) findViewById(R.id.posLine);
                    btnTicket = (Button) findViewById(R.id.btnTicket);
                    if(posLine.getVisibility() == View.GONE) {
                        posLine.setVisibility(View.VISIBLE);
                        btnTicket.setVisibility(View.VISIBLE);
                    }

                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posPic[pos]);

                    tvTitle = (TextView)findViewById(R.id.tvTitle);
                    tvKinds = (TextView)findViewById(R.id.tvKinds);
                    tvOpen = (TextView)findViewById(R.id.tvOpen);
                    tvAge = (TextView)findViewById(R.id.tvAge);
                    tvTime = (TextView)findViewById(R.id.tvTime);

                    tvTitle.setText(posTitle[pos]);
                    tvKinds.setText(posKinds[pos]);
                    tvOpen.setText(posOpen[pos]);
                    tvAge.setText(posAge[pos]);
                    tvTime.setText(posTime[pos]);

                    btnTicket = (Button) findViewById(R.id.btnTicket);
                    btnTicket.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), TicketActivity.class);
                            intent.putExtra("Position", pos);
                            intent.putExtra("Picture", posPic);
                            intent.putExtra("Title", posTitle);
                            intent.putExtra("Kinds", posKinds);
                            intent.putExtra("Open", posOpen);
                            intent.putExtra("Age", posAge);
                            intent.putExtra("Time", posTime);
                            startActivity(intent);
                        }
                    });
                    return false;
                }
            });
            return imageView;
        }
    }
}