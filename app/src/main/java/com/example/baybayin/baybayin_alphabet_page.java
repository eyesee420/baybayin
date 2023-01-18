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
//        integerArrayList.add(R.drawable.ba);
//        integerArrayList.add(R.drawable.da);
        integerArrayList.add(R.drawable.be);
        integerArrayList.add(R.drawable.ga);
        integerArrayList.add(R.drawable.ha);
        integerArrayList.add(R.drawable.ka);
        integerArrayList.add(R.drawable.la);
        integerArrayList.add(R.drawable.ma);


        integerArrayList.add(R.drawable.bo);
        integerArrayList.add(R.drawable.e_i);
        integerArrayList.add(R.drawable.ga);
        integerArrayList.add(R.drawable.ge);
        integerArrayList.add(R.drawable.go);
        integerArrayList.add(R.drawable.ho);
        integerArrayList.add(R.drawable.ko);
        integerArrayList.add(R.drawable.la);

        integerArrayList.add(R.drawable.le);
        integerArrayList.add(R.drawable.ma);
        integerArrayList.add(R.drawable.me);
        integerArrayList.add(R.drawable.mo);
        integerArrayList.add(R.drawable.na);
        integerArrayList.add(R.drawable.ne);
        integerArrayList.add(R.drawable.nga);
        integerArrayList.add(R.drawable.nge);

        integerArrayList.add(R.drawable.ngo);
        integerArrayList.add(R.drawable.no);
        integerArrayList.add(R.drawable.o);
        integerArrayList.add(R.drawable.o_u);
        integerArrayList.add(R.drawable.oo);
        integerArrayList.add(R.drawable.pa);
        integerArrayList.add(R.drawable.sa);
        integerArrayList.add(R.drawable.se);

        integerArrayList.add(R.drawable.so);
        integerArrayList.add(R.drawable.ta);
        integerArrayList.add(R.drawable.te);
        integerArrayList.add(R.drawable.o_u);
        integerArrayList.add(R.drawable.to);
        integerArrayList.add(R.drawable.wa);
        integerArrayList.add(R.drawable.we);
        integerArrayList.add(R.drawable.wo);

        integerArrayList.add(R.drawable.ya);
        integerArrayList.add(R.drawable.ye);
        integerArrayList.add(R.drawable.yo);

        adapter = new alphabet_image_adapter(this, integerArrayList);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

    }
}