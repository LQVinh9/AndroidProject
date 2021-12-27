package com.example.connectdbandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String ip = "192.168.0.109";
    private static String port = "1433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "xtlab";
    private static String username = "sa";
    private static String password = "123";
    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + database;

    private Connection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);

        //-- Connect DB SQL Server --
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);
            Log.i("mess", "SUCCESS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.i("mess", "ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.i("mess", "FAILURE");
        }
        //-----------------------------


        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from Products;");
                while (resultSet.next()) {
                    textView.setText(resultSet.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            textView.setText("Connection is null");
        }
    }
}