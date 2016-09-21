package com.example.apple.mylistview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String city[] = {"台北","台中","台南","高雄"};
    String code[] = {"02", "04", "06", "07"};
    ArrayList<Map<String, String>> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0;i<city.length;i++){
            Map<String, String> m = new HashMap();
            m.put("city",city[i]);
            m.put("code",code[i]);
            data.add(m);
        }
        ListView lv = (ListView)findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, data, R.layout.mylist,
                new String[]{"city", "code"}, new int[] {R.id.textView, R.id.textView2});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click "+city[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
