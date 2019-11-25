package com.niks.sharedpreferance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.niks.sharedpreferance.R;

public class DashBoard extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TextView txtEmail,txtPassword;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");

        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);

        txtEmail.setText(email);
        txtPassword.setText(password);

    }

    public void logout(View view) {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        Intent intent = new Intent(DashBoard.this,WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
