package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class baybayin_alphabet_page extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<Integer> integerArrayList;
    alphabet_image_adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baybayin_alphabet_page);

        recyclerview = findViewById(R.id.recyclerview);

        integerArrayList = new ArrayList<>();
        integerArrayList.add(R.drawable.ba);
        integerArrayList.add(R.drawable.da);
        integerArrayList.add(R.drawable.ei);
        integerArrayList.add(R.drawable.ga);
        integerArrayList.add(R.drawable.ha);
        integerArrayList.add(R.drawable.ka);
        integerArrayList.add(R.drawable.la);
        integerArrayList.add(R.drawable.ma);

        adapter = new alphabet_image_adapter(this, integerArrayList);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

    }
}