package com.example.newone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;



public class location extends AppCompatActivity {

    //  GoogleMap map;
    LocationDatabaseHelper myDb3;
    Button ADD ;
    Button VIEW ;
    Button UPDATE ;
    Button DELETE ;
    Button SEARCH ;
    EditText city;
    EditText STREET;
    EditText DISTRICT;
    EditText PROVINCE;
    EditText Sea2;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location1);
        myDb3 = new LocationDatabaseHelper(this);

        ADD=findViewById(R.id.button11);
        VIEW=findViewById(R.id.button12);
        UPDATE=findViewById(R.id.button13);
        DELETE=findViewById(R.id.button14);
        Sea2=findViewById(R.id.editText21);
        SEARCH =findViewById(R.id.button15);
        city=findViewById(R.id.city);
        STREET=findViewById(R.id.street);
        DISTRICT=findViewById(R.id.dis);
        PROVINCE=findViewById(R.id.province);
        addData();
        viewAll();
        updateData();
        deleteData();
        search();

    }


    public void deleteData () {
        DELETE.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Integer deleterows = myDb3.DeleteData(city.getText().toString());
                        if (deleterows > 0)
                            Toast.makeText(location.this, "Details Are Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(location.this, "Details Are Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }


    public void updateData() {

        UPDATE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb3.updateData(city.getText().toString(),
                                STREET.getText().toString(),
                                DISTRICT.getText().toString(),
                                PROVINCE.getText().toString());
                        if (isUpdate == true)

                            Toast.makeText(location.this, "Details Are Updated", Toast.LENGTH_LONG).show();

                        else
                            Toast.makeText(location.this, "Details Are Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
   }