package myapp.androidbook.jp.samplebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScreenTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_transition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // インテントを取得
        Intent intent = getIntent();
        // インテントに保存されたデータを取得
        String data = intent.getStringExtra("list_item");

        Button btn_close;

        // data
        Toast.makeText(ScreenTransitionActivity.this, data, Toast.LENGTH_SHORT).show();

        // 追加：画面のアイテムと紐付け
        btn_close = (Button)findViewById(R.id.btn_close);

        // 追加：クリック
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
