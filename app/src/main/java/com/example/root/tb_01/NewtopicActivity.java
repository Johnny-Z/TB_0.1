package com.example.root.tb_01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 *新建新帖
 */

public class NewtopicActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etDetail;
    private TextView tvPublish;
    private Spinner spType;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtopic);

        etTitle= (EditText) findViewById(R.id.et_title);
        etDetail = (EditText) findViewById(R.id.et_input);
        tvPublish= (TextView) findViewById(R.id.tv_publish);
        mContext = getApplicationContext();

        //内容过多时可以上下滑动
        etDetail.setMovementMethod(ScrollingMovementMethod.getInstance());

        tvPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (1==publish()){
                    NewtopicActivity.this.finish();
                }
            }
        });

    }

    private int publish() {
        SharedHelper sHelper=new SharedHelper(mContext);
        spType= (Spinner) findViewById(R.id.sp_type);
        String topicType= (String) spType.getSelectedItem();

        String fileTitle = etTitle.getText().toString();
        String fileDetail = etDetail.getText().toString();

        if(fileTitle.equals("")){
            Toast.makeText(getApplicationContext(), "标题不能为空", Toast.LENGTH_SHORT).show();
            return 0;
        }else if(fileDetail.equals("")) {
            Toast.makeText(getApplicationContext(), "内容不能为空", Toast.LENGTH_SHORT).show();
            return 0;
        }
        //记录我发布的,如果已有相同标题的内容，则提示标题已存在
        if (0==sHelper.saveList("我发布的",fileTitle)){
            Toast.makeText(getApplicationContext(), "标题已存在", Toast.LENGTH_SHORT).show();
            return 0;
        }

        //记录发布的是属于那个类别，游戏还是其他,
        sHelper.saveList(topicType,fileTitle);

        //把发布的内容记录下来，标题和正文
        sHelper.saveList(fileTitle,fileDetail);

        return 1;
    }
}
