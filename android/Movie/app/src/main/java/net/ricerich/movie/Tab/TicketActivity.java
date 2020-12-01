package net.ricerich.movie.Tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.ricerich.movie.R;

public class TicketActivity extends Activity {

    TextView tvTitle, tvKinds, tvOpen, tvAge, tvTime, tvStory;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket);

        Intent intent = getIntent();
        int resPos = intent.getIntExtra("Position", 0);
        int resPic[] = intent.getIntArrayExtra("Picture");
        String resTitle[] = intent.getStringArrayExtra("Title");
        String resKinds[] = intent.getStringArrayExtra("Kinds");
        String resOpen[] = intent.getStringArrayExtra("Open");
        String resAge[] = intent.getStringArrayExtra("Age");
        String resTime[] = intent.getStringArrayExtra("Time");

        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvKinds = (TextView)findViewById(R.id.tvKinds);
        tvOpen = (TextView)findViewById(R.id.tvOpen);
        tvAge = (TextView)findViewById(R.id.tvAge);
        tvTime = (TextView)findViewById(R.id.tvTime);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);
        tvStory = (TextView) findViewById(R.id.tvStory);

        tvTitle.setText(resTitle[resPos]);
        tvKinds.setText(resKinds[resPos]);
        tvOpen.setText(resOpen[resPos]);
        tvAge.setText(resAge[resPos]);
        tvTime.setText(resTime[resPos]);
        ivPoster.setImageResource(resPic[resPos]);
        switch(resPos) {
            case 0:
                tvStory.setText("백수가장 좌천위기 도청팀장 대권(정우)은 팀원들과 함께 해외에서 입국하자마자 자택 격리된 정치인 가족을 24시간 감시하라는 미션을 받는다. 이웃집으로 위장 이사온 도청팀원들은 라디오 사연 신청부터 한밤중에 나는 부스럭 소리까지 수상한 가족들의 모든 소리와 행동을 감시하면서 새로운 비밀들을 하나씩 발견하게 되는데…");
                break;
            case 1:
                tvStory.setText("흙 맛만 봐도 보물을 찾아내는 타고난 천재 도굴꾼 강동구(이제훈). 자칭 한국의 '인디아나 존스'로 불리는 고분벽화 도굴 전문가 존스 박사(조우진)," +
                        "전설의 삽질 달인 삽다리(임원희)를 만나 환상(?)의 팀플레이를 자랑하며 위험천만하고도 짜릿한 도굴의 판을 키운다. 한편, 그의 재능을 알아본 고미술계 엘리트 큐레이터 윤실장(신혜선)은" +
                        " 강동구에게 매력적이면서도 위험한 거래를 제안하는데...!");
                break;
            case 2:
                tvStory.setText("태어날 때부터 장애 때문에 휠체어를 타고 외딴 집에서 엄마와 함께 살며 일상을 보내는 ‘클로이’. 딸을 사랑으로 돌보는 엄마 덕분에 힘들지만 매일을 긍정적으로 살아간다. 그러던 어느 날 식탁에 놓인 장바구니에서 하나의 물건을 발견하게 되고 믿었던 모든 일상이 흔들리기 시작하는데…");
                break;
            case 3:
                tvStory.setText("평범 이하, 존재감 제로 고등학생 밀리가 우연히 중년의 싸이코 살인마와 몸이 바뀌게 되면서 벌어지는 예측불가 호러테이닝 영화");
                break;
            case 4:
                tvStory.setText("잔심부름을 하러 간 공장에서 검은 폐수가 유출되는 것을 목격한 ‘자영’은" +
                        " ‘유나’, ‘보람’과 함께 회사가 무엇을 감추고자 하는지, 결정적 증거를 찾으려 한다." +
                        " 불가능해 보이는 싸움, 세 친구는 해고의 위험을 무릅쓰고 고군분투를 시작하는데…");
                break;
            case 5:
                tvStory.setText("오랜 공백 이후 복직을 앞둔 형사 ‘현수’는 범죄 사건의 주요 증인이었던 소녀의 실종을 자살로 종결 짓기 위해 그곳으로 향한다. 소녀의 보호를 담당하던 전직 형사, 연락이 두절된 가족, 그리고 소녀를 마지막으로 목격한 마을 주민 ‘순천댁’을 만나 그녀의 행적을 추적해 나가던 '현수'는 소녀가 홀로 감내했을 고통에 가슴 아파한다. 수사가 진행될수록 자신의 모습과 닮아있는 소녀에게 점점 더 몰두하게 된 ‘현수’는 사건 이면에 감춰진 진실 앞에 한걸음 다가서게 되는데…");
                break;
        }

        Button btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}