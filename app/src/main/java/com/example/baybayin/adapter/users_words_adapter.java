package com.example.baybayin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baybayin.R;
import com.example.baybayin.image_models.image_models;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class users_words_adapter extends FirestoreRecyclerAdapter<image_models, users_words_adapter.holder> {

    public users_words_adapter(@NonNull FirestoreRecyclerOptions<image_models> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull users_words_adapter.holder holder, int i, @NonNull image_models model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public users_words_adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image_users, parent, false);

        return new users_words_adapter.holder(view);
    }

    public class holder extends RecyclerView.ViewHolder {
        Context context;
        ImageView image_view;
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        public holder(@NonNull View itemView) {
            super(itemView);

            image_view = itemView.findViewById(R.id.image_view);
            context =itemView.getContext();

        }

        public void bind(image_models model) {

            Glide.with(context.getApplicationContext())
                    .load(model.getImageuri())
                    .into(image_view);


        }
    }
}
