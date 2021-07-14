package com.example.ibursary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {
private EditText email , password;
private Button login;
private TextView sign_Up;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_student_login);
        db = new DatabaseHelper(this);
        email=(EditText)findViewById(R.id.et_Email_login);
        password=(EditText)findViewById(R.id.et_password_login);

        login= findViewById(R.id.button_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                Boolean check_email_password = db.email_password(user_email,user_password);
                if(check_email_password == true){
                    Toast.makeText(getApplicationContext(),"Login successfull",Toast.LENGTH_SHORT).show();
                    Intent navigation_intent = new Intent(StudentLogin.this,navigationDrawer.class);
                    startActivity(navigation_intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"email or Password Incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
        sign_Up= findViewById(R.id.textView_sign_up);
        sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_intent = new Intent(StudentLogin.this,Register.class);
                startActivity(register_intent);
            }
        });
    }
}