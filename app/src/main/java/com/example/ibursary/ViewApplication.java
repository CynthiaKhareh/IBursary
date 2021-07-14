package com.example.ibursary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewApplication extends AppCompatActivity {
DatabaseHelper db;
ArrayList<User> userList;
ListView listView;
User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_application);
        db = new DatabaseHelper(this);

    /*    userList = new ArrayList<>();
        Cursor data = db.ViewAllData();
        int numrows = data.getCount();
        if(numrows == 0){
            Toast.makeText(ViewApplication.this,"No data in the database",Toast.LENGTH_SHORT).show();
        }
        else {
            while (data.moveToNext()){
                user = new User(data.getString(0),data.getString(1),data.getString(4));
                userList.add(user);
            }
            Three_column_listadapter adapter = new Three_column_listadapter(this,R.layout.list_adapter_view,userList);
            listView = (ListView)findViewById(R.id.listview);
            listView.setAdapter(adapter);
        }*/
    }
}