package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.baybayin.adapter.users_adapter;
import com.example.baybayin.adapter.users_words_adapter;
import com.example.baybayin.image_models.image_models;
import com.example.baybayin.image_models.users_model;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class admin_users_profiles extends AppCompatActivity {

    RecyclerView recyclerview;
    private users_adapter adapter;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_users_profiles);

        recyclerview = findViewById(R.id.recyclerview);


        recyc();

    }

    private void recyc() {

        Query query = db.collection("users");

        FirestoreRecyclerOptions<users_model> options = new FirestoreRecyclerOptions.Builder<users_model>()
                .setQuery(query, users_model.class).build();


        adapter = new users_adapter(options);
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