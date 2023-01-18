package com.example.baybayin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class admin_login extends AppCompatActivity {

    EditText email_address , pass_word;
    ProgressBar progressBar;
    final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Button button = findViewById(R.id.login_btn);

        progressBar = findViewById(R.id.progress);
        email_address = findViewById(R.id.email_address);
        pass_word = findViewById(R.id.pass_word);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_address.getText().toString();
                String pass = pass_word.getText().toString();
                if(email.isEmpty()){
                    email_address.setError("Required");
                    email_address.requestFocus();
                    Toast.makeText(admin_login.this, "Please Provide email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.isEmpty()){
                    pass_word.setError("Required");
                    pass_word.requestFocus();
                    Toast.makeText(admin_login.this, "Please Provide password", Toast.LENGTH_SHORT).show();
                    return;
                }
                login_admin();
                progressBar.setVisibility(View.VISIBLE);

            }
        });
    }

    private void login_admin() {
        mAuth.signInWithEmailAndPassword(email_address.getText().toString(),pass_word.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        String email ="admin@gmail.com";
                        String pass = "123456";

                        if(email.equals(email_address.getText().toString().trim())
                                && pass.equals(pass_word.getText().toString().trim()) ){
                            startActivity(new Intent(admin_login.this , admin_home.class));
                            finish();
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(admin_login.this, "Welcome", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(admin_login.this, "please login correct admin account", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}