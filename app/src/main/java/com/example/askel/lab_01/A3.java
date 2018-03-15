package com.example.askel.lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class A3 extends AppCompatActivity {
    private EditText etext;
    private TextView t3View;
    String name1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        etext = (EditText) findViewById(R.id.T4);
        t3View = findViewById(R.id.T4);
        Intent fromOther = getIntent();
        name1 = fromOther.getStringExtra("T2");
        t3View.setText(name1);
    }

    public void editNameClick(View view) {

        String text = etext.getText().toString();
        Intent toA2 = new Intent();
        toA2.putExtra("T4", text);
        setResult(RESULT_OK, toA2);
        finish();
    }
}
