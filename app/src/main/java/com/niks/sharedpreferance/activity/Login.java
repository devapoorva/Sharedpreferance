package com.niks.sharedpreferance.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.niks.sharedpreferance.R;
import com.niks.sharedpreferance.utils.Auth;

public class Login extends AppCompatActivity {

    private String email,password;
    private EditText edtEmail,edtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // initialize views
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        email = sharedPreferences.getString("email","");
        password = sharedPreferences.getString("password","");
        // Toast.makeText(Login.this,email+"\n"+password,Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        if(validate())
        {
            Intent intent = new Intent(Login.this,DashBoard.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private boolean validate() {
        String userEmail,userPassword;
        userEmail = edtEmail.getText().toString().trim();
        userPassword = edtPassword.getText().toString();
        if(!Auth.isValidEmail(userEmail))
        {
            Toast.makeText(Login.this,"Enter Valid Email",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(Auth.isValidPassword(userPassword))
        {
            Toast.makeText(Login.this,"Enter Valid Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!userEmail.equalsIgnoreCase(email))
        {
            Toast.makeText(Login.this,"Enter Valid Email",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!userPassword.equals(password))
        {
            Toast.makeText(Login.this,"Enter Valid Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
