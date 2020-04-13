package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_Profile extends AppCompatActivity {

    Button Save;
    EditText name;
    EditText Email;
    EditText Contact_no;
    EditText Vehicle_no;
    EditText password;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile1);

        Save=findViewById(R.id.eupdate);
        name=findViewById(R.id.ename);
        Email = findViewById(R.id.Eemail);
        Contact_no=findViewById(R.id.ephone);
        Vehicle_no=findViewById(R.id.evehicle);
        password=findViewById(R.id.epassword);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_Profile.this, profile.class);
                startActivity(intent);
            }
        });

    }
}
