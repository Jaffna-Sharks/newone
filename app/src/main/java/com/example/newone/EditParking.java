package com.example.newone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class EditParking extends AppCompatActivity {

    EditText mail1;
    EditText Vechile_no1;
    Spinner com1;
    Spinner colour1;
    EditText Hour1;
    EditText Location1;

    ImageButton save2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mail1=findViewById(R.id.email2);
        Vechile_no1=findViewById(R.id.v2);
        com1=findViewById(R.id.c2);
        colour1=findViewById(R.id.cl2);
        Hour1=findViewById(R.id.ho2);
        Location1=findViewById(R.id.l2);
        save2=findViewById(R.id.imageButton4);


        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditParking.this,parking.class);
                startActivity(intent);
            }
        });


    }
}
