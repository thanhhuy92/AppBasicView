package com.example.basicview;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editName, editEmail;
    Button btnCancel, btnInfo;
    RadioButton rdMale, rdFeMale;
    CheckBox chkReading, chkTravelling, chkCoding;
    Spinner spinLang;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        rdFeMale = (RadioButton) findViewById(R.id.rdFeMale);
        rdMale = (RadioButton) findViewById(R.id.rdMale);
        chkReading = (CheckBox) findViewById(R.id.chkReading);
        chkTravelling = (CheckBox) findViewById(R.id.chkTravelling);
        chkCoding = (CheckBox)findViewById(R.id.chkCoding);
        spinLang = (Spinner) findViewById(R.id.spinner);
        imageView = (ImageView) findViewById(R.id.imageView);

        ArrayList<String> lan_array =  new ArrayList<String>();

        lan_array.add("VietNamese");

        lan_array.add("English");

        lan_array.add("French");

        lan_array.add("Chinese");

        ArrayAdapter adapter = new ArrayAdapter(

                this, android.R.layout.simple_spinner_item, lan_array);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLang.setAdapter(adapter);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel(v);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String info = "My name: " + editName.getText().toString() +
                        System.getProperty("line.separator") +
                        "Email: " + editEmail.getText().toString() +
                        System.getProperty("line.separator") + "My Sex: ";
                if(rdMale.isChecked())
                {
                    info += rdMale.getText().toString()+
                            System.getProperty("line.separator") + "My Hobbies: ";
                }
                else {
                    info +=rdFeMale.getText().toString()+
                            System.getProperty("line.separator") + "My Hobbies: ";
                }
                if(chkReading.isChecked())
                {
                    info += chkReading.getText().toString() + ", ";
                }
                if(chkTravelling.isChecked())
                {
                    info += chkTravelling.getText().toString() + ", ";
                }
                if(chkCoding.isChecked())
                {
                    info += chkCoding.getText().toString() + ", ";
                }
                info += System.getProperty("line.separator") + "My language: " +
                        spinLang.getSelectedItem().toString();

                info(v,info);
                editName.setText("");
                editEmail.setText("");
                chkCoding.setChecked(false);
                chkReading.setChecked(false);
                chkTravelling.setChecked(false);
                rdFeMale.setChecked(false);
                rdMale.setChecked(false);
            }
        });

    }

    private  void  cancel(View v){
        System.exit(0);
    }

    public void info(View v, String info) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(info);
        dlgAlert.setTitle("Basic View");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
