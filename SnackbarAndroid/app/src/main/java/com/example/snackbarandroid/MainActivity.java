package com.example.snackbarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private View baseView;

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Container
        this.baseView = this.findViewById(R.id.constraintLayout);

        this.button1 = (Button) this.findViewById(R.id.button1);
        this.button2 = (Button) this.findViewById(R.id.button2);
        this.button3 = (Button) this.findViewById(R.id.button3);

        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarDefault();
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarActionCall();
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarCustom();
            }
        });
    }

    private void showSnackbarDefault()  {
        Snackbar snackbar = Snackbar
                .make(this.baseView, "Install successful!", Snackbar.LENGTH_LONG);
        // Show
        snackbar.show();
    }

    private void showSnackbarActionCall() {

        Snackbar snackbar = Snackbar
                .make(this.baseView, "Message is deleted", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Show another Snackbar.
                        Snackbar snackbar1 = Snackbar.make(baseView, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();
    }

    private void showSnackbarCustom() {
        Snackbar snackbar = Snackbar
                .make(this.baseView, "Try again!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        // Align center.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        // Show Sneckbar
        snackbar.show();
    }
}