package com.example.floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;

    private boolean isFABOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fab = (FloatingActionButton) findViewById(R.id.fab);
        this.fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        this.fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        this.fab3 = (FloatingActionButton) findViewById(R.id.fab3);

        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                } else{
                    closeFABMenu();
                }
            }
        });
    }

    private void showFABMenu(){
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_1));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_2));
        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_3));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
    }
}