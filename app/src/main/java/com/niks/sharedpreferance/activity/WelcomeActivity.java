package com.niks.sharedpreferance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.niks.sharedpreferance.R;

public class WelcomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        if(!sharedPreferences.getString("email","").equalsIgnoreCase(""))
        {
            startActivity(new Intent(WelcomeActivity.this,DashBoard.class));
            finish();
        }
        setContentView(R.layout.activity_welcome);
    }

    public void gotoRegister(View view) {
        Intent intent = new Intent(WelcomeActivity.this,Register.class);
        startActivity(intent);
    }

    public void gotoLogin(View view) {
        startActivity(new Intent(WelcomeActivity.this,Login.class));
    }
}
