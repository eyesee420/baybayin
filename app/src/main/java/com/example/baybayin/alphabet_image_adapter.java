package com.example.baybayin;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class alphabet_image_adapter extends RecyclerView.Adapter<alphabet_image_adapter.holder> {
    private final Context context;
        private final  ArrayList<Integer> integerArrayList;

    public alphabet_image_adapter(Context context, ArrayList<Integer> integerArrayList) {
        this.context = context;
        this.integerArrayList = integerArrayList;
    }

    @NonNull
    @Override
    public alphabet_image_adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alphabet_images,parent,false);

        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull alphabet_image_adapter.holder holder, int position) {

        Glide.with(context)
                .load(integerArrayList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}
