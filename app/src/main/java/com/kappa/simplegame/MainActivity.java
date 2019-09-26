package com.kappa.simplegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNum1, btnNum2;
    private TextView txvResult;
    Random rnNum = new Random();
    int rndNum1, rndNum2, Num1, Num2, Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        txvResult = findViewById(R.id.txvResult);


        rndNum1 = rnNum.nextInt(100);

        btnNum1.setText(Integer.toString(rndNum1));

        rndNum2 = rnNum.nextInt(100);

        btnNum2.setText(Integer.toString(rndNum2));

        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNum1) {
            Num1 = Integer.parseInt(btnNum1.getText().toString());
            Num2 = Integer.parseInt(btnNum2.getText().toString());
            Result = Integer.parseInt(txvResult.getText().toString());
            if (Num1 > Num2) {
                Result = Result++;
                txvResult.setText(Integer.toString(Result));
            }
            else if (Num2 > Num1) {
                Result = Result--;
                txvResult.setText(Integer.toString(Result));
            }
        } else if (v.getId() == R.id.btnNum2) {
            Num1 = Integer.parseInt(btnNum1.getText().toString());
            Num2 = Integer.parseInt(btnNum2.getText().toString());
            Result = Integer.parseInt(txvResult.getText().toString());
            if (Num2 > Num1) {
                Result = Result++;
                txvResult.setText(Integer.toString(Result));
            } else if (Num1 > Num2) {
                Result = Result--;
                txvResult.setText(Integer.toString(Result));
            }
        }
    }
}
