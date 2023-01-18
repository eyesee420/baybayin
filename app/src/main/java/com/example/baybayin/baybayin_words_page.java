package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.baybayin.adapter.admin_words_adapter;
import com.example.baybayin.adapter.users_words_adapter;
import com.example.baybayin.image_models.image_models;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class baybayin_words_page extends AppCompatActivity {

    RecyclerView recyclerview;
//    ArrayList<String> stringArrayList;
//    words_image_adapter adapter;

    private users_words_adapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baybayin_words_page);

        recyclerview = findViewById(R.id.recyclerview);

//        stringArrayList = new ArrayList<>();
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/8.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/1.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/2.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/4.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/5.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/6.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/3.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/7.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/10.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/11.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/14.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/12.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/13.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2021/03/TADHANA.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/21.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/17.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/18.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/20.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/16.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/22.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/23.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/19.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/29.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/25.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/26.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/27.png?resize=585%2C585&ssl=1");
//        stringArrayList.add("https://i0.wp.com/theficklefeet.com/wp-content/uploads/2020/11/30.png?resize=585%2C585&ssl=1");
//
//
//
//
//        adapter = new words_image_adapter(this, stringArrayList);
//        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        recyclerview.setAdapter(adapter);
        recycleview();

    }

    private void recycleview() {
     //   FirebaseUser userid = mAuth.getCurrentUser();
//        Query query = db.collection("image").document(userid.getUid())
//                .collection("my sched");
        Query query = db.collection("images");

        FirestoreRecyclerOptions<image_models> options = new FirestoreRecyclerOptions.Builder<image_models>()
                .setQuery(query, image_models.class).build();


        adapter = new users_words_adapter(options);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}