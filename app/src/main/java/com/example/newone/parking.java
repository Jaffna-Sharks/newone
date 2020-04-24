package com.example.newone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class parking extends AppCompatActivity {
   

    Button Edit;
    Button VIEW;
    Button DELETE;
    Button ADD;
    Button SESARCH;
    ImageButton Payment;
    ImageButton Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_screen_simple);

        myDb1 = new parkingDatabaseHelper(this);

        mail=findViewById(R.id.editText15);
        Vechile_no=findViewById(R.id.editText16);
        company=findViewById(R.id.editText33);
        carcolour=findViewById(R.id.editText35);
        Hour=findViewById(R.id.editText18);
        slot=findViewById(R.id.editText20);
        search22=findViewById(R.id.editText5);
        SESARCH=findViewById(R.id.button19);
        Edit=findViewById(R.id.button3);
        VIEW=findViewById(R.id.button6);
        DELETE=findViewById(R.id.button4);
        ADD=findViewById(R.id.button16);
        Payment=findViewById(R.id.imageButton5);
        Home=findViewById(R.id.imageButton6);

        addData();
        viewAll();
        updateData();
        deleteData();
        search();

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
    public void deleteData () {
        DELETE.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Integer deleterows = myDb1.DeleteData(Vechile_no.getText().toString());
                        if (deleterows > 0)
                            Toast.makeText(parking.this, "Details Are Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(parking.this, "Details Are Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }


    public void updateData() {

        Edit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb1.updateData(Vechile_no.getText().toString(),
                                mail.getText().toString(),
                                company.getText().toString(),
                                carcolour.getText().toString(),
                                Hour.getText().toString(),
                                slot.getText().toString());

                        if (isUpdate == true)

                            Toast.makeText(parking.this, "Details Are Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(parking.this, "Details Are Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void addData() {

        ADD.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String vechhileno = Vechile_no.getText().toString().trim();
                        String Email = mail.getText().toString().trim();
                        String Company = company.getText().toString().trim();
                        String colour = carcolour.getText().toString().trim();
                        String hour = Hour.getText().toString().trim();
                        String Slot = slot.getText().toString().trim();


                        if(vechhileno.isEmpty()){
                            Vechile_no.setError("Enter the Card Number");
                            Vechile_no.requestFocus();
                            return;
                        }

                        if(Email.isEmpty()){
                            mail.setError("Enter the Card Expery Date");
                            mail.requestFocus();
                            return;
                        }
                        if(Company.isEmpty()){
                            company.setError("Enter the CVC");
                            company.requestFocus();
                            return;
                        }
                        if(colour.isEmpty()){
                            carcolour.setError("Enter the name in the card");
                            carcolour.requestFocus();
                            return;
                        }
                        if(hour.isEmpty()){
                            Hour.setError("Enter the name in the card");
                            Hour.requestFocus();
                            return;
                        }
                        if(Slot.isEmpty()){
                            slot.setError("Enter the name in the card");
                            slot.requestFocus();
                            return;
                        }

                        boolean isInserted = myDb1.insertData(vechhileno,Email,Company,colour,hour,Slot);

                        if (isInserted == true)
                            Toast.makeText(parking.this, "Details Are Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(parking.this, "Details Are Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
    public void search() {
        SESARCH.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb1.search(search22.getText().toString());

                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            Vechile_no.setText(res.getString(1));
                            mail.setText(res.getString(2));
                            company.setText(res.getString(3));
                            carcolour.setText(res.getString(4));
                            Hour.setText(res.getString(5));
                            slot.setText(res.getString(6));
                        }


                    }


                }
        );
    }



    public void viewAll() {

        VIEW.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb1.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("VECHILE NO :" + res.getString(1) + "\n");
                            buffer.append("EMAIL :" + res.getString(2) + "\n");
                            buffer.append("COMPANY :" + res.getString(3) + "\n");
                            buffer.append("CAR COLOUR : :" + res.getString(4) + "\n");
                            buffer.append("HOUR :" + res.getString(5) + "\n");
                            buffer.append("SLOT :" + res.getString(6) + "\n\n");


                        }

                        showMessage("parking Details", buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title, String Messsage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Messsage);
        builder.show();


    }
}
