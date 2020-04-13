package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    Button Edit;
    Button VIEW;
    Button DELETE;
    Button ADD;
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

        Edit=findViewById(R.id.button3);
        VIEW=findViewById(R.id.button6);
        DELETE=findViewById(R.id.button4);
        ADD=findViewById(R.id.button16);
        Payment=findViewById(R.id.imageButton5);
        Home=findViewById(R.id.imageButton6);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parking.this,EditParking.class);
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
