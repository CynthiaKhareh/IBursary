package com.example.ibursary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
private EditText email , password , confirm_password;
private Button Register;
private TextView Login;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        email=(EditText)findViewById(R.id.et_email_register);
        password=(EditText)findViewById(R.id.et_Password_register);
        confirm_password=(EditText)findViewById(R.id.et_ConfirmPassword_register);

        Register=(Button)findViewById(R.id.button_sign_up);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String user_email = email.getText().toString().trim();
             String user_password = password.getText().toString().trim();
             String user_confirm_password = confirm_password.getText().toString().trim();

             if(user_email.equals("")|| user_password.equals("")|| user_confirm_password.equals("")){
                 Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
             }
             else{
                 if(user_password.equals(user_confirm_password)){
                     Boolean check_email = db.check_email(user_email);
                     if(check_email == true){
                         Boolean insert = db.insert(user_email,user_password);
                         if(insert == true){
                             Toast.makeText(getApplicationContext(), "Registered successfully",Toast.LENGTH_SHORT).show();
                             Intent intent_login = new Intent(Register.this,StudentLogin.class);
                             startActivity(intent_login);
                         }
                     }
                     else{
                         Toast.makeText(getApplicationContext(), "Email Already Exists",Toast.LENGTH_SHORT).show();
                     }
                 }
                 else{
                     Toast.makeText(getApplicationContext(), "Password do not match",Toast.LENGTH_SHORT).show();
                 }
             }
            }
        });

        Login= (TextView)findViewById(R.id.textViewLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_intent = new Intent(Register.this, StudentLogin.class);
                startActivity(login_intent);
            }
        });
    }
}