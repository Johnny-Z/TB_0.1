package com.example.root.tb_01;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Map;

/**
 *我的界面
 */

public class PersonalFragment extends android.support.v4.app.Fragment{

    private View viewContent;
    private Button btnChangeinfo;
    private TextView tvName;
    private TextView tvGender;
    private String strName;
    private String strGender;
    private SharedHelper sh;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewContent =  inflater.inflate(R.layout.fragment_personal, null);
        btnChangeinfo= (Button) viewContent.findViewById(R.id.btn_changeinfo);
        tvName= (TextView) viewContent.findViewById(R.id.tv_name);
        tvGender= (TextView) viewContent.findViewById(R.id.tv_gender);

        mContext=viewContent.getContext();
        sh=new SharedHelper(mContext);

        btnChangeinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),PersonalInfoActivity.class);
                //可以回调的方式跳转到下一个页面
                startActivityForResult(intent,0);

            }
        });
        return viewContent;
    }
    // 重写该方法，该方法以回调的方式来获取指定Activity返回的结果
    @Override
    public void onActivityResult(int requestCode
            , int resultCode, Intent intent)
    {
        // 当requestCode、resultCode同时为0时，也就是处理特定的结果
        if (requestCode == 0 && resultCode == 0)
        {
            // 取出Intent里的Extras数据
            Bundle data=intent.getExtras();
            Person p = (Person) data.getSerializable("person");
            // 取出Bundle中的数据
            strName=p.getName();
            strGender=p.getGender();

            tvName.setText(strName);
            tvGender.setText(strGender);

            sh.save("name",strName);
            sh.save("gender",strGender);
        }
    }

    //重写该方法，让修改过信息以后默认显示出来
    @Override
    public void onStart() {
        super.onStart();
        Map<String,String> data=sh.read("name");
        Map<String,String> data1=sh.read("gender");
        tvName.setText(data.get("name"));
        tvGender.setText(data1.get("gender"));
    }
}
