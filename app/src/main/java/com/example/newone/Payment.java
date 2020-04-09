package com.example.newone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {


    EditText email;
    EditText vechileno;
    EditText hour;
    EditText amount;

    EditText payment;
    Spinner model;
    Spinner colour;
    Spinner lot;
    Spinner slot;

    Button save;
    Button save1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment21);
        email=findViewById(R.id.editText17);
        vechileno=findViewById(R.id.editText19);
        hour=findViewById(R.id.editText22);
        amount=findViewById(R.id.editText23);
        payment=findViewById(R.id.editText24);
        model=findViewById(R.id.spinner3);
        colour=findViewById(R.id.spinner4);
        lot=findViewById(R.id.spinner5);
        slot=findViewById(R.id.spinner6);
        save=findViewById(R.id.button2);
        save1=findViewById(R.id.button5);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this,payment_recipt.class);
                startActivity(intent);
            }
        });
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this,card.class);
                startActivity(intent);
            }
        });




    }
}
