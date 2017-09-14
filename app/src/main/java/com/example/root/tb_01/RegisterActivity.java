package com.example.root.tb_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 *注册界面，注册完以后直接登入，只是个界面
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText etRegUsername, etRegPassword, etRegPassword2;
    private Button btnRegRegister;
    private TextView btnRegLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegUsername = (EditText) findViewById(R.id.reg_et_username);
        etRegPassword = (EditText) findViewById(R.id.reg_et_password);
        etRegPassword2 = (EditText) findViewById(R.id.reg_et_password2);
        btnRegRegister = (Button) findViewById(R.id.reg_btn_register);
        btnRegLogin = (TextView) findViewById(R.id.reg_btn_login);

        btnRegLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnRegRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        final String regName = etRegUsername.getText().toString();
        String regPassword = etRegPassword.getText().toString();
        String regPassword2 = etRegPassword2.getText().toString();

        if (TextUtils.isEmpty(regName)||TextUtils.isEmpty(regPassword)||TextUtils.isEmpty(regPassword2)) {
            return;
        }

        Intent intent = new Intent(RegisterActivity.this,
                MainActivity.class);
        startActivity(intent);
        RegisterActivity.this.finish();
    }

    private void login() {
        Intent intent = new Intent(RegisterActivity.this,
                LoginActivity.class);
        startActivity(intent);
        RegisterActivity.this.finish();
    }
}
