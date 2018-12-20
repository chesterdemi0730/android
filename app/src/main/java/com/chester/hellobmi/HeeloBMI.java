package com.chester.hellobmi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class HeeloBMI extends AppCompatActivity {

    EditText mEditHeight;
    EditText mEditWeight;
    EditText mEditValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heelo_bmi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEditHeight = (EditText)findViewById(R.id.textBMIHeight);
        mEditWeight = (EditText)findViewById(R.id.textBMIWeight);
        mEditValue = (EditText)findViewById(R.id.textBMIValue);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_heelo_bmi, menu);
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

    public void onCaculate(View view)
    {
        double height = Double.parseDouble(mEditHeight.getText().toString());
        double weight = Double.parseDouble(mEditWeight.getText().toString());
        mEditValue.setText(String.valueOf(calculateBMI(height, weight)));
    }

    private double calculateBMI(double height, double weight)
    {
        double BMI = 0.0;
        if(height <= 0) return BMI;
        if(weight <= 0) return BMI;

        BMI = weight*100 / (height*height);

        if(BMI <= 0) return BMI;

        return Math.round(BMI)/100;
    }
}
