package com.example.assigment_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signInActivity extends AppCompatActivity {
    private EditText SignInMail, SignInPass;
    private FirebaseAuth auth;
    private Button SignInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_sign_in);
        SignInMail = (EditText) findViewById(R.id.SignInMail);
        SignInPass = (EditText) findViewById(R.id.SignInPass);
        SignInButton = (Button) findViewById(R.id.SignInButton);

        auth = FirebaseAuth.getInstance();
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = SignInMail.getText().toString();
                final String password = SignInPass.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter the Email Address",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter password to Continue",Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            if(password.length()<8){
                                Toast.makeText(getApplicationContext(),"Password must be greater than 8",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });
    }
    public void NavigateSignUp(View v){
        Intent intent = new Intent(getApplicationContext(),signUpActivity.class);
        startActivity(intent);
    }
    public void NavigateForgetMyPassword(View v){
        Intent intnt = new Intent(getApplicationContext(),forgetPassword.class);
        startActivity(intnt);
    }
}