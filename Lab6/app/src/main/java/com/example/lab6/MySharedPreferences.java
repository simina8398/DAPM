package com.example.lab6;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    public MySharedPreferences(Context context) {
        settings = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = settings.edit();
    }

    public void save(String text){
        editor.putString("lab6", text); // Storing string
        editor.commit();
    }

    public String getValue(){
        return settings.getString("lab6", null);// getting String
    }

    public void clearSharedPreferences(){
        editor.remove("lab6");
        editor.commit();
    }
}