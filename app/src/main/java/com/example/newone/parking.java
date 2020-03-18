package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class parking extends AppCompatActivity {

    EditText mail;
    EditText Vechile_no;
    Spinner com;
    Spinner colour;
    EditText Hour;
    EditText Location;

    ImageButton Edit;
    ImageButton Payment;
    ImageButton Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_screen_simple);

        mail=findViewById(R.id.editText15);
        Vechile_no=findViewById(R.id.editText16);
        com=findViewById(R.id.spinner);
        colour=findViewById(R.id.spinner2);
        Hour=findViewById(R.id.editText18);
        Location=findViewById(R.id.editText20);

        Edit=findViewById(R.id.imageButton3);
        Payment=findViewById(R.id.imageButton5);
        Home=findViewById(R.id.imageButton6);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parking.this,HOME.class);
                startActivity(intent);
            }
        });

        Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parking.this,Payment.class);
                startActivity(intent);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parking.this,HOME.class);
                startActivity(intent);
            }
        });
    }
}
