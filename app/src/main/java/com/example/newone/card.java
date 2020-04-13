package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class card extends AppCompatActivity {

    EditText cardno;
    EditText cexpdate;
    EditText cvc;
    EditText name;
    EditText amount;
    Button edit;
    Button View;
    Button delete;
    Button add;
    Button card;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        cardno=findViewById(R.id.cardno);
        cexpdate=findViewById(R.id.exp);
        cvc=findViewById(R.id.cvc);
        name=findViewById(R.id.name);
        amount=findViewById(R.id.amoun);
        edit=findViewById(R.id.button9);
        View=findViewById(R.id.button8);
        delete=findViewById(R.id.button7);
        add=findViewById(R.id.button17);
        card=findViewById(R.id.button10);


        card.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(card.this, payment_recipt.class);
                startActivity(intent);
            }
        });


    }
}
