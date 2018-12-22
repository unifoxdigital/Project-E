package com.hihasan.e_traceability.globe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private AppCompatEditText phone, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone=(AppCompatEditText) findViewById (R.id.input_phone);
        password=(AppCompatEditText) findViewById (R.id.input_password);

        if (phone.getText().equals("017") && password.getText().equals("1234")){
            Intent i=new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);

        }

        else {
            Toast.makeText(getApplicationContext(),"Wrong User Id & Password",Toast.LENGTH_SHORT).show();
        }
    }
}
