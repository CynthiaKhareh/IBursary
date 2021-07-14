package com.example.ibursary;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class Apply_BursaryFragment extends Fragment {
    private EditText name,birthdate,nationalID, email,phoneno,gname,gID,gPhone,gRel,uname,uemail,uaddress,utel,admno,yostudy,fpy,fp,bal,helb,bank, branch,accno;
    private RadioButton male,female,Other,upublic,uprivate;
    private CheckBox checkBox;
    private Button submitApplication;
    DatabaseHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_applybursary, container, false);
        db = new DatabaseHelper((getActivity()));
        name =(EditText)rootView.findViewById(R.id.et_names);
        birthdate =(EditText)rootView.findViewById(R.id.et_birth);
        nationalID =(EditText)rootView.findViewById(R.id.et_ID);
        email =(EditText)rootView.findViewById(R.id.et_email);
        phoneno =(EditText)rootView.findViewById(R.id.et_phone);
        gname =(EditText)rootView.findViewById(R.id.et_guardian_names);
        gID =(EditText)rootView.findViewById(R.id.et_guardian_ID);
        gPhone =(EditText)rootView.findViewById(R.id.et_guardian_phone);
        gRel =(EditText)rootView.findViewById(R.id.et_guardian_rel);
        uname =(EditText)rootView.findViewById(R.id.et_institution_name);
        uemail =(EditText)rootView.findViewById(R.id.et_institution_email);
        uaddress =(EditText)rootView.findViewById(R.id.et_Box);
        utel =(EditText)rootView.findViewById(R.id.et_telNo);
        admno =(EditText)rootView.findViewById(R.id.et_AdmNo);
        yostudy =(EditText)rootView.findViewById(R.id.et_year_of_study);
        fpy=(EditText)rootView.findViewById(R.id.et_fees_payable);
        fp =(EditText)rootView.findViewById(R.id.et_fees_paid);
        bal =(EditText)rootView.findViewById(R.id.et_fees_balance);
        helb =(EditText)rootView.findViewById(R.id.et_loans);
        bank=(EditText)rootView.findViewById(R.id.et_BANK);
        branch=(EditText)rootView.findViewById(R.id.et_branch);
        accno=(EditText)rootView.findViewById(R.id.et_account_no);
        checkBox=(CheckBox)rootView.findViewById(R.id.checkbox1);
       final  boolean checked = checkBox.isChecked();
        submitApplication=(Button) rootView.findViewById(R.id.btn_submitApplication);
        submitApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f=name.getText().toString();
                String bd=birthdate.getText().toString();
                String e=email.getText().toString();
                String id=nationalID.getText().toString();
                String pn=phoneno.getText().toString();
                String gn=gname.getText().toString();
                String gid=gID.getText().toString();
                String gp=gPhone.getText().toString();
                String gr=gRel.getText().toString();
                String un=uname.getText().toString();
                String ue=uemail.getText().toString();
                String uadd=uaddress.getText().toString();
                String ut=utel.getText().toString();
                String admn=admno.getText().toString();
                String yos=yostudy.getText().toString();
                String feepy=fpy.getText().toString();
                String feep=fp.getText().toString();
                String fb=bal.getText().toString();
                String h=helb.getText().toString();
                String b=bank.getText().toString();
                String br=branch.getText().toString();
                String acno=accno.getText().toString();

                if(f.equals("")||bd.equals("")|| id.equals("")|| e.equals("")|| pn.equals("")|| gn.equals("")|| gid.equals("")|| gp.equals("")/*|| gr.equals("")|| un.equals("")
                        || ue.equals("")|| uadd.equals("")|| ut.equals("")|| admn.equals("")|| yos.equals("")|| feepy.equals("")|| feep.equals("")|| fb.equals("")|| b.equals("")
                        || br.equals("")|| acno.equals("")||h.equals("")*/){
                        Toast.makeText(Apply_BursaryFragment.this.getActivity(),"empty field",Toast.LENGTH_LONG).show();
                }
                else{
                boolean is_inserted = db.insertData(f,bd,id,e,pn,gn,gid,gp);//,gr,un,ue,uadd,ut,admn,yos,feepy,feep,fb,h,b,br,acno);
                if(is_inserted == true)
                    Toast.makeText(Apply_BursaryFragment.this.getActivity(),"Data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Apply_BursaryFragment.this.getActivity(),"Data Not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }

}
