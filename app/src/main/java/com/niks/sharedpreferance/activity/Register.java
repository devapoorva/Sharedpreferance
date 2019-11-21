package com.niks.sharedpreferance.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.niks.sharedpreferance.R;

public class Register extends AppCompatActivity {

    EditText email,password;
    private String userEmail,userpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initializeView();
    }

    private void initializeView() {
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);

    }

    public void register(View view) {
        if(validate())
        {
            SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email",userEmail);
            editor.putString("password",userpassword);
            editor.apply();
            startActivity(new Intent(Register.this,Login.class));
        }
    }

    private boolean validate() {
        userEmail = email.getText().toString().trim();
        userpassword = password.getText().toString();
        return true;
    }
}
