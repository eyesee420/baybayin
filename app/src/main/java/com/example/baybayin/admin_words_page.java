package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.baybayin.adapter.admin_words_adapter;
import com.example.baybayin.image_models.image_models;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class admin_words_page extends AppCompatActivity {

    RecyclerView recyclerview;
    FloatingActionButton add_btn;
    private admin_words_adapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_words_page);

        add_btn = findViewById(R.id.add_btn);
        recyclerview = findViewById(R.id.recyclerview);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admin_words_page.this , admin_add_words.class));
            }
        });
        
        recycleview();
    }

    private void recycleview() {
        FirebaseUser userid = mAuth.getCurrentUser();
//        Query query = db.collection("image").document(userid.getUid())
//                .collection("my sched");
        Query query = db.collection("images");

        FirestoreRecyclerOptions<image_models> options = new FirestoreRecyclerOptions.Builder<image_models>()
                .setQuery(query, image_models.class).build();



        adapter = new admin_words_adapter(options);
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