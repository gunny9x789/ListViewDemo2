package com.example.ad41_daongochai_listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUser, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.et_User);
        etPass = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.btn_login);

        etUser.setBackgroundResource(R.drawable.et_box_login_pass);
        etPass.setBackgroundResource(R.drawable.et_box_login_pass);
        btnLogin.setBackgroundResource(R.drawable.btn_confirm);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Order_screen.class);
                startActivity(intent);
            }
        });
    }
}