package com.example.actionbarandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("TIÊU ĐỀ ACTIVITY"); //Thiết lập tiêu đề nếu muốn

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher);    //Icon muốn hiện thị
        actionBar.setDisplayUseLogoEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Tùy biến hiện thị biểu tượng bấm quay trở lại
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                //Bắt sự kiện khi bấm vào nút mũi tên quay lại
                Toast.makeText(MainActivity.this, "Click back!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu1:
                //code xử lý khi bấm menu1
                Toast.makeText(MainActivity.this, "menu 1!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                Toast.makeText(MainActivity.this, "menu 2!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                //code xử lý khi bấm menu3
                Toast.makeText(MainActivity.this, "menu 3!", Toast.LENGTH_SHORT).show();
                break;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
}