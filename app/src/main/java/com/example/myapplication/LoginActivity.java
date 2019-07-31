package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextView register;
    private EditText user_name;
    private EditText password;
    private Button lgbt;
    private FirebaseAuth mAuth;
    private ProgressDialog prodia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register=(TextView)findViewById(R.id.newuser);
        user_name=(EditText) findViewById(R.id.usernameedit);
        password=(EditText)findViewById(R.id.passwordedit);
        lgbt=(Button)findViewById(R.id.loginbt);
        mAuth=FirebaseAuth.getInstance();
        prodia=new ProgressDialog(this);
        FirebaseUser user=mAuth.getCurrentUser();
        lgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(user_name.getText().toString(),password.getText().toString());
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,regAtivity.class));
            }
        });
    }
    private void validate(String username,String password)
    {
        prodia.setMessage("please wait for login:)");
        prodia.show();
        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    prodia.dismiss();
                    Toast.makeText(LoginActivity.this,"Login success",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
