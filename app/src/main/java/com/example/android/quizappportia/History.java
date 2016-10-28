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

public class History extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup rdgQ;
    RadioButton rdb1;
    RadioButton rdb2;
    RadioButton rdb3;
    RadioButton selected;


    TextView txtHistory,timer;
    ImageView save;
    ImageView historyImage;
    int index,score = 0;



    String answer = "";

    int c = 1;

    ArrayList<String> historyQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        rdb1 = (RadioButton) findViewById(R.id.rdbA1);
        rdb2 = (RadioButton) findViewById(R.id.rdbA2);
        rdb3 = (RadioButton) findViewById(R.id.rdbA3);

        rdgQ = (RadioGroup) findViewById(R.id.rdgEntertainment);
        rdgQ.setOnCheckedChangeListener(this);

        historyImage = (ImageView) findViewById(R.id.imgEntertainment);

        save = (ImageView) findViewById(R.id.btnSave);
        txtHistory = (TextView) findViewById(R.id.txtMovie);
        timer = (TextView) findViewById(R.id.txttimer);

        rdb1.setVisibility(View.GONE);
        rdb2.setVisibility(View.GONE);
        rdb3.setVisibility(View.GONE);
        txtHistory.setVisibility(View.GONE);
        save.setVisibility(View.GONE);

        historyQ = new ArrayList<>();


        historyQ.add(getResources().getString(R.string.flag));
        historyQ.add(getResources().getString(R.string.city));
        historyQ.add(getResources().getString(R.string.president));
        historyQ.add(getResources().getString(R.string.country));


        Collections.shuffle(historyQ);

        viewQuestions();


        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");

                Intent i = new Intent(History.this,Topics.class);
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

            Intent intent = new Intent(History.this, Score.class);
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
        txtHistory.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);

        String  sportQ;

        if (index < historyQ.size()) {

            sportQ = historyQ.get(index);

            if ( sportQ.equals(getResources().getString(R.string.flag)))
            {

                ArrayList<String> flag = new ArrayList<>();


                flag.add("Canada");
                flag.add("South Africa");
                flag.add("Brazil");


                Collections.shuffle(flag);

                historyImage.setImageResource(R.drawable.canada);

                txtHistory.setText(sportQ);
                rdb1.setText(flag.get(0));
                rdb2.setText(flag.get(1));
                rdb3.setText(flag.get(2));
            }
            else if ( sportQ.equals(getResources().getString(R.string.city)))
            {

                ArrayList<String> city = new ArrayList<>();

                txtHistory.setText( sportQ);
                city.add("New York");
                city.add("London");
                city.add("Johannesburg");



                Collections.shuffle(city);

                historyImage.setImageResource(R.drawable.london1);

                rdb1.setText(city.get(0));
                rdb2.setText(city.get(1));
                rdb3.setText(city.get(2));
            }

            else if (sportQ.equals(getResources().getString(R.string.president)))
            {

                ArrayList<String> president = new ArrayList<>();

                txtHistory.setText(sportQ);
                president.add("Barack Obama");
                president.add("George Washington");
                president.add("Nelson Mandela");

                Collections.shuffle(president);

                historyImage.setImageResource(R.drawable.george);

                rdb1.setText(president.get(0));
                rdb2.setText(president.get(1));
                rdb3.setText(president.get(2));

            }

            else if (sportQ.equals(getResources().getString(R.string.country)))
            {

                ArrayList<String> country = new ArrayList<>();

                txtHistory.setText(sportQ);
                country.add("South Africa");
                country.add("Russia");
                country.add("Brazil");

                Collections.shuffle(country);

                historyImage.setImageResource(R.drawable.russia);

                rdb1.setText(country.get(0));
                rdb2.setText(country.get(1));
                rdb3.setText(country.get(2));

            }


        }

        index++;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        selected = (RadioButton) radioGroup.findViewById(i);

        answer = selected.getText().toString();

        String q1 = getResources().getString(R.string.city);
        String q2 = getResources().getString(R.string.country);
        String q3 = getResources().getString(R.string.flag);
        String q4 = getResources().getString(R.string.president);


        if (q1.equalsIgnoreCase(getResources().getString(R.string.city)))
        {
            if (answer.equals(getResources().getString(R.string.cityA)))
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

        if(q2.equalsIgnoreCase(getResources().getString(R.string.country)))
        {
            if(answer.equals(getResources().getString(R.string.countryA)))
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


        if(q3.equalsIgnoreCase(getResources().getString(R.string.flag)))
        {
            if(answer.equals(getResources().getString(R.string.flagA)))
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

        if(q4.equalsIgnoreCase(getResources().getString(R.string.president)))
        {
            if(answer.equals(getResources().getString(R.string.presidentA)))
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

