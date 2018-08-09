package com.example.astha.moodcoach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity implements View.OnClickListener{

    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnStart=(Button) findViewById(R.id.start);
        btnStart.setOnClickListener(this);
    }

    public void onClick(View V){
        startActivity(new Intent(homepage.this,LoginActivity.class));

    }
}
