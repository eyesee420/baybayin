package com.example.baybayin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email_address , pass_word;
    ProgressBar progressBar;
    final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
           email_address = findViewById(R.id.email_address);
           pass_word = findViewById(R.id.pass_word);

        Button button = findViewById(R.id.login_btn);
        Button reg_btn = findViewById(R.id.register_btn);
        Button admin_btn = findViewById(R.id.admin_btn);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_address.getText().toString();
                String pass = pass_word.getText().toString();
                if(email.isEmpty()){
                    email_address.setError("Required");
                    email_address.requestFocus();
                    Toast.makeText(MainActivity.this, "Please Provide email", Toast.LENGTH_SHORT).show();
                return;
                }
                if(pass.isEmpty()){
                    pass_word.setError("Required");
                    pass_word.requestFocus();
                    Toast.makeText(MainActivity.this, "Please Provide password", Toast.LENGTH_SHORT).show();
                    return;
                }
                login();
                progressBar.setVisibility(View.VISIBLE);

            }
        });
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, user_register.class));
            }
        });
        admin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, admin_login.class));
            }
        });
    }


    private void login() {
        mAuth.signInWithEmailAndPassword(email_address.getText().toString(),pass_word.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(MainActivity.this, user_home.class));
                        Toast.makeText(MainActivity.this, "Welcome"
                                , Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        finish();
                    }
                });


    }
}