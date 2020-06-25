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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin, mEdtSomax;
    Button mBtnRandom , mBtnBound , mBtnReset;
    TextView mTvKetqua;
    String mTextKetqua = "";
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
        mBtnRandom.setOnClickListener(new View.OnClickListener() {
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
                // Xử lý random
                // Ẩn keyboard
//                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
//                        InputMethodManager.RESULT_UNCHANGED_SHOWN);
                // Hiển thị theo dạng : 1 - 2 - 3 -

                Random random = new Random();
                int value = random.nextInt(soMax - soMin + 1) + soMin;
                mTextKetqua += value + " - ";
                mTvKetqua.setText(mTextKetqua);
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