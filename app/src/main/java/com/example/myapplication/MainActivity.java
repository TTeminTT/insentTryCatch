package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

       binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        try {
            SQLiteDatabase data=this.openOrCreateDatabase("Market",MODE_PRIVATE,null);
            data.execSQL("CREATE TABLE IF  NOT EXISTS Urunler(name,birimfiyat)");
            data.execSQL("INSERT INTO urunler(name,birimfiyat)VALUES('DİDO',1)");
            Cursor cursor= data.rawQuery("SELECT *FROM urunler",null);
            while (cursor.moveToNext()){
                System.out.println("Name "+cursor.getString(0)+"-Birimfiyat"+cursor.getString(1));

            }
        }
        catch (Exception e){
            e.printStackTrace();


        }

    }

}