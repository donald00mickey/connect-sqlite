package com.example.connectplus;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper helper = new MyHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT NAME, PRICE FROM PRODUCTS", new String[]{});

        if (cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder  = new StringBuilder();

        do {
            String name = cursor.getString(0);
            double price = cursor.getDouble(1);
            builder.append("NAME - " + name + " PRICE - " + price);

        }while (cursor.moveToNext());
        {
            TextView textView = findViewById(R.id.textData);
            textView.setText(builder.toString());
        }

    }
}