package com.example.rotationandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Display display;
    TextView huongmanhinh, gocnghieng;
    OrientationEventListener myOrientationEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        huongmanhinh = findViewById(R.id.huongmanhinh);
        gocnghieng   = findViewById(R.id.gocnghieng);


        InfoScreen();
        ListenerRotate();
    }

    //Listener nhận sự kiện thay đổi góc nghiêng điện thoại
    void ListenerRotate() {
        myOrientationEventListener =
                new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {
                    @Override
                    public void onOrientationChanged(int i) {
                        gocnghieng.setText("Góc nghiêng: "+i+"°");
                        InfoScreen();
                    }
                };
        myOrientationEventListener.enable();
    }


    /**
     * Xác định màn hình PORTRAIT, LANDSCAPE
     */
    void InfoScreen() {

        Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();

        switch (display.getRotation()) {
            case Surface.ROTATION_0:
                huongmanhinh.setText("Màn hình LAYOUT đứng: 0°");
                break;

            case Surface.ROTATION_90:
                huongmanhinh.setText("Màn hình LAYOUT ngang: 90°");
                break;

            case Surface.ROTATION_180:
                huongmanhinh.setText("Màn hình LAYOUT ngang: 180°");
                break;

            case Surface.ROTATION_270:
                huongmanhinh.setText("Màn hình LAYOUT đứng: 270°");
                break;
        }
    }
}