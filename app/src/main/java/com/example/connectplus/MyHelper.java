package com.example.connectplus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

public class MyHelper extends SQLiteOpenHelper {
    private static final String dbname= "mydb";
    private static final int version = 1;
    public MyHelper(Context context){
        super(context, dbname, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PRODUCTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, PRICE REAL)";
        db.execSQL(sql);

        insertData("JAM","SWEET",35.20, db);
        insertData("BISCUIT","CRUNCHY",35.40, db);
        insertData("CHOCOLATE","DARK",35.60, db);
        insertData("FROOTY","PARLE AGRO",35.80, db);


    }

    private void insertData(String name, String description, Double price, SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("DESCRIPTION",description);
        values.put("PRICE", price);
        database.insert("PRODUCTS",null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
