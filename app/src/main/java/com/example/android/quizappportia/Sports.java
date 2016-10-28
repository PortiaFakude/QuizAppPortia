package com.example.android.quizappportia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Sports extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup rdgQ;
    RadioButton rdb1;
    RadioButton rdb2;
    RadioButton rdb3;
    TextView txtSports,timer;
    ImageView save;
    ImageView SportsImage;
    int index,score = 0;
    RadioButton selected;

    String answer = "";

    int c = 1;

    ArrayList<String> sportsQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports);

        rdb1 = (RadioButton) findViewById(R.id.rdbA1);
        rdb2 = (RadioButton) findViewById(R.id.rdbA2);
        rdb3 = (RadioButton) findViewById(R.id.rdbA3);

        rdgQ = (RadioGroup) findViewById(R.id.rdgEntertainment);
        rdgQ.setOnCheckedChangeListener(this);

        SportsImage = (ImageView) findViewById(R.id.imgEntertainment);

        save = (ImageView) findViewById(R.id.btnSave);
        txtSports = (TextView) findViewById(R.id.txtMovie);
        timer = (TextView) findViewById(R.id.txttimer);

        txtSports.setVisibility(View.GONE);
        rdb1.setVisibility(View.GONE);
        rdb2.setVisibility(View.GONE);
        rdb3.setVisibility(View.GONE);

        save.setVisibility(View.GONE);

        sportsQ = new ArrayList<>();


        sportsQ.add(getResources().getString(R.string.olympic));
        sportsQ.add(getResources().getString(R.string.team));
        sportsQ.add(getResources().getString(R.string.football));
        sportsQ.add(getResources().getString(R.string.volleyball));

        Collections.shuffle(sportsQ);

        viewQuestions();


        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");

                Intent i = new Intent(Sports.this,Topics.class);
                startActivity(i);

            }
        }.start();

    }

    public void saveAnswer(View v){


        c+=1;

        if (c <5)
        {
            viewQuestions();
        }
        else
        {

            SharedPreferences sharedPref = getSharedPreferences("score",0);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("score_entertainment",score);
            editor.commit();

            Intent intent = new Intent(Sports.this, Score.class);
            startActivity(intent);

        }

//        rdb1.setChecked(false);
//        rdb2.setChecked(false);
//        rdb3.setChecked(false);

    }

    public void viewQuestions() {

        rdb1.setVisibility(View.VISIBLE);
        rdb2.setVisibility(View.VISIBLE);
        rdb3.setVisibility(View.VISIBLE);
        txtSports.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);

        String  sportQ;

        if (index < sportsQ.size()) {

            sportQ = sportsQ.get(index);

            if ( sportQ.equals(getResources().getString(R.string.olympic)))
            {

                ArrayList<String> olympic = new ArrayList<>();


                olympic.add("Greece");
                olympic.add("Japan");
                olympic.add("Brazil");


                Collections.shuffle( olympic);

                SportsImage.setImageResource(R.drawable.greece);

                txtSports.setText(sportQ);
                rdb1.setText( olympic.get(0));
                rdb2.setText( olympic.get(1));
                rdb3.setText( olympic.get(2));
            }
            else if ( sportQ.equals(getResources().getString(R.string.team)))
            {

                ArrayList<String> soccer = new ArrayList<>();

                txtSports.setText( sportQ);
                soccer.add("Red devils");
                soccer.add("Blue Bulls");
                soccer.add("Saints");



                Collections.shuffle(soccer );

                SportsImage.setImageResource(R.drawable.red_devils);

                rdb1.setText(soccer .get(0));
                rdb2.setText(soccer .get(1));
                rdb3.setText(soccer .get(2));
            }

            else if (sportQ.equals(getResources().getString(R.string.football)))
            {

                ArrayList<String> football = new ArrayList<>();

                txtSports.setText(sportQ);
                football.add("Benny McCarthy");
                football.add("Aaron Mokoena");
                football.add("Christiano Ronaldo");

                Collections.shuffle(football);

                SportsImage.setImageResource(R.drawable.ronaldo1);

                rdb1.setText(football.get(0));
                rdb2.setText(football.get(1));
                rdb3.setText(football.get(2));

            }

            else if (sportQ.equals(getResources().getString(R.string.volleyball)))
            {

                ArrayList<String> volleyball = new ArrayList<>();

                txtSports.setText(sportQ);
                volleyball.add("Three players");
                volleyball.add("Two players");
                volleyball.add("Four players");

                Collections.shuffle(volleyball);

                SportsImage.setImageResource(R.drawable.beach_volleyball);

                rdb1.setText(volleyball.get(0));
                rdb2.setText(volleyball.get(1));
                rdb3.setText(volleyball.get(2));

            }

        }

        index++;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        selected = (RadioButton) radioGroup.findViewById(i);

        answer = selected.getText().toString();

        String q1 = getResources().getString(R.string.football);
        String q2 = getResources().getString(R.string.olympic);
        String q3 = getResources().getString(R.string.team);
        String q4 = getResources().getString(R.string.volleyball);


        if (q1.equalsIgnoreCase(getResources().getString(R.string.football)))
        {
            if (answer.equals(getResources().getString(R.string.footballA)))
            {
                score = score + 25;
            }
        }
        else
        {
            rdb1.setChecked(false);
            rdb2.setChecked(false);
            rdb3.setChecked(false);
        }



        if(q2.equalsIgnoreCase(getResources().getString(R.string.olympic)))
        {
            if(answer.equals(getResources().getString(R.string.olympicA)))
            {
                score = score + 25;
            }

        }
        else
        {
            rdb1.setChecked(false);
            rdb2.setChecked(false);
            rdb3.setChecked(false);
        }


        if(q3.equalsIgnoreCase(getResources().getString(R.string.team)))
        {
            if(answer.equals(getResources().getString(R.string.teamA)))
            {
                score = score + 25;
            }

        }
        else
        {
            rdb1.setChecked(false);
            rdb2.setChecked(false);
            rdb3.setChecked(false);
        }

        if(q4.equalsIgnoreCase(getResources().getString(R.string.volleyball)))
        {
            if(answer.equals(getResources().getString(R.string.volleyballA)))
            {
                score = score + 25;
            }

        }
        else
        {
            rdb1.setChecked(false);
            rdb2.setChecked(false);
            rdb3.setChecked(false);
        }


    }

}


