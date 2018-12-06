package com.example.mansi.giftsidea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class about extends AppCompatActivity {
Button bt;
TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        bt=(Button)findViewById(R.id.bt1);
        tx=(TextView)findViewById(R.id.tx1);
    }
}
