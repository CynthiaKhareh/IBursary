package com.example.ibursary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("Create table register(email text primary key, password text)");
      db.execSQL("Create table personaldetails(name text,birthdate integer,nationalID integer, email text primary key,phoneno integer," +
              "guardianname text,guardianID integer ,guardianPhone integer,gender text,guardianRelationship text,uniname text, uniemail text, uniaddress integer, unitel integer," +
              "admissionno integer,yearofstudy integer,unicategory text, feepayable integer, feepaid integer, balance integer, helb integer, bank text," +
              "branch text,accountno varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists register");
       db.execSQL("drop table if exists personaldetails");
    }
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("register", null,contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }
    //check if email exists
    public boolean check_email(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from register where email=?",new String[] {email});
        if(cursor.getCount()>0 )
            return  false;
        else
            return true;
    }
    //checking email and password
    public boolean email_password(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from register where email=? and password=? ",new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean insertData(String name,String birthdate,String nationalID,String email, String phoneno, String gn, String gid,String gp /*,String gr,String un,
                              String ue,String ua,String ut,  String an, String yos,String fpy, String fp, String bal, String helb, String bank,String branch,String accno*/){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("birthdate",birthdate);
        contentValues.put("nationalID",nationalID);
        contentValues.put("email",email);
        contentValues.put("phoneno",phoneno);
        contentValues.put("guardianname",gn);
        contentValues.put("guardianID",gid);
        contentValues.put("guardianPhone",gp);
        //contentValues.put("gender",gender);
       /* contentValues.put("grel",gr);
        contentValues.put("uniname",un);
        contentValues.put("uniemail",ue);
        contentValues.put("uniaddress",ua);
        contentValues.put("unitel",ut);
        contentValues.put("admno",an);
        contentValues.put("studyyear",yos);
        //contentValues.put("unicategory",uc);
        contentValues.put("feepayable",fpy);
        contentValues.put("feepaid",fp);
        contentValues.put("balance",bal);
        contentValues.put("helb",helb);
        contentValues.put("bank",bank);
        contentValues.put("branch",branch);
        contentValues.put("accountno",accno);*/
        long insert = db.insert("personaldetails",null,contentValues);
        if(insert == -1)
            return false;
        else
            return true;
    }
    public Cursor ViewAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from  personaldetails",null);
        return  res;
    }
    public Integer deleteMarks(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("personaldetails", "email = ? ", new String[]{email});
    }
}
