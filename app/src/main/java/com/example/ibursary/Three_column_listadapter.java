package com.example.ibursary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Three_column_listadapter extends ArrayAdapter<User> {
    private LayoutInflater minflater;
    private ArrayList<User> users;
    private int mviewResourceid;
    public Three_column_listadapter(@NonNull Context context, int textvresourceid,ArrayList<User> users) {
        super(context, textvresourceid,users);
        this.users =users;
        minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mviewResourceid = textvresourceid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = minflater.inflate(mviewResourceid,null);
        User user = users.get(position);
        if(user!=null){
            TextView names = (TextView) convertView.findViewById(R.id.names);
            TextView University = (TextView) convertView.findViewById(R.id.university);
            TextView Admission_no = (TextView) convertView.findViewById(R.id.admission);
            TextView fee_payable = (TextView) convertView.findViewById(R.id.fee_payable);
            TextView fee_balance = (TextView) convertView.findViewById(R.id.fee_balance);
            TextView applicstion_date = (TextView) convertView.findViewById(R.id.application_date);
            if(names!=null){
                names.setText((user.getNames()));
            }

            if(University!=null){
                University.setText((user.getUniversity()));
            }

            if(Admission_no!=null){
                Admission_no.setText((user.getAdmission_no()));
            }
            if(fee_payable!=null){
                fee_payable.setText((user.getFee_payable()));
            }
            if(fee_balance!=null){
                fee_balance.setText((user.getFee_balance()));
            }
            if(applicstion_date!=null){
                Admission_no.setText((user.getApplication_date()));
            }
        }
        return convertView;
    }
}
