package com.example.baybayin.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baybayin.R;
import com.example.baybayin.image_models.users_model;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class users_adapter extends FirestoreRecyclerAdapter<users_model, users_adapter.holder> {

    public users_adapter(@NonNull FirestoreRecyclerOptions<users_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull users_adapter.holder holder, int i, @NonNull users_model model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public users_adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_users, parent, false);

        return new users_adapter.holder(view);
    }

    public class holder extends RecyclerView.ViewHolder {
        Context context;
        private static final String TAG = "holder";
        TextView full_name,email_address,nick_name,btn_delete;
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        public holder(@NonNull View itemView) {
            super(itemView);

            full_name = itemView.findViewById(R.id.full_name);
            email_address = itemView.findViewById(R.id.email_address);
            nick_name = itemView.findViewById(R.id.nick_name);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            context =itemView.getContext();
        }

        public void bind(users_model model) {

            full_name.setText(model.getFullname());
            email_address.setText(model.getEmail());
            nick_name.setText(model.getNickname());

            Log.d(TAG, "bind: "  +model.getFullname()+model.getPassword()+model.getEmail());
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.collection("users").document(model.getDoc_id()).delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(context, "user deleted", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            });
        }
    }
}
