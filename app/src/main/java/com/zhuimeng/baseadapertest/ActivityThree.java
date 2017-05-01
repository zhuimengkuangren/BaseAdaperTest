package com.zhuimeng.baseadapertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 追梦 on 2017/5/1.
 **/

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        List<NewsBean> newsBeenList = new ArrayList<>();
        //创建50条数据
        for (int i = 0; i < 50; i++) {
            newsBeenList.add(new NewsBean(
                    "标题" + i,
                    R.mipmap.smile,
                    "内容" + i
            ));
        }

        ListView listView = (ListView) findViewById(R.id.lv_three);
                                            //this：context
        listView.setAdapter(new AdapterThree(this, newsBeenList));
    }
}
