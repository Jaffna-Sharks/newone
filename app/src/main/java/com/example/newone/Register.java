package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText rusername;
    EditText rpassword;
    EditText rconfrom_password;
    Button Register;
    Button Login;


    LoginDatabaseHelper loginDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        loginDatabaseHelper = new LoginDatabaseHelper(this);
        rusername = findViewById(R.id.editText);
        rpassword = findViewById(R.id.editText3);
        rconfrom_password = findViewById(R.id.editText4);
        Register = findViewById(R.id.register2);
        Login = findViewById(R.id.login2);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.newone.Register.this, login.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String PASSWORD_REGEX =
                        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,16}$";

                String username = rusername.getText().toString();
                String password = rpassword.getText().toString();
                boolean isValid=true;
                if(password.isEmpty()){
                    rpassword.setError("Enter the password");
                    rpassword.requestFocus();
                    isValid=false;
                }else if(!password.matches(PASSWORD_REGEX)) {
                    rpassword.setError("Invalid  Password");
                    rpassword.requestFocus();
                    isValid=false;

                }

                String confirm_password = rconfrom_password.getText().toString();

                if(isValid) {
                    if (username.equals("") || password.equals("") || confirm_password.equals("")) {
                        Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                    } else {
                        if (password.equals(confirm_password)) {
                            Boolean checkusername = loginDatabaseHelper.CheckUsername(username);
                            if (checkusername == true) {
                                Boolean insert = loginDatabaseHelper.Insert(username, password);
                                if (insert == true) {
                                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                    rusername.setText("");
                                    rpassword.setText("");
                                    rconfrom_password.setText("");
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
   }
}
