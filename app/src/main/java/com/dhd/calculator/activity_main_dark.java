package com.dhd.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class activity_main_dark extends AppCompatActivity {

    ShardPref shardPref;

    private Button zerod;
    private Button oned;
    private Button twod;
    private Button threed;
    private Button fourd;
    private Button fived;
    private Button sixd;
    private Button sevend;
    private Button eightd;
    private Button nined;
    private Button addd;
    private Button subtractd;
    private Button multiplyd;
    private Button divided;
    private Button cleard;
    private Button deleted;
    private Button exitd;
    private Button equald;
    private Button dotd;
    private Button negd;
    private TextView inputd;
    private TextView resultd;
    private TextView signd;
    private TextView eqtvd;
    private final char ADDd = '+';
    private final char SUBd = '-';
    private final char MULTIPLYd = '*';
    private final char DIVIDEd = '/';
    private final char EQUd = 0;
    private final char NEGd = '_';
    private double val1d = Double.NaN;
    private double val2d;
    private char ACTIONd;
    private DecimalFormat decimalFormatd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shardPref = new ShardPref(this);
        if(shardPref.getNightMode()==false){
            Intent intent = new Intent(activity_main_dark.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dark);

        ChangeStatusColor();
        android.support.v7.widget.Toolbar mtoolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.tooldark);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().show();

        decimalFormatd = new DecimalFormat("#.####");

        setupUIViews();

        zerod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "0");
            }
        });

        oned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "1");
            }
        });

        twod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "2");
            }
        });

        threed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "3");
            }
        });

        fourd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "4");
            }
        });

        fived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "5");
            }
        });

        sixd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "6");
            }
        });

        sevend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "7");
            }
        });

        eightd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "8");
            }
        });

        nined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + "9");
            }
        });
        dotd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputd.setText(inputd.getText().toString() + ".");
            }
        });
        addd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDark();
                ACTIONd = ADDd;
                resultd.setText(decimalFormatd.format(val1d));
                signd.setText("+");
                inputd.setText(null);
            }
        });
        subtractd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDark();
                ACTIONd = SUBd;
                resultd.setText(decimalFormatd.format(val1d));
                signd.setText("-");
                inputd.setText(null);
            }
        });
        multiplyd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDark();
                ACTIONd = MULTIPLYd;
                resultd.setText(decimalFormatd.format(val1d));
                signd.setText("×");
                inputd.setText(null);
            }
        });
        divided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDark();
                ACTIONd = DIVIDEd;
                resultd.setText(decimalFormatd.format(val1d));
                signd.setText("÷");
                inputd.setText(null);
            }
        });
        negd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDark();
                ACTIONd = NEGd;
                inputd.setText("-" + decimalFormatd.format(val1d));
            }
        });
        equald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeDark();
                ACTIONd = EQUd;
                if (decimalFormatd.format(val1d).length() > 10){
                    Toast.makeText(getApplicationContext(),"Value too Big",Toast.LENGTH_LONG).show();
                }else if (inputd.getText().length() == 0 || inputd.getText().toString() == "" || inputd.getText().toString() == null) {
                    Toast.makeText(getApplicationContext(), "Enter Some value", Toast.LENGTH_SHORT);
                    return;
                }
                else {

                    resultd.setText(decimalFormatd.format(val1d));
                    signd.setText("=");
                    inputd.setText(null);
                }


            }
        });
        cleard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputd.getText().toString().length() > 0) {
                    CharSequence name = inputd.getText().toString();
                    inputd.setText(name.subSequence(0, name.length() - 1));
                }
                else{
                    val1d = Double.NaN;
                    val2d = Double.NaN;
                    inputd.setText(null);
                    resultd.setText(null);
                    signd.setText(null);

                }


            }
        });
        cleard.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                val1d = Double.NaN;
                val2d = Double.NaN;
                inputd.setText(null);
                resultd.setText(null);
                signd.setText(null);

                return true;
            }

        });
        deleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1d = Double.NaN;
                val2d = Double.NaN;
                inputd.setText(null);
                resultd.setText(null);
                signd.setText(null);

            }
        });
        exitd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Long Press to Exit",Toast.LENGTH_SHORT).show();
            }
        });

        exitd.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                finish();
                System.exit(0);
                return true;
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_dark, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.Light){
            Intent intent = new Intent(activity_main_dark.this, MainActivity.class);
            shardPref.setNightMode(false);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void ChangeStatusColor(){
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.GreenDarker));
    }

    private void setupUIViews(){

        zerod = (Button)findViewById(R.id.Button0dark);
        oned = (Button)findViewById(R.id.Button1dark);
        twod = (Button)findViewById(R.id.Button2dark);
        threed = (Button)findViewById(R.id.Button3dark);
        fourd = (Button)findViewById(R.id.Button4dark);
        fived = (Button)findViewById(R.id.Button5dark);
        sixd = (Button)findViewById(R.id.Button6dark);
        sevend = (Button)findViewById(R.id.Button7dark);
        eightd = (Button)findViewById(R.id.Button8dark);
        nined = (Button)findViewById(R.id.Button9dark);
        dotd = (Button)findViewById(R.id.dotdark);
        negd = (Button)findViewById(R.id.negdark);
        addd = (Button)findViewById(R.id.plusdark);
        subtractd = (Button)findViewById(R.id.minusdark);
        multiplyd = (Button)findViewById(R.id.multiplydark);
        divided = (Button)findViewById(R.id.Dividedark);
        cleard = (Button)findViewById(R.id.cleardark);
        deleted = (Button)findViewById(R.id.Deldark);
        exitd = (Button)findViewById(R.id.exitdark);
        equald = (Button)findViewById(R.id.equaldark);
        inputd = (TextView)findViewById(R.id.inputdark);
        resultd = (TextView)findViewById(R.id.resultdark);
        signd = (TextView)findViewById(R.id.signdark);
    }

    private void computeDark(){
        if (inputd.getText().length() == 0 || inputd.getText().toString() == "" || inputd.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Enter Some value", Toast.LENGTH_SHORT);
            return;
        } else if (!Double.isNaN(val1d)){
            val2d = Double.parseDouble(inputd.getText().toString());

            switch (ACTIONd) {
                case ADDd:
                    val1d = val1d + val2d;
                    break;

                case SUBd:
                    val1d = val1d - val2d;
                    break;

                case MULTIPLYd:
                    val1d = val1d * val2d;
                    break;

                case DIVIDEd:
                    val1d = val1d / val2d;
                    break;

                case NEGd:
                    val1d = val2d * 1;
                    break;

                case EQUd:
                    break;
            }
        }
        else {
            val1d = Double.parseDouble(inputd.getText().toString());
        }

    }

}
