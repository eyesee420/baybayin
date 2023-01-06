package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class baybayin_words_page extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<String> stringArrayList;
    words_image_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baybayin_words_page);

        recyclerview = findViewById(R.id.recyclerview);

        stringArrayList = new ArrayList<>();
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/8.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/1.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/2.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/4.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/5.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/6.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/3.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/7.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/10.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/11.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/14.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/12.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/13.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2021/03/TADHANA.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/21.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/17.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/18.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/20.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/16.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/22.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/23.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/19.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/29.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/25.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/26.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/27.png?resize=585%2C585&ssl=1");
        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/30.png?resize=585%2C585&ssl=1");




        adapter = new words_image_adapter(this, stringArrayList);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

    }
}