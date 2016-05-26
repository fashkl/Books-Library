package com.example.mohamedmabrouk.filedata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
  private EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        userName=(EditText)findViewById(R.id.user_name);
    }

    public void login(View view) {

        //************** for save user name into username.xml SharedPreferences  *************//
        SharedPreferences sharedPreferences = getSharedPreferences("username", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (userName.getText().toString().trim().isEmpty()) {
            Toast.makeText(LogInActivity.this, "Please Enter Your User Name ", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("nam", userName.getText().toString());

            //*********** go to the NexT Activity *********//
            startActivity(new Intent(this, NextActivity.class));
        }
    }


}
