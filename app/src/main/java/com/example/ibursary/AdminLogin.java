package com.example.ibursary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    private EditText email , password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_login);
        email=(EditText)findViewById(R.id.et_Email_login);
        password=(EditText)findViewById(R.id.et_password_login);
        login= findViewById(R.id.button_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(email.getText().toString().equals("cynthiangongu7@gmail.com")&& password.getText().toString().equals("ngongu7")){
                   Intent intent = new Intent(AdminLogin.this,AdminHomepage.class);
                   startActivity(intent);
               }
               else{
                   Toast.makeText(AdminLogin.this,"incorrect sign_in",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}