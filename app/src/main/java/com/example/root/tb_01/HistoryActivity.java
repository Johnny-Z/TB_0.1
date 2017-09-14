package com.example.root.tb_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *历史记录相关的都是用这个页面，浏览历史，我评论的。。。等
 */

public class HistoryActivity extends AppCompatActivity {

    private ListView lvTypeList;
    private TextView tvType;
    private List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        lvTypeList= (ListView) findViewById(R.id.lv_typelist);
        tvType= (TextView) findViewById(R.id.tv_type);

        //接收上一个页面传递过来的数据
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        String resultWhat=data.getString("what");

        tvType.setText(resultWhat);

        //传数据给list
        SharedHelper sharedHelper =new SharedHelper(getApplicationContext());
        sharedHelper.loadList(resultWhat,list);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.array_item,list);
        lvTypeList.setAdapter(adapter);

        if(null==list||list.size()==0) {
            Toast.makeText(getApplicationContext(), "没有内容", Toast.LENGTH_SHORT).show();
        }

        //设置listview的监听事件
        lvTypeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(lvTypeList.getContext(),list.get(i),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HistoryActivity.this,
                        TopicDetailActivity.class);
                intent.putExtra("Detail",list.get(i));
                startActivity(intent);
            }
        });
    }
}
