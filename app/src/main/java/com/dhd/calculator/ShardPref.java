package com.dhd.calculator;

import android.content.Context;
import android.content.SharedPreferences;

public class ShardPref {
    SharedPreferences mySharedPref;
    public ShardPref(Context context){
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setNightMode(Boolean state){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Night",state);
        editor.commit();
    }

    public Boolean getNightMode(){
        Boolean state = mySharedPref.getBoolean("Night",false);
        return state;
    }
}
