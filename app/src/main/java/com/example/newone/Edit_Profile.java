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


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile1);

        Save=findViewById(R.id.Save);
        name=findViewById(R.id.userProfileEditEtNameData);
        Email = findViewById(R.id.userProfileEditEtEmailData);
        Contact_no=findViewById(R.id.userProfileEditEtContactNumberData);
        Vehicle_no=findViewById(R.id.userProfileEditEtCarNumberData);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_Profile.this, profile.class);
                startActivity(intent);
            }
        });

    }
}
