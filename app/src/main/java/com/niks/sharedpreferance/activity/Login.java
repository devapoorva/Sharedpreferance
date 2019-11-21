package com.niks.sharedpreferance.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.niks.sharedpreferance.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");
        Toast.makeText(Login.this,email+"\n"+password,Toast.LENGTH_SHORT).show();
    }
}
