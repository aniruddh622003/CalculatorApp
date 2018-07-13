package com.dhd.calculator;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.dhd.calculator.R;

public class Spash extends AppCompatActivity {

    private int Splash_Time = 2;
    Handler handler;
    ShardPref shardPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shardPref = new ShardPref(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (shardPref.getNightMode()==true) {
                    Intent intent = new Intent(Spash.this, activity_main_dark.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(Spash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },Splash_Time * 1000);
    }
}
