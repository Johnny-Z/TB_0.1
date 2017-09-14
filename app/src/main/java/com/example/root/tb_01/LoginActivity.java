package com.example.root.tb_01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *登入界面，单用户模式，不做用户验证
 */

public class LoginActivity extends AppCompatActivity {

    private EditText etLoginUsername, etLoginPassword;
    private Button btnLoginLogin;
    private TextView btnLoginRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = (EditText) findViewById(R.id.login_et_username);
        etLoginPassword = (EditText) findViewById(R.id.login_et_password);
        btnLoginLogin = (Button) findViewById(R.id.login_btn_login);
        btnLoginRegister = (TextView) findViewById(R.id.login_btn_register);


        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void login() {
        final String name = etLoginUsername.getText().toString();
        String password = etLoginPassword.getText().toString();


        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(password)) {
            return;
        }

        Intent intent = new Intent(LoginActivity.this,
                MainActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();

    }

    private void register() {
        Intent intent = new Intent(LoginActivity.this,
                RegisterActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();

    }

}
