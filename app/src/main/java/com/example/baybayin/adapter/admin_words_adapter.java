package com.example.baybayin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

public class admin_words_adapter extends FirestoreRecyclerAdapter<image_models, admin_words_adapter.holder> {

    public admin_words_adapter(@NonNull FirestoreRecyclerOptions<image_models> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull admin_words_adapter.holder holder, int i, @NonNull image_models model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public admin_words_adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);

        return new admin_words_adapter.holder(view);
    }

    public class holder extends RecyclerView.ViewHolder {
        Context context;
        ImageView image_view;
        Button btn_delete;
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        public holder(@NonNull View itemView) {
            super(itemView);


            context =itemView.getContext();
            image_view = itemView.findViewById(R.id.image_view);
            btn_delete = itemView.findViewById(R.id.btn_delete);


        }

        public void bind(image_models model) {

            Glide.with(context.getApplicationContext())
                    .load(model.getImageuri())
                    .into(image_view);

            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.collection("images").document(model.getDocId())
                            .delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context, "image deleted", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            });

        }
    }
}
