package com.example.root.tb_01;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *正文界面
 */

public class TopicDetailActivity extends AppCompatActivity {

    private TextView tvTitle,tvMenu;
    private EditText etCommont;
    private Button btnCommont;
    private ListView lvCmtList;
    private SharedHelper sHelper;
    private List<String> detail=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        tvTitle= (TextView) findViewById(R.id.tv_title);
        sHelper=new SharedHelper(getApplicationContext());

        String resultTitle;

        //接收上一个界面的数据
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        resultTitle=data.getString("Detail");

        tvTitle.setText(resultTitle);

        //浏览历史，收藏，点赞，帮上热门
        historyRecord(resultTitle);

        //发布评论
        commontFunction(resultTitle);

    }

    private void historyRecord(final String Title) {

        sHelper.saveList("浏览历史",Title);

        tvMenu= (TextView) findViewById(R.id.tv_menu);
        tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(TopicDetailActivity.this,tvMenu);
                popup.getMenuInflater().inflate(R.menu.menu_pop, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.favorite:
                                if(1==sHelper.saveList("我收藏的",Title)){
                                    Toast.makeText(TopicDetailActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(TopicDetailActivity.this,"收藏过了",Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.star:
                                if(1==sHelper.saveList("我赞过的",Title)){
                                    Toast.makeText(TopicDetailActivity.this,"已点赞",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(TopicDetailActivity.this,"赞过了",Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.hot:
                                if(1==sHelper.saveList("热门话题",Title)){
                                    Toast.makeText(TopicDetailActivity.this,"已上热门",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(TopicDetailActivity.this,"已在热门话题",Toast.LENGTH_SHORT).show();
                                }
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    private void commontFunction(final String Title) {
        etCommont= (EditText) findViewById(R.id.et_commont);
        btnCommont= (Button) findViewById(R.id.btn_commont);
        lvCmtList= (ListView) findViewById(R.id.lv_cmtlist);

        sHelper.loadList(Title,detail);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.array_item_detail,detail);
        lvCmtList.setAdapter(adapter);
        btnCommont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //记录评论的内容
                if (etCommont.getText().toString().equals("")){
                    Toast.makeText(TopicDetailActivity.this, "不能提交空评论", Toast.LENGTH_SHORT).show();
                }else {
                    if (1 == sHelper.saveList(Title, "匿名：" + etCommont.getText().toString())) {
                        Toast.makeText(TopicDetailActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
                        //记录评论过的帖子
                        sHelper.saveList("我评论的", Title);
                        //清空输入的内容
                        etCommont.setText("");
                        //刷新页面
                        onStart();
                    } else {
                        Toast.makeText(TopicDetailActivity.this, "重复评论", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        String resultTitle=data.getString("Detail");
        commontFunction(resultTitle);
    }
}
