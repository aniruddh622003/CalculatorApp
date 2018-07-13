package com.dhd.calculator;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    ShardPref shardPref;

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button clear;
    private Button delete;
    private Button exit;
    private Button equal;
    private Button dot;
    private Button neg;
    private TextView input;
    private TextView result;
    private TextView sign;
    private TextView eqtv;
    private final char ADD = '+';
    private final char SUB = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char EQU = 0;
    private final char NEG = '_';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    private DecimalFormat decimalFormat;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shardPref = new ShardPref(this);
        if (shardPref.getNightMode()==true){
            Intent intent = new Intent(MainActivity.this, activity_main_dark.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar mtoolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.tool);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().show();



        decimalFormat = new DecimalFormat("#.####");

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + ".");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADD;
                result.setText(decimalFormat.format(val1));
                sign.setText("+");

                input.setText(null);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUB;
                result.setText(decimalFormat.format(val1));
                sign.setText("-");

                input.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLY;
                result.setText(decimalFormat.format(val1));
                sign.setText("×");
                input.setText(null);

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVIDE;
                result.setText(decimalFormat.format(val1));
                sign.setText("÷");
                input.setText(null);

            }
        });
        neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = NEG;
                input.setText("-" + decimalFormat.format(val1));
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    compute();
                    ACTION = EQU;
                    if (decimalFormat.format(val1).length() > 10) {
                        Toast.makeText(getApplicationContext(), "Value too Big", Toast.LENGTH_LONG).show();
                    } else {

                        result.setText(decimalFormat.format(val1));
                        sign.setText("=");
                        input.setText(null);
                    }
                }



        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() > 0) {
                    CharSequence name = input.getText().toString();
                    input.setText(name.subSequence(0, name.length() - 1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    input.setText(null);
                    result.setText(null);
                    sign.setText(null);

                }


            }
        });
        clear.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                val1 = Double.NaN;
                val2 = Double.NaN;
                input.setText(null);
                result.setText(null);
                sign.setText(null);

                return true;
            }

        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                input.setText(null);
                result.setText(null);
                sign.setText(null);

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Long Press to Exit",Toast.LENGTH_SHORT).show();
            }
        });

        exit.setOnLongClickListener(new View.OnLongClickListener(){
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
        menuInflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.Dark){
            Intent intent = new Intent(MainActivity.this, activity_main_dark.class);
            shardPref.setNightMode(true);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupUIViews(){

        zero = (Button)findViewById(R.id.Button0);
        one = (Button)findViewById(R.id.Button1);
        two = (Button)findViewById(R.id.Button2);
        three = (Button)findViewById(R.id.Button3);
        four = (Button)findViewById(R.id.Button4);
        five = (Button)findViewById(R.id.Button5);
        six = (Button)findViewById(R.id.Button6);
        seven = (Button)findViewById(R.id.Button7);
        eight = (Button)findViewById(R.id.Button8);
        nine = (Button)findViewById(R.id.Button9);
        dot = (Button)findViewById(R.id.dot);
        neg = (Button)findViewById(R.id.neg);
        add = (Button)findViewById(R.id.plus);
        subtract = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.Divide);
        clear = (Button)findViewById(R.id.clear);
        delete = (Button)findViewById(R.id.Del);
        exit = (Button)findViewById(R.id.exit);
        equal = (Button)findViewById(R.id.equal);
        input = (TextView)findViewById(R.id.input);
        result = (TextView)findViewById(R.id.result);
        sign = (TextView)findViewById(R.id.sign);

        }

    private void compute() {
        if (input.getText().length() == 0 || input.getText().toString() == "" || input.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Enter Some value", Toast.LENGTH_SHORT);
            return;
        } else if (!Double.isNaN(val1)){
            val2 = Double.parseDouble(input.getText().toString());

            switch (ACTION) {
                case ADD:
                    val1 = val1 + val2;
                    break;

                case SUB:
                    val1 = val1 - val2;
                    break;

                case MULTIPLY:
                    val1 = val1 * val2;
                    break;

                case DIVIDE:
                    val1 = val1 / val2;
                    break;

                case NEG:
                    val1 = val2 * 1;
                    break;

                case EQU:
                    break;
            }
        }
        else {
            val1 = Double.parseDouble(input.getText().toString());
        }


    }
}
