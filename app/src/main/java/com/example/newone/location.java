package com.example.newone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;



public class location extends AppCompatActivity {

  //  GoogleMap map;

   Button EDIT ;
    Button VIEW ;
    Button UPDATE ;
    Button DELETE ;
    Button SEARCH ;
    EditText city;
    EditText STREET;
    EditText DISTRICT;
    EditText PROVINCE;





    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location1);

        EDIT=findViewById(R.id.button11);
        VIEW=findViewById(R.id.button12);
        UPDATE=findViewById(R.id.button13);
        DELETE=findViewById(R.id.button14);

        SEARCH =findViewById(R.id.button15);
        city=findViewById(R.id.textView25);
        STREET=findViewById(R.id.textView26);
        DISTRICT=findViewById(R.id.textView27);
        PROVINCE=findViewById(R.id.textView28);

    }
}
