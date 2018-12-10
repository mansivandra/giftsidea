package com.example.mansi.giftsidea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pay extends AppCompatActivity {
    TextView te1, te2, te3, te4, te5, te6, te7, te8, te9;
    Button btt1, btt2;
    Integer cal_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        te1 = (TextView) findViewById(R.id.text1);
        te2 = (TextView) findViewById(R.id.text2);
        te3 = (TextView) findViewById(R.id.text3);
        te4 = (TextView) findViewById(R.id.text4);
       te5 = (TextView) findViewById(R.id.txtCount);
        te6 = (TextView) findViewById(R.id.text6);
        te7 = (TextView) findViewById(R.id.text7);
        te8 = (TextView) findViewById(R.id.text8);
        te9 = (TextView) findViewById(R.id.text9);

        btt1 = (Button) findViewById(R.id.increment_button);
        btt2 = (Button) findViewById(R.id.decrement_button);

        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal_quantity = (Integer.parseInt((te5.getText().toString())));
                if (cal_quantity != 1) {
                    cal_quantity = cal_quantity - 1;
                }
                te5.setText(cal_quantity + "");
                Integer get_total = cal_quantity * 1299;
                te9.setText(get_total + "");
            }

        });
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal_quantity = (Integer.parseInt(te5.getText().toString()));
                cal_quantity = cal_quantity + 1;
                te5.setText(cal_quantity + "");
                Integer get_total = cal_quantity * 1299;
                te9.setText(get_total + "");
            }
        });

    }
}
