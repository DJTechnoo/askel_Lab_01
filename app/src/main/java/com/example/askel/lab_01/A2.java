package com.example.askel.lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    private TextView t3View;
    private TextView t2View;
    private String name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        String ACT;
        t2View = findViewById(R.id.T2);
        t3View = findViewById(R.id.T3);


        Intent fromOther = getIntent();
        ACT = fromOther.getStringExtra("ACTIVITY");

        if(ACT.equals("A1")) {
            name1 = fromOther.getStringExtra("T1");
            t2View.setText("Hello " + name1);
        }
        else {
            t2View.setText(name1);
        }
    }

    public void toA3FromB2(View view) {
        Intent toA3 = new Intent(this, A3.class);
        toA3.putExtra("T2", name1);
        startActivityForResult(toA3, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String name2;

        // Check which request we're responding to
        if ((requestCode == 1)&& (resultCode == RESULT_OK)) {
            name2 = data.getStringExtra("T4");
            t3View.setText("From A3 " + name2);
        }
    }
}
