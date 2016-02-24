package myapp.androidbook.jp.samplebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Map functionMap = new HashMap<Object, String>();
        functionMap.put("画面遷移テスト", "ScreenTransitionActivity");
        functionMap.put("カウンター", "CounterActivity");
        functionMap.put("タイマー", "TimerActivity");
        functionMap.put("画像回転", "ImageViewActivity");
        functionMap.put("画像切替", "ImageChangeActivity")
        ;
        List functionList = new ArrayList(functionMap.keySet());

        // 表示用データ
        Object[] list =  functionList.toArray();

        // 紐付け
        ListView listview = (ListView)findViewById(R.id.listView);

        // ArrayAdapterへ設定
        ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(
                MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                list);

        // リストビューへ設定
        listview.setAdapter(adapter);

        // リストをクリック
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // リストビューの項目を取得
                ListView listview = (ListView) parent;
                String item = (String) listview.getItemAtPosition(position);

                // ClassLoader loader = ClassLoader.getSystemClassLoader();
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                try {
                    Log.d("shima:key:", item);
                    Log.d("shima:activity:", functionMap.get(item).toString());
                    // インテントのインスタンス生成
                    Intent intent = new Intent(MainActivity.this, loader.loadClass(getPackageName() + "." + functionMap.get(item).toString()));
                    // 値をセットする
                    intent.putExtra("list_item", item);

                    // 次画面のアクティビティ起動
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
