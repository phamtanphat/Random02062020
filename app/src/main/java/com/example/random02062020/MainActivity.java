package com.example.random02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin,mEdtSomax;
    Button mBtnRandom;
    TextView mTvKetqua;
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
//        double b = 5.01;
//        double newB = Math.ceil(b);
//        Log.d("BBB","Ket qua cua b " + newB);
        // 3 : Ham lam tron xuong
//        double c = 5.99;
//        double newC = Math.floor(c);
//        Log.d("BBB","Ket qua cua c " + newC);
        // 4 : Ham so sanh
//        int a = 5;
//        int b = 6;
//        int solonnhat =  Math.max(a , b);
//        Log.d("BBB","So lon nhat " + solonnhat);
        // 5 : Ham Random
        // 0 -> 5

//        double valueRandom = Math.floor(Math.random() * 6);
//        Log.d("BBB","Gia tri random " + valueRandom);

        // 5 -> 15
//        Random random = new Random();
//        int value = random.nextInt(15 - 5 + 1) + 5;
//        Log.d("BBB",value + "");

        // Task 1 : Validation 2 edittext
//            + Người dùng phải nhập số min và số max
//            + Số max không được bé hơn số min (Nếu bé hơn thì so max = somin + 1 )
        mapView();
        setListener();
    }

    private void setListener() {
    }

    private void mapView() {
        mBtnRandom = findViewById(R.id.buttonRandom);
        mEdtSomin = findViewById(R.id.edittextSomin);
        mEdtSomax = findViewById(R.id.edittextSomax);
        mTvKetqua = findViewById(R.id.textviewKetqua);
    }

}