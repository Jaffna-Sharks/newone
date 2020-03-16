package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confrom_password;
    Button Register;
    Button Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        confrom_password = findViewById(R.id.editText3);
        Register = findViewById(R.id.register2);
        Login = findViewById(R.id.login2);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              // Intent intent = new Intent(Main2Activity.this, MainActivity.class);

               // startActivity(intent);
                Register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username1 = username.getText().toString();
                        String password1 = password.getText().toString();
                        String confrom_password1 = confrom_password.getText().toString();

                        if(username.equals("") || password.equals("") || confrom_password.equals("")){
                            Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                        }else{
                            if(password.equals(confrom_password)){
                                Boolean checkusername = databaseHelper.CheckUsername(username);
                                if(checkusername == true){
                                    Boolean insert = databaseHelper.Insert(username, password);
                                    if(insert == true){
                                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                        username.setText("");
                                        password.setText("");
                                        confrom_password.setText("");
                                    }
                                }else{
                                    Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

            }
        });
    }
}
