package com.example.astha.moodcoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class imagebth extends AppCompatActivity implements View.OnClickListener {
    ImageButton happybtn,sadbtn,angbtn,fearbtn,boredbtn,neutralbtn;
    Button proceedbtn;

    String[] sad = {"6S9E0MVteEc", "DdHB7V6sGFo", "K8BGkoJv6gg", "TLoDa3d6rCk"};
    String[] happy = {"_R6R62qUgIs", "nb6B2lzUqMI", "R7iN71uJcG0", "EUoKyjBIoE8"};
    String[] fear = {"SUEK9Sab4Vs", "VQXyYumRXUk", "ztkmSCsrD80", "2cYoQQDOOgU"};
    String[] bored = {"zjFvdA4eDrw", "xzDPbrrTQys", "UGPxfizP1aI", "7dcc1LXx64s"};
    String[] angry = {"3J-cYxxHQGQ", "LNyJgNjCDuU", "VaoV1PrYft4", "fQNFMxYxFSQ"};
    String[] neutral={"R7iN71uJcG0","7dcc1LXx64s","2cYoQQDOOgU"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebth);

        proceedbtn=(Button) findViewById(R.id.proceed);
        happybtn=(ImageButton) findViewById(R.id.happiness);
        sadbtn=(ImageButton) findViewById(R.id.sadness);
        angbtn=(ImageButton) findViewById(R.id.anger);
        fearbtn=(ImageButton) findViewById(R.id.fear);
        boredbtn=(ImageButton) findViewById(R.id.boredom);
        neutralbtn=(ImageButton) findViewById(R.id.neutral);

        proceedbtn.setOnClickListener(this);
        happybtn.setOnClickListener(this);
        sadbtn.setOnClickListener(this);
        fearbtn.setOnClickListener(this);
        boredbtn.setOnClickListener(this);
        angbtn.setOnClickListener(this);
        neutralbtn.setOnClickListener(this);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


    }

    public void onClick(View V){
        if(V.getId()==R.id.proceed){
            Intent i = new Intent(imagebth.this, MainActivity.class);
            startActivity(i);
        }else {

            Intent i = new Intent(imagebth.this, YTplayer.class);
            if (V.getId() == R.id.happiness) {
                i.putExtra("vidid", happy[1]);
            } else if (V.getId() == R.id.sadness) {
                i.putExtra("vidid", sad[1]);
            } else if (V.getId() == R.id.boredom) {
                i.putExtra("vidid", bored[1]);
            } else if (V.getId() == R.id.anger) {
                i.putExtra("vidid", angry[1]);
            } else if (V.getId() == R.id.fear) {
                i.putExtra("vidid", fear[1]);
            } else if (V.getId() == R.id.neutral) {
                i.putExtra("vidid", neutral[2]);
            }
            startActivity(i);
        }
    }
}
