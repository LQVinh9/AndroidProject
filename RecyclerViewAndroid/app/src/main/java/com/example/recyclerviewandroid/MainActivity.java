package com.example.recyclerviewandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sử dụng RecyclerView
        recyclerView = findViewById(R.id.myrecyclerview);
        RecyclerView.Adapter adapter = new  ElementsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }

    /**
     * Lớp biểu diễn Holder trong RecycleView
     */
    class ElementViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public ElementViewHolder(TextView itemView) {
            super(itemView);
            textView = itemView;
        }

        public TextView getTextView() {
            return textView;
        }
    }



    /**
     * Adapter cho danh sách phần tử Text dùng trong RecycleView
     */
    class ElementsAdapter extends RecyclerView.Adapter {

        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        String[] arWords = new String[] {
                "Phần Tử 1", "Phần Tử 2", "Phần Tử 3", "Phần Tử 4",
                "Phần Tử 5", "Phần Tử 6", "Phần Tử 7",
                "Phần Tử 8", "Phần Tử 9", "Phần Tử 10",
                "Phần Tử 11", "Phần Tử 12", "Phần Tử 13", "Phần Tử 14",
                "Phần Tử 15", "Phần Tử 16", "Phần Tử 17",
                "Phần Tử 18", "Phần Tử 19", "Phần Tử 20", "Phần Tử 21",
                "Phần Tử 22", "Phần Tử 23", "Phần Tử 24", "Phần Tử 25"};

        @Override
        public RecyclerView.ViewHolder
        onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView v = (TextView)inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ElementViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            TextView v = ((ElementViewHolder)holder).getTextView();
            v.setText(arWords[position]);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"Click "+v.getText()+", position: "+String.valueOf(position),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return arWords.length;
        }
    }
}