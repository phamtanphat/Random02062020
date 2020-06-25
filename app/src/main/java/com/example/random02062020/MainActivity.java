package com.example.random02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin, mEdtSomax;
    Button mBtnRandom , mBtnBound , mBtnReset;
    TextView mTvKetqua;
    String mTextKetqua = "";
    ArrayList<Integer> mBound = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Tắt chức năng cho view (setEnabled)
//        Nếu hiển thị addBound enable thì resetBound và random về enabled = false và ngược lại
//        Task 1 : Xử lý nút addBound
//            + Xử lý validate cho input
//            + Add các số từ số min tới số max vào trong mảng(Arraylist)
//        Task 2 : Xử lý nút resetBound
//            + Xóa dữ liệu trong mảng
//            + Xóa dữ liệu trong input
//        Task 3 : Xử lý nút random
//            + Xử random cho mảng
//            + Hiển thị kết quả theo chuỗi như sau "1 - 2 - 3 - 4"
        mapView();
        initView();
        setListener();
    }

    private void initView() {
        // Disable button random , reset
        setDisableView(mBtnRandom);
        setDisableView(mBtnReset);
    }


    private void setListener() {
        mBtnBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textSoMax = mEdtSomax.getText().toString();
                String textSoMin = mEdtSomin.getText().toString();

                if (textSoMax.equals("") || textSoMin.equals("")) {
                    Toast.makeText(
                            MainActivity.this,
                            "Bạn chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                // Chuyen kieu du lieu thanh so
                int soMax = Integer.parseInt(textSoMax);
                int soMin = Integer.parseInt(textSoMin);
                // Kiem tra neu so min lon hon hoac bang so max
                // somax = somin
                // smin = somin - 1
                if (soMin >= soMax){
                    soMax = soMin;
                    soMin -= 1;
                    mEdtSomin.setText(String.valueOf(soMin));
                    mEdtSomax.setText(String.valueOf(soMax));
                }
                // TH khi max co gia tri 0 thi so min la -1
                if (soMax == 0){
                    soMin = 0;
                    soMax = 1;
                    mEdtSomin.setText(String.valueOf(soMin));
                    mEdtSomax.setText(String.valueOf(soMax));
                }
                // Add value min to max
                if (mBound.size() > 0) mBound.clear();
                for (int i = soMin ; i <= soMax ; i++) {
                    mBound.add(i);
                }
                // Ẩn keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.RESULT_UNCHANGED_SHOWN);

                // set disable view
                setDisableView(mBtnBound);
                setDisableView(mEdtSomax);
                setDisableView(mEdtSomin);

                // set enable
                setEnableView(mBtnReset);
                setEnableView(mBtnRandom);
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Enable view
                setEnableView(mBtnReset);
                setEnableView(mBtnRandom);
                setEnableView(mEdtSomax);
                setEnableView(mEdtSomin);
                setEnableView(mBtnBound);

                //reset data
                //view
                mEdtSomin.setText("");
                mEdtSomax.setText("");
                mTvKetqua.setText("");
                //data
                mBound.clear();
                mTextKetqua = "";

            }
        });
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound.size() > 0){
                    int index = new Random().nextInt(mBound.size());
//                    if (mBound.size() == 1){
//                        mTextKetqua += mBound.get(index) ;
//                    } else{
//                        mTextKetqua += mBound.get(index) + " - ";
//                    }
                    mTextKetqua += mBound.get(index) + " - ";
                    if (mBound.size() == 1){
                       mTextKetqua =  mTextKetqua.substring(0 , mTextKetqua.length() - 3);
                    }
                    mTvKetqua.setText(mTextKetqua);
                    mBound.remove(index);
                }else {
                    Toast.makeText(MainActivity.this, "Ket thuc !!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void mapView() {
        mBtnRandom = findViewById(R.id.buttonRandom);
        mEdtSomin = findViewById(R.id.edittextSomin);
        mEdtSomax = findViewById(R.id.edittextSomax);
        mTvKetqua = findViewById(R.id.textviewKetqua);
        mBtnBound = findViewById(R.id.buttonAddBound);
        mBtnReset = findViewById(R.id.buttonResetBound);
    }
    private void setEnableView(View v) {
        v.setEnabled(true);
    }
    private void setDisableView(View v) {
        v.setEnabled(false);
    }

}