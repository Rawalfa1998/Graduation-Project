package com.example.graduationproject;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class Sign_up extends AppCompatActivity {
    public EditText Username,Email,Password,rePassword;
    public Button Signup_Button;
    public ProgressBar progressBar2;
    public TextView textView;
    //cheack
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username = findViewById(R.id.Username);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        rePassword = findViewById(R.id.rePassword);
        Signup_Button = findViewById(R.id.Signup_Button);
        progressBar2 = findViewById(R.id.progressBar2);
        textView = findViewById(R.id.textView);
         fAuth = FirebaseAuth.getInstance();
if(fAuth.getCurrentUser()!=null ){
    startActivity(new Intent(getApplicationContext (),Login_Activity.class));
    finish();
}



        Signup_Button.setOnClickListener(v -> {
         String emai1 = Email.getText ().toString ().trim() ;
         String password = Password.getText () .toString() .trim();

          if(TextUtils.isEmpty(emai1)){ Email.setError ("Email is Required. ");
              return;
          }
             if (TextUtils.isEmpty(password)) { Password.setError ("Password is Required. ");
                 return;}
            if (password.length() < 6) {
                Password.setError("Password Must be >= 6 Characters");
                return;
            }

            progressBar2.setVisibility(View.VISIBLE);
            fAuth.createUserWithEmailAndPassword( emai1,password ).addOnCompleteListener(task -> {

                if(task.isSuccessful()){
                    Toast.makeText ( Sign_up.this, "User Created.",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent (getApplicationContext (),Homepage.class));

                }else {
                    Toast.makeText( Sign_up.this,"error"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar2.setVisibility(View.GONE);
                }
            });

            })

    ;}

 }










