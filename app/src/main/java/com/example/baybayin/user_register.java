package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.baybayin.image_models.users_model;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class user_register extends AppCompatActivity {

    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    EditText nick_name , full_name , email_address , pass_word;
    Button register_btn,back_btn;
    ProgressBar progressBar;
    users_model usersModel = new users_model();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);



        nick_name = findViewById(R.id.nick_name);
        full_name = findViewById(R.id.full_name);
        email_address = findViewById(R.id.email_address);
        pass_word = findViewById(R.id.pass_word);
        progressBar = findViewById(R.id.progress);

        register_btn = findViewById(R.id.register_btn);
        back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(user_register.this , MainActivity.class));
            }
        });
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register_User();
                progressBar.setVisibility(View.VISIBLE);
            }
        });

    }

    private void register_User() {
//        String nickname = nick_name.getText().toString().trim();
//        String fullname = full_name.getText().toString().trim();
//        String email = email_address.getText().toString().trim();
//        String password = pass_word.getText().toString().trim();

        String doc_ids = db.collection("users").document().getId();

        usersModel.setDoc_id(doc_ids);
        usersModel.setNickname(nick_name.getText().toString());
        usersModel.setFullname(full_name.getText().toString());
        usersModel.setEmail(email_address.getText().toString());
        usersModel.setPassword(pass_word.getText().toString());


        mAuth.createUserWithEmailAndPassword(email_address.getText().toString()
                        ,pass_word.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {


                 usersModel = new users_model(usersModel.getDoc_id(),usersModel.getNickname()
                       ,usersModel.getFullname(),usersModel.getEmail(),usersModel.getPassword() );

                    db.collection("users").document(doc_ids)
                                    .set(usersModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(user_register.this, "account Created", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                    startActivity(new Intent(user_register.this , MainActivity.class));
                                    finish();
                               }
                            });

                    }
                });

    }


}