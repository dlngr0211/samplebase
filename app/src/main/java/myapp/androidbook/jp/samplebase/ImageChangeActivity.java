package myapp.androidbook.jp.samplebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ImageChangeActivity extends AppCompatActivity {

    private Button btn_close;
    private ToggleButton tgl_change;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_change);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        btn_close    = (Button) findViewById(R.id.btn_close);

        tgl_change = (ToggleButton) findViewById(R.id.tgl_change);
        img = (ImageView) findViewById(R.id.img);
        img.setImageResource(R.drawable.cat_touka_hutu);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tgl_change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    img.setImageResource(R.drawable.cat_touka_do);
                } else {
                    img.setImageResource(R.drawable.cat_touka_hutu);
                }
            }
        });
    }

}
