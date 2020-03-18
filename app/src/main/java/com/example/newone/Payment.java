package com.example.newone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    EditText email;
    EditText vno;
    EditText Hour;
    EditText Amount;


    Spinner carCompany;
    Spinner carColor;
    Spinner paymentMode;
    Spinner spotNumber;
    Spinner lotNumber;

    Button submit;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);

       email=findViewById(R.id.aa);
       vno=findViewById(R.id.vno);
       carCompany=findViewById(R.id.car1);
       carColor=findViewById(R.id.car2);
       Hour=findViewById(R.id.hors);
       Amount=findViewById(R.id.amount);
       paymentMode=findViewById(R.id.car3);
       spotNumber=findViewById(R.id.car5);
       lotNumber=findViewById(R.id.car4);
        submit=findViewById(R.id.sub);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, payment_recipt.class);
                startActivity(intent);
            }
        });


    }
}
