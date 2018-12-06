package com.example.mansi.giftsidea;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class buynow extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] country = {"---SELECT---","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh", "Goa","Gujarat","Haryana","Himachal","Jammu & Kashmir", "Jharkhand", "Karnataka"," Kerala", "Madhya Pradesh", "Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha", "Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura", "Uttarakhand", "Uttar Pradesh","West Bengal"};
String LOVE_URL ="https://weekendholidayplan.000webhostapp.com/insert.php";
Button button1,button2;
TextView title, fname,lname,add1,add2,landmark,pincode,city,state,mob,wtsapp,email;
EditText fname1,lname1,add11,add21,landmark1,pincode1,city1,mob1,wtsapp1,email1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buynow);
        title=(TextView)findViewById(R.id.txt1);
        fname=(TextView)findViewById(R.id.t1);
        lname=(TextView)findViewById(R.id.t2);
        add1=(TextView)findViewById(R.id.t3);
        add2=(TextView)findViewById(R.id.t4);
        landmark=(TextView)findViewById(R.id.t5);
        pincode=(TextView)findViewById(R.id.t6);
        city=(TextView)findViewById(R.id.t7);
        state=(TextView)findViewById(R.id.t8);
        mob=(TextView)findViewById(R.id.t9);
        wtsapp=(TextView)findViewById(R.id.t10);
        email=(TextView)findViewById(R.id.t11);

        fname1=(EditText) findViewById(R.id.e1);
        lname1=(EditText)findViewById(R.id.e2);
        add11=(EditText)findViewById(R.id.e3);
        add21=(EditText)findViewById(R.id.e4);
        landmark1=(EditText)findViewById(R.id.e5);
        pincode1=(EditText)findViewById(R.id.e6);
        city1=(EditText)findViewById(R.id.e7);
        mob1=(EditText)findViewById(R.id.e9);
        wtsapp1=(EditText)findViewById(R.id.e10);
        email1=(EditText)findViewById(R.id.e11);


        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(buynow.this,pay.class);
                startActivity(intent);
            }
        });
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        StringRequest request=new StringRequest(Request.Method.POST, LOVE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(buynow.this,"suceess insert",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(buynow.this,"unsuceess insert",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>param=new HashMap<>();
                param.put("FirstName",fname1.getText().toString());
                param.put("LastName",lname1.getText().toString());
                param.put("AddressLine1",add11.getText().toString());
                param.put("AddressLine2",add21.getText().toString());
                param.put("NearbyLandmark",landmark1.getText().toString());
                param.put("Pincode",pincode1.getText().toString());
                param.put("City",city1.getText().toString());
                param.put("CallingMobileNo",mob1.getText().toString());
                param.put("WhatsAppMobileNo",wtsapp1.getText().toString());
                param.put("EmailAddress",email1.getText().toString());
                return param;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(buynow.this);
        queue.add(request);
        Intent intent=new Intent(buynow.this,buynow.class);
        startActivity(intent);
    }
});

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
