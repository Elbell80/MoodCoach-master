package com.example.astha.moodcoach;

import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import java.net.ResponseCache;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editText2;
    TextView btnFeeling;
    Button btnSubmit;
    Button btnViewData;
    String t1;
    String input;
    ProgressBar progressBar;



    

    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        //viewPager=(ViewPager) findViewById(R.id.viewPager);

        myDb = new DatabaseHelper(this);

        editText2=(EditText)findViewById(R.id.editText2);
        btnFeeling=(TextView)findViewById(R.id.button);
        btnSubmit=(Button)findViewById(R.id.button2);
        //btnViewData=(Button)findViewById(R.id.viewData);
        viewPager=(ViewPager)findViewById(R.id.viewpager);

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        Submit();
        //simpleProgressBar.setVisibility(View.VISIBLE);
        //viewAllmethod();

    }



    public void Submit(){
        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Scanner scan = new Scanner(System.in);
                        //String input = scan.nextLine();
                        //input = scan.nextLine();
                        input = editText2.getText().toString();

                        //fetchingData();
                        boolean isInserted = myDb.insertData(input);

                        if(input.length()==0){
                            Toast.makeText(MainActivity.this,"The textbox is empty.", Toast.LENGTH_SHORT).show();
                        }else{
                            pushData();

                            editText2.setText("");
                        }

                    }
                    //simpleProgressBar.setVisibility(View.VISIBLE);
                }
        );
    }

    void pushData(){


       String myURL="https://ee0ae6b2.ngrok.io/addone";
       StringRequest sq = new StringRequest(Request.Method.POST, myURL, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               startActivity(new Intent(getApplicationContext(),fetchedData.class));


           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               //Log.d("value",input);
               //Log.d("error:",error.getMessage());

           }
       }){
           @Override
           protected Map<String, String> getParams(){
               Map<String , String> params = new HashMap<String,String>();
               params.put("mytext",input) ;
               return  params;
           }
       };


        AppController.getInstance().addToRequestQueue(sq);
        //Toast.makeText(getApplicationContext(),"Data inserted!",Toast.LENGTH_LONG).show();
    }






    /*public void viewAllmethod(){
        btnViewData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor res=myDb.getAllData();
                        if(res.getCount()==0){
                            //show message
                            showMessage("ERROR","Nothing found");
                            return;
                        }

                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID :"+res.getString(0)+"\n");
                            buffer.append("INPUT :"+res.getString(1)+"\n\n");
                        }
                        //show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }*/

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}