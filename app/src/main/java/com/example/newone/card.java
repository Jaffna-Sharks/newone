package com.example.newone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class card extends AppCompatActivity {
    SQLiteHelper myDb;
    EditText cardno;
    EditText cexpdate;
    EditText cvc;
    EditText name;

    EditText sea;
    Button edit;
    Button View;
    Button delete;
    Button add;
    Button card;
    Button search;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        myDb = new SQLiteHelper(this);

        cardno = findViewById(R.id.cardno);
        cexpdate = findViewById(R.id.exp);
        cvc = findViewById(R.id.cvc);
        name = findViewById(R.id.name);

        sea = findViewById(R.id.editText2);
        search = findViewById(R.id.button18);
        edit = findViewById(R.id.button9);
        View = findViewById(R.id.button8);
        delete = findViewById(R.id.button7);
        add = findViewById(R.id.button17);
        card = findViewById(R.id.button10);
        addData();
        viewAll();
        updateData();
        deleteData();
        search();

    }


        public void deleteData () {
            delete.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            Integer deleterows = myDb.DeleteData(cardno.getText().toString());
                            if (deleterows > 0)
                                Toast.makeText(card.this, "Details Are Deleted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(card.this, "Details Are Not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }

            );
        }


        public void updateData() {

            edit.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isUpdate = myDb.updateData(cardno.getText().toString(),
                                    cexpdate.getText().toString(),
                                    cvc.getText().toString(),
                                    name.getText().toString());
                            if (isUpdate == true)

                                Toast.makeText(card.this, "Details Are Updated", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(card.this, "Details Are Not Updated", Toast.LENGTH_LONG).show();

                        }
                    }
            );
        }

        public void addData() {

            add.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String textName = cardno.getText().toString().trim();
                            String textDate = cexpdate.getText().toString().trim();
                            String textAddress = cvc.getText().toString().trim();
                            String textTime = name.getText().toString().trim();
                           // String amount = amount.getText().toString().trim();

                            if(textName.isEmpty()){
                                cardno.setError("Enter the Card Number");
                                cardno.requestFocus();
                                return;
                            }

                            if(textDate.isEmpty()){
                                cexpdate.setError("Enter the Card Expery Date");
                                cexpdate.requestFocus();
                                return;
                            }
                            if(textAddress.isEmpty()){
                                cvc.setError("Enter the CVC");
                                cvc.requestFocus();
                                return;
                            }
                            if(textTime.isEmpty()){
                                name.setError("Enter the name in the card");
                                name.requestFocus();
                                return;
                            }

                            boolean isInserted = myDb.insertData(textName,textDate,textAddress,textTime);

                            if (isInserted == true)
                                Toast.makeText(card.this, "Details Are Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(card.this, "Details Are Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
            );

        }
    public void search() {
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
    }



        public void viewAll() {

            View.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Cursor res = myDb.getAllData();
                            if (res.getCount() == 0) {
                                showMessage("Error", "Nothing Found");
                                return;
                            }
                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()) {
                                buffer.append("Card no :" + res.getString(1) + "\n");
                                buffer.append("Exp date :" + res.getString(2) + "\n");
                                buffer.append("cvc :" + res.getString(3) + "\n");
                                buffer.append("name : :" + res.getString(4) + "\n\n");


                            }

                            showMessage("card Details", buffer.toString());
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
