package com.example.ibursary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Scholarship");
    }
    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Student:
                Intent intent = new Intent(HomeActivity.this, StudentLogin.class);
                startActivity(intent);
             return true;
             case R.id.Admin:
                 Intent intentAdmin = new Intent(HomeActivity.this, AdminLogin.class);
                 startActivity(intentAdmin);
              return true;
            default:
                return false;
        }
    }
}