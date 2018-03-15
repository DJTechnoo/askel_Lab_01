package com.example.askel.lab_01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText etext;
    private Spinner spinner;
    private String spinnerPrefFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerPrefFile = "spinnerpref";
        etext = (EditText) findViewById(R.id.T1);
        spinner = (Spinner) findViewById(R.id.L1);
        ArrayAdapter<String> arAdapter = new ArrayAdapter<String>(this,
                                android.R.layout.simple_expandable_list_item_1,
                                getResources().getStringArray(R.array.names));
        arAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arAdapter);


        spinnerPref();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int num = i;
                SharedPreferences spinPref = getSharedPreferences(spinnerPrefFile, MODE_PRIVATE);
                SharedPreferences.Editor spinnerEdit = spinPref.edit();
                spinnerEdit.putInt("ITEM_NUM", num);
                spinnerEdit.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // get the last state of the spinner
    public void spinnerPref(){
        SharedPreferences spinPref = getSharedPreferences(spinnerPrefFile, MODE_PRIVATE);
        int num = spinPref.getInt("ITEM_NUM", 0);
        spinner.setSelection(num);
    }


    // Gets the textView to string and put to next activity
    public void toA2FromB1(View view) {
        String text = etext.getText().toString();

        Intent toA2 = new Intent(this, A2.class);
        toA2.putExtra("ACTIVITY", "A1");
        toA2.putExtra("T1", text);
        startActivity(toA2);
    }
}
