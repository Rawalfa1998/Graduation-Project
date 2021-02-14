package com.example.graduationproject;

//import androidx.annotation.NonNull;
//import androidx.annotation.NonNull;
//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
//import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;

import java.util.Objects;

public class Login_Activity extends AppCompatActivity {
    public Button log_button, guest_button;
    public TextView forgot, textView3, signup;
    public EditText username, password;
    public ProgressBar progressBar;
    FirebaseAuth fAuth;
    //private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = findViewById(R.id.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        textView3 = findViewById(R.id.textView3);
        guest_button = findViewById(R.id.Guest);
        log_button = findViewById(R.id.login);
        forgot = findViewById(R.id.forgot);
        fAuth = FirebaseAuth.getInstance();
      //  mAuth = FirebaseAuth.getInstance();

        log_button.setOnClickListener(v -> {

            String emai1 = username.getText().toString().trim();
            String Password = password.getText().toString().trim();

            if (TextUtils.isEmpty(emai1)) {
                username.setError("Email is Required. ");
                return;
            }
            if (TextUtils.isEmpty(Password)) {
                password.setError("Password is Required. ");
                return;
            }
            if (Password.length() < 6) {
                password.setError("Password Must be >= 6 Characters");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            fAuth.signInWithEmailAndPassword(emai1, Password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(Login_Activity.this, "Logged in Successfully.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Homepage.class));
                } else {
                    Toast.makeText(Login_Activity.this, "Sorry: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            });

        });


signup.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Sign_up.class)));
        forgot.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Forgot_Password.class)));
    }

        }

