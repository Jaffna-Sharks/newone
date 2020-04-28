package com.example.newone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HOME extends AppCompatActivity {


    ImageButton map;
    ImageButton profile;
    ImageButton  parking;
    ImageButton payment;
    ImageButton logout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supewr.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);



        map=findViewById(R.id.location);
        profile=findViewById(R.id.profile);
        parking=findViewById(R.id.parent);
        payment=findViewById(R.id.pay);
        logout1=findViewById(R.id.logout);




        logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HOME.this, login.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HOME.this, profile.class);
                startActivity(intent);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HOME.this, Payment.class);
                startActivity(intent);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HOME.this, location.class);
                startActivity(intent);
            }
        });


        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HOME.this,parking.class);
                startActivity(intent);
            }
        });


    }
}
