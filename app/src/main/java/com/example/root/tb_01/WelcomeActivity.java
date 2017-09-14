package com.example.root.tb_01;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *欢迎界面
 */

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                //切换动画
//                int version = Integer.valueOf(android.os.Build.VERSION.SDK);
//                if(version  >= 5) {
//                    overridePendingTransition(R.anim.dialog_ani_r2l_enter, R.anim.dialog_ani_r2l_exit);
//                }
                WelcomeActivity.this.finish();
            }
        }, 3000);
    }
}
