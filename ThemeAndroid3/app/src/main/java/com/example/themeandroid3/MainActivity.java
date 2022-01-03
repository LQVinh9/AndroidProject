package com.example.themeandroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //ID của theme mà Activity sử dụng
    int themeIdcurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Đọc ID theme đã lưu, nếu chưa lưu thì dùng R.style.MyAppTheme
        SharedPreferences locationpref = getApplicationContext().getSharedPreferences("MainActivity", MODE_PRIVATE);
        themeIdcurrent = locationpref.getInt("themeid",R.style.MyAppTheme);

        //Thiết lập theme cho Activity
        setTheme(themeIdcurrent);

        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chuyển đổi theme
                themeIdcurrent = themeIdcurrent == R.style.MyAppTheme ? R.style.Theme_ThemeAndroid3 : R.style.MyAppTheme;

                //Lưu lại theme ID
                SharedPreferences locationpref = getApplicationContext().getSharedPreferences("MainActivity", MODE_PRIVATE);
                SharedPreferences.Editor spedit = locationpref.edit();
                spedit.putInt("themeid", themeIdcurrent);
                spedit.apply();

                //Tạo lại Activity để áp dụng theme mởi đổi
                recreate();

            }
        });
    }
}