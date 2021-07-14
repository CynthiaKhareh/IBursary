package com.example.ibursary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ApplicationsFragment extends Fragment {
DatabaseHelper db;
Button view;


    public ApplicationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = new DatabaseHelper((getActivity()));
         View rootView =inflater.inflate(R.layout.fragment_applications, container, false);
         view = (Button)rootView.findViewById(R.id.btn_viewApplication);
         view.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
              //  Intent intent = new Intent(getActivity().getApplication(),ViewApplication.class);
              //  startActivity(intent);
                 Cursor res = db.ViewAllData();
                 if(res.getCount()==0){
                     showMessage("Error" , "No data in db");
                     return;
                 }
                 StringBuffer buffer = new StringBuffer();
                 while (res.moveToNext()){
                     buffer.append("name:" + res.getString(0)+"\n");
                     buffer.append("Birthdate:" + res.getString(1)+"\n");
                     buffer.append("ID:" + res.getString(2)+"\n");
                     buffer.append("Email:" + res.getString(3)+"\n");
                     buffer.append("Phone:" + res.getString(4)+"\n");
                     buffer.append("gn:" + res.getString(5)+"\n");
                     buffer.append("gID:" + res.getString(6)+"\n");
                     buffer.append("gP:" + res.getString(7)+"\n");
                 }
                 showMessage("Data", buffer.toString());
             }
             public void showMessage(String title, String Message){
                 AlertDialog.Builder builder =new  AlertDialog.Builder(ApplicationsFragment.this.getActivity());
                 builder.setCancelable(true);
                 builder.setTitle(title);
                 builder.setMessage(Message);
                 builder.show();
             }

         });
         return rootView;
    }
    }