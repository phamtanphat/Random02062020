package com.example.random02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // public , private , protected , default
        // Builtin function

        // 1 : Ham lam tron
//        double a = 5.49;
//        long newA = Math.round(a);
//        Log.d("BBB","Ket qua cua a : " + newA );
        // 2 : Ham lam tron len
        double b = 5.01;
        double newB = Math.ceil(b);
        Log.d("BBB","Ket qua cua b " + newB);
    }

}