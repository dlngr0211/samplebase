package myapp.androidbook.jp.samplebase;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
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
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView img1;

        img1 = (ImageView)findViewById(R.id.img1);
        img1.setImageResource(R.drawable.cat_touka_do);

        //getDrawableメソッドで取り戻したものを、BitmapDrawable形式にキャストする
        BitmapDrawable bd = (BitmapDrawable)img1.getDrawable();
        //getBitmapメソッドでビットマップファイルを取り出す
        Bitmap bmp = bd.getBitmap();
        //回転させる
        Matrix matrix = new Matrix();
        matrix.postRotate(140.6f);
        //Bitmap回転させる
        Bitmap flippedBmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, false);
        //加工したBitmapを元のImageViewにセットする
        img1.setImageDrawable(new BitmapDrawable(flippedBmp));

    }

}
