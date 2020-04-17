package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText lusername;
    EditText lpassword;
    Button Login;
    Button Register;


    LoginDatabaseHelper loginDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        loginDatabaseHelper = new LoginDatabaseHelper(this);
        lusername = findViewById(R.id.uname);
        lpassword = findViewById(R.id.pwd);
        Login = findViewById(R.id.login);
        Register = findViewById(R.id.register);



        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, com.example.newone.Register.class);

                startActivity(intent);

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = lusername.getText().toString();
                String password = lpassword.getText().toString();

                Boolean checklogin = loginDatabaseHelper.CheckLogin(username, password);
                if(checklogin == true){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(login.this, HOME.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
