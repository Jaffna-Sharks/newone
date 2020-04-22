package com.example.newone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    PaymentDatabaseHelper myDb4;

    EditText name;
    EditText vechileno;
    EditText hour;
    EditText amount;

    EditText payment;

    Button add;
    Button edit;
    Button cash;
    Button card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment21);

        myDb4 = new PaymentDatabaseHelper(this);
        name=findViewById(R.id.editText17);
        vechileno=findViewById(R.id.editText19);
        hour=findViewById(R.id.editText22);
        amount=findViewById(R.id.editText23);
        payment=findViewById(R.id.editText24);
       add=findViewById(R.id.button21);
        edit=findViewById(R.id.button22);
        cash=findViewById(R.id.button2);
        card=findViewById(R.id.button5);
        updateData();
        addData();
        viewAll();


        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this,card.class);
                startActivity(intent);
            }
        });






    }
    public void updateData() {

        edit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb4.updateData(vechileno.getText().toString(),
                                name.getText().toString(),
                                hour.getText().toString(),
                                amount.getText().toString(),
                                payment.getText().toString());
                        if (isUpdate == true)

                            Toast.makeText(Payment.this, "Details Are Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Payment.this, "Details Are Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void addData() {

        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String textvechile = vechileno.getText().toString().trim();
                        String textName = name.getText().toString().trim();
                        String textHours = hour.getText().toString().trim();
                        String textAmount = amount.getText().toString().trim();
                        String textpayment = payment.getText().toString().trim();

                        if(textvechile.isEmpty()){
                            vechileno.setError("Enter the Vechile Number");
                            vechileno.requestFocus();
                            return;
                        }
                        if(textName.isEmpty()){
                            name.setError("Enter the Nmae");
                            name.requestFocus();
                            return;
                        }

                        boolean isInserted = myDb4.insertData(textvechile,textName,textHours,textAmount,textpayment);


                        if (isInserted == true)
                            Toast.makeText(Payment.this, "Details Are Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Payment.this, "Details Are Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
   /* public void search() {
        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb.search(sea.getText().toString());

                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            cardno.setText(res.getString(1));
                            cexpdate.setText(res.getString(2));
                            cvc.setText(res.getString(3));
                            name.setText(res.getString(4));
                        }


                    }


                }
        );
    }*/



    public void viewAll() {

        cash.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb4.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Vechile No :" + res.getString(1) + "\n");
                            buffer.append("Name :" + res.getString(2) + "\n");
                            buffer.append("Hours :" + res.getString(3) + "\n");
                            buffer.append("Amount  :" + res.getString(4) + "\n");
                            buffer.append("Payment  :" + res.getString(5) + "\n\n");


                        }

                        showMessage("Payment Details", buffer.toString());
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
