package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class payment_recipt extends AppCompatActivity {
    EditText email,vno,carcom,carcolo,hour,amount,pay,lot,spot;
    ImageButton done;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_tooltip);

        email=findViewById(R.id.editText6);
        vno=findViewById(R.id.editText7);
        carcom=findViewById(R.id.editText8);
        carcolo=findViewById(R.id.editText9);
        hour=findViewById(R.id.editText10);
        amount=findViewById(R.id.editText11);
        pay=findViewById(R.id.editText12);
        lot=findViewById(R.id.editText13);
        spot=findViewById(R.id.editText14);
        done=findViewById(R.id.imageButton);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment_recipt.this, HOME.class);
                startActivity(intent);
            }
        });


    }
}
