package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
//import android.view.View;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {
    public Button log_button, guest_button;
    public TextView forgot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log_button = (Button) findViewById(R.id.login);
        log_button.setOnClickListener(v -> {
            Intent loginBut = new Intent(Login_Activity.this,Homepage.class);
            startActivity(loginBut);
        });
         guest_button = (Button) findViewById(R.id.Guest);
         guest_button. setOnClickListener(v -> {
             Intent guestBut = new Intent(Login_Activity.this,Homepage.class);
             startActivity(guestBut);
         });


         forgot = (TextView) findViewById(R.id.forgot);
         forgot.setOnClickListener(v -> {
             Intent forgotText=new Intent(Login_Activity.this, Forgot_Password.class);
             startActivity(forgotText);
         });
    }
}