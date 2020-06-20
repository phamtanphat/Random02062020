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
        int a = 5;
        int b = 6;
        int ketqua = tinhtong(a,b);
        Log.d("BBB",ketqua + "");
    }
    private int tinhtong(int value1 , int value2){
        return value1 + value2;
    }
}