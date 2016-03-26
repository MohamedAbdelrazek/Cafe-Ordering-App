package com.example.android.justjava;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.renderscript.ScriptGroup;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {
int n;
    String your_Name;
    boolean mark_coffee=false,mark_tea=false,mark_nescafee=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {


        CheckBox f = (CheckBox) findViewById(R.id.cof);
        mark_coffee = f.isChecked();
        CheckBox g = (CheckBox) findViewById(R.id.tea);
        mark_tea = g.isChecked();
        CheckBox h = (CheckBox) findViewById(R.id.nes);
        mark_nescafee = h.isChecked();
        EditText e;
        e=(EditText) findViewById(R.id.edit);
        your_Name=e.getText().toString();
        String M = "Name  is  : "+your_Name+ "\n Total is " + n * 2 + " LE \n Cofeee " + mark_coffee + "\n Tea  " + mark_tea + "\n Nescafee  " + mark_nescafee;
        Intent intent =new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: "));
        intent.putExtra(Intent.EXTRA_SUBJECT, " Just Java  Order for " + your_Name);
        intent.putExtra(Intent.EXTRA_TEXT,M);
        if (intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }


    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    public void increment(View view) {
        n++;
        display(n);

    }

    public void decrement(View view) {
        if (n > 0)
        {
            n--;}
        display(n);
        if(n==0)
        Toast.makeText(MainActivity.this, " Enter a positive number ", Toast.LENGTH_SHORT).show();

    }

}