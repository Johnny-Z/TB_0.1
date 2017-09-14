package com.example.root.tb_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 *修改个人信息界面
 */

public class PersonalInfoActivity extends AppCompatActivity {

    private Button btnChangeNow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        btnChangeNow= (Button) findViewById(R.id.btn_changenow);
        btnChangeNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName= (EditText) findViewById(R.id.et_name);
                RadioButton rbMale= (RadioButton) findViewById(R.id.rb_male);
                String stGender=rbMale.isChecked() ? "男" : "女";
                //获取昵称和性别信息
                Person p=new Person(etName.getText().toString(),stGender);
                //传递信息给下一个页面
                Bundle data=new Bundle();
                data.putSerializable("person",p);
                Intent intent= getIntent();
                intent.putExtras(data);
                PersonalInfoActivity.this.setResult(0,intent);
                PersonalInfoActivity.this.finish();
            }
        });

    }
}
