package myapp.androidbook.jp.samplebase;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity {

    private Button btn_close;

    private Button btn_start;
    private Button btn_stop;
    private Button btn_reset;

    private TextView    txt_timer;
    private Switch      swt_startstop;
    private int count = 0;

    private MyTimerTask timerTask = null;
    private Timer timer = null;
    private Handler handler = new Handler();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_close    = (Button) findViewById(R.id.btn_close);

        btn_start       = (Button) findViewById(R.id.btn_start);
        btn_stop     = (Button) findViewById(R.id.btn_stop);
        btn_reset    = (Button) findViewById(R.id.btn_reset);
        txt_timer    = (TextView) findViewById(R.id.txt_timer);
        swt_startstop    = (Switch) findViewById(R.id.swt_startstop);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStart();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStop();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerReset();
            }
        });

        swt_startstop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(TimerActivity.this, "ONにしました。", Toast.LENGTH_SHORT).show();
                    timerStart();
                } else {
                    Toast.makeText(TimerActivity.this, "OFFにしました。", Toast.LENGTH_SHORT).show();
                    timerStop();
                }
            }
        });

    }
    // タイマータスク用のクラス
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            handler.post( new Runnable() {
                public void run() {
                    count++;
                    txt_timer.setText(String.valueOf(count));
                }
            });
        }
    }

    protected void timerStart() {
        // 稼働中の場合は止める
        if (null != timer) {
            timer.cancel();
            timer = null;
        } else {

            // タイマーインスタンスを作成
            timer = new Timer();

            // タイマータスクインスタンスを作成
            timerTask = new MyTimerTask();

            // タイマースケジュールを設定
            timer.schedule(timerTask, 0, 100);
        }
    }
    protected void timerStop() {
        if (null != timer) {
            // タイマーをキャンセル
            timer.cancel();
            timer = null;
        }
    }

    protected void timerReset() {

        // 稼働中の場合は止める
        if (null != timer) {
            timer.cancel();
            timer = null;
        }

        // カウンタを初期化して設定
        count = 0;
        txt_timer.setText(String.valueOf(count));

    }

}
