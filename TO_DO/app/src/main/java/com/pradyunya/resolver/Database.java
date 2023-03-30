package com.pradyunya.resolver;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
    SQLiteDatabase sd = this.getWritableDatabase();
    static final String dbname = "internship.db";

    public Database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q1 = "create table person(email text primary key,name text,password text,comform_password text);";

        String q2 = "create table tasks(titel text,description text,date text,time text, email text,FOREIGN KEY (email) REFERENCES users(email));";

            db.execSQL(q1);
            db.execSQL(q2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert_data(String email, String name, String password) {

        ContentValues c = new ContentValues();
        c.put("email", email);
        c.put("name", name);
        c.put("password", password);
        long r = sd.insert("person", null, c);
        return r != -1;
    }

    public boolean verify_login(String email, String password) {
        boolean r = false;
        @SuppressLint("Recycle") Cursor c = sd.rawQuery("select * from person where email=?", new String[]{email});

        if (c.getCount() > 0)
        {
            while(c.moveToNext())
            {
                String pas= c.getString(2);
                r= pas.equals(password);
            }

        }
        return r;

    }


    public boolean insert_task(String email, String title, String desc,String date,String time) {

        ContentValues c = new ContentValues();

        c.put("titel", title);
        c.put("description", desc);
        c.put("date", date);
        c.put("time", time);
        c.put("email", email);
        long r = sd.insert("tasks", null, c);
        return r != -1;
    }
    public Cursor getInfo()
    {
        Cursor cursor=sd.rawQuery("select * from tasks",null);
        return cursor;
    }

    public boolean delete(String title)
    {
        @SuppressLint("Recycle") Cursor cursor=sd.rawQuery("select * from tasks where titel=?",new String[]{title});
        if(cursor.getCount()>0)
        {
            long r= sd.delete("tasks","titel=?",new String[]{title});
            if(r==-1) return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }

    public boolean change_profile(String email,String password,String np,String name)
    {
        @SuppressLint("Recycle") Cursor cursor=sd.rawQuery("select * from person where email=?",new String[]{email});
        ContentValues c = new ContentValues();

        c.put("name", name);
        c.put("password", np);

        if(cursor.getCount()>0)
        {


            long r= sd.update("person",c,"email=?",new String[]{email});
            if(r==-1) return false;
            else
                return true;
        }
        else
        {
            return false;
        }
    }




}

