package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    EditText email;
    EditText vno;

    Spinner carCompany, carColor, paymentMode, spotNumber, lotNumber;
    TextView parkingEtNoHours;
    Button submit;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);

       email=findViewById(R.id.email21);
       vno=findViewById(R.id.vno2);

        submit=findViewById(R.id.ok);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, login.class);
                startActivity(intent);
            }
        });


    }
}
