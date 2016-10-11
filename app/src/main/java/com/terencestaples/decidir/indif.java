package com.terencestaples.decidir;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class indif extends AppCompatActivity {
    EditText editText;
    TextView textView2;
    TextView tv;
    ArrayList<String> choices = new ArrayList<>();
    int j=1;
    boolean questionAsked =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText("");
        }
    });
        textView2 = (TextView)findViewById(R.id.textView2);
        tv = (TextView) findViewById(R.id.textView);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView2.setText(editText.getText());
                choices.add(editText.getText().toString());
                textView2.append(j + ".) " + editText.getText().toString() +  "\n");
                // this will still be buggy if too many choices are input at once
                editText.setText("");
                j++;


            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               if((questionAsked == false) && !(choices.isEmpty())) {
                   int i = (int) (Math.random() * choices.size());
                   textView2.setText(choices.get(i));
                   choices.clear();
                   editText.setText("");
                   j = 1;
                   tv.setText("You should:");
                   button2.setText("Make a new decision");
                   questionAsked = true;
               }
               else{
                   questionAsked = false;
                   tv.setText("Help me decide whether I should:");
                   button2.setText("HELP ME CHOOSE!");
                   textView2.setText(" ");
               }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_indif, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
