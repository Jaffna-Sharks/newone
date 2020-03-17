package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class HOME extends AppCompatActivity {

    ImageButton notification;
    ImageButton map;
    ImageButton profile;
    ImageButton  parking;
    ImageButton payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        notification=findViewById(R.id.notification2);
        map=findViewById(R.id.location);
        profile=findViewById(R.id.profile);
        parking=findViewById(R.id.parent);
        payment=findViewById(R.id.pay);
    }
}