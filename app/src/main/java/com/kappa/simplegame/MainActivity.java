package com.kappa.simplegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNum1, btnNum2;
    private TextView txvResult;
    Random rnNum = new Random();
    int rndNum, Num1, Num2, Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        txvResult = findViewById(R.id.txvResult);

        randomNumber();
        btnNum1.setText(Integer.toString(rndNum));

        randomNumber();
        btnNum2.setText(Integer.toString(rndNum));

        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);

        Result = Integer.parseInt(txvResult.getText().toString());
        if (Result >= 10){
            //Intent win = new Intent();
            Toast.makeText(MainActivity.this, "YOU WON!!!", Toast.LENGTH_LONG).show();
        }
        else if (Result <= -10){
            //Intent win = new Intent();
            Toast.makeText(MainActivity.this, "YOU LOST!!!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNum1) {
            Num1 = Integer.parseInt(btnNum1.getText().toString());
            Num2 = Integer.parseInt(btnNum2.getText().toString());
            Result = Integer.parseInt(txvResult.getText().toString());
            if (Num1 > Num2) {
                Result = Result+1;
                txvResult.setText(Integer.toString(Result));
            } else if (Num2 > Num1) {
                Result = Result-1;
                txvResult.setText(Integer.toString(Result));
            }

        }
        else if (v.getId() == R.id.btnNum2) {
            Num1 = Integer.parseInt(btnNum1.getText().toString());
            Num2 = Integer.parseInt(btnNum2.getText().toString());
            Result = Integer.parseInt(txvResult.getText().toString());
            if (Num2 > Num1) {
                Result = Result+1;
                txvResult.setText(Integer.toString(Result));
            }
            else if (Num1 > Num2) {
                Result = Result-1;
                txvResult.setText(Integer.toString(Result));
            }
        }

        randomNumber();
        btnNum1.setText(Integer.toString(rndNum));

        randomNumber();
        btnNum2.setText(Integer.toString(rndNum));

        if (Result >= 10){
            Intent win = new Intent(MainActivity.this, WinActivity.class);
            startActivity(win);
            //Toast.makeText(MainActivity.this, "YOU WON!!!", Toast.LENGTH_LONG).show();
        }
        else if (Result <= -10){
            Intent lose = new Intent(MainActivity.this, LoseActivity.class);
            startActivity(lose);
            //Toast.makeText(MainActivity.this, "YOU LOST!!!", Toast.LENGTH_LONG).show();
        }
    }
    private int randomNumber(){
        rndNum = rnNum.nextInt(99)+1;
        return rndNum;
    }
}
