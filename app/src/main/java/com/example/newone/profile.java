package com.example.newone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class profile extends AppCompatActivity {
    profileDBManager myDb2;
    Button Edit;
    Button Delete;
    Button View;
    Button Add1;
    EditText name;
    EditText Email;
    EditText Contact_no;
    EditText Vehicle_no;
    EditText identycard;
    ImageButton logout2;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        myDb2 = new profileDBManager(this);
        Edit=findViewById(R.id.Edit);
        Delete=findViewById(R.id.delete);
        Add1=findViewById(R.id.button20);
        View=findViewById(R.id.viewpro);
        name=findViewById(R.id.editText29);
        Email=findViewById(R.id.editText30);
        Contact_no=findViewById(R.id.editText31);
        Vehicle_no=findViewById(R.id.editText32);
        identycard=findViewById(R.id.editText34);
        logout2=findViewById(R.id.logout2);
        addData();
        viewAll();
        updateData();
        deleteData();



        logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, HOME.class);
                startActivity(intent);
            }
        });




    }
    public void deleteData () {
        Delete.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Integer deleterows = myDb2.DeleteData(name.getText().toString());
                        if (deleterows > 0)
                            Toast.makeText(profile.this, "Details Are Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(profile.this, "Details Are Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }


    public void updateData() {

        Edit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb2.updateData(name.getText().toString(),
                                Email.getText().toString(),
                                Contact_no.getText().toString(),
                                Vehicle_no.getText().toString(),
                                identycard.getText().toString());
                        if (isUpdate == true)

                            Toast.makeText(profile.this, "Details Are Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(profile.this, "Details Are Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void addData() {

        Add1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                        String identyPattern ="[0-9]+[V]";
                        String vehiclePattern="[a-zA-Z0-9._-]+[0-9]";
                        String textName = name.getText().toString().trim();
                        String textEmail = Email.getText().toString().trim();
                        String textcontact = Contact_no.getText().toString().trim();
                        String textvehicle = Vehicle_no.getText().toString().trim();
                        String identy = identycard.getText().toString().trim();
                        boolean isValid=true;

                        if(textName.isEmpty()){
                            name.setError("Enter the name");
                            name.requestFocus();
                            isValid=false;
                        }


                        if(textEmail.isEmpty()){
                            Email.setError("Enter the EmailAddress");
                            Email.requestFocus();
                            isValid=false;
                        }else if(!textEmail.matches(emailPattern)) {
                            Email.setError("Invalid  EmailAddress");
                            Email.requestFocus();
                            isValid=false;

                        }
                        if(textcontact.isEmpty()){
                            Contact_no.setError("Enter the Contact number");
                            Contact_no.requestFocus();
                            isValid=false;
                        }
                        if(textvehicle.isEmpty()){
                            Vehicle_no.setError("Enter the vechile number");
                            Vehicle_no.requestFocus();
                            isValid=false;
                        }
                        else if(!textvehicle.matches(vehiclePattern)) {
                            Vehicle_no.setError("Invalid  vechile number");
                            Vehicle_no.requestFocus();
                            isValid = false;
                        }
                        if(identy.isEmpty()){
                            identycard.setError("Enter the identycard number");
                            identycard.requestFocus();
                            isValid=false;
                        }
                        else if(!identy.matches(identyPattern)) {
                            identycard.setError("Invalid  Identy");
                            identycard.requestFocus();
                            isValid = false;
                        }
                        if(isValid){
                            boolean isInserted = myDb2.insertData(textName,textEmail,textcontact,textvehicle,identy);

                            if (isInserted == true)
                                Toast.makeText(profile.this, " Profile Details Are Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(profile.this, "Profile Details Are Not Inserted", Toast.LENGTH_LONG).show();
                        }

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

        View.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb2.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("NAME :" + res.getString(1) + "\n");
                            buffer.append("EMAIL :" + res.getString(2) + "\n");
                            buffer.append("CONTACTNO :" + res.getString(3) + "\n");
                            buffer.append("VECHILENO : :" + res.getString(4) + "\n");
                            buffer.append("IDENTYCARD : :" + res.getString(5) + "\n\n");


                        }

                        showMessage("USER Details", buffer.toString());
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
