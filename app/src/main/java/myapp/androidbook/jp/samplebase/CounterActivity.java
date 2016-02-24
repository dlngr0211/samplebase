package myapp.androidbook.jp.samplebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private Button btn_close;

    int count = 0;
    TextView txt_counter;
    Button btn_countup;
    Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 追加：画面のアイテムと紐付け
        btn_close    = (Button) findViewById(R.id.btn_close);

        txt_counter     = (TextView)findViewById(R.id.txt_counter);
        btn_countup = (Button)findViewById(R.id.btn_countup);
        btn_reset       = (Button)findViewById(R.id.btn_reset);

        // 追加：閉じる
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 追加：クリック
        btn_countup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txt_counter.setText(String.valueOf(count));
            }
        });

        // 追加：リセット
        btn_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count = 0;
                txt_counter.setText(String.valueOf(0));
            }
        });

    }

}
