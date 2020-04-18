package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class profile extends AppCompatActivity {

    Button Edit;
    Button Delete;
    Button View;
    EditText name;
    EditText Email;
    EditText Contact_no;
    EditText Vehicle_no;
    EditText password;
    ImageButton logout2;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        Edit=findViewById(R.id.Edit);
        Delete=findViewById(R.id.delete);
        View=findViewById(R.id.viewpro);
        name=findViewById(R.id.editText29);
        Email=findViewById(R.id.editText30);
        Contact_no=findViewById(R.id.editText31);
        Vehicle_no=findViewById(R.id.editText32);
        password=findViewById(R.id.editText34);
        logout2=findViewById(R.id.logout2);



        logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, HOME.class);
                startActivity(intent);
            }
        });




    }
}
