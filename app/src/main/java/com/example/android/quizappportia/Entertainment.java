package com.example.android.quizappportia;

import android.content.Context;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class Entertainment extends AppCompatActivity  implements RadioGroup.OnCheckedChangeListener
{


    RadioGroup rdgQ;
    RadioButton rdb1;
    RadioButton rdb2;
    RadioButton rdb3;
    RadioButton selected;


    TextView txtEntertainment,timer;
    ImageView save;
    ImageView EntertainmentImage;
    int index, score = 0;

    String answer = "";

    int c = 1;

    ArrayList<String> entertainmentQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment);

        rdb1 = (RadioButton) findViewById(R.id.rdbA1);
        rdb2 = (RadioButton) findViewById(R.id.rdbA2);
        rdb3 = (RadioButton) findViewById(R.id.rdbA3);

        rdgQ = (RadioGroup) findViewById(R.id.rdgEntertainment);

        rdgQ.setOnCheckedChangeListener(this);

        EntertainmentImage = (ImageView) findViewById(R.id.imgEntertainment);

        save = (ImageView) findViewById(R.id.btnSave);
        txtEntertainment = (TextView) findViewById(R.id.txtMovie);
        timer = (TextView) findViewById(R.id.txttimer);

         rdb1.setVisibility(View.GONE);
         rdb2.setVisibility(View.GONE);
         rdb3.setVisibility(View.GONE);
        txtEntertainment.setVisibility(View.GONE);
         save.setVisibility(View.GONE);

         entertainmentQ = new ArrayList<>();

         entertainmentQ.add(getResources().getString(R.string.film));
         entertainmentQ.add(getResources().getString(R.string.tvcomedy));
         entertainmentQ.add(getResources().getString(R.string.music));
         entertainmentQ.add(getResources().getString(R.string.movie));

         Collections.shuffle(entertainmentQ);

        viewQuestions();

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");

                Intent i = new Intent(Entertainment.this,Topics.class);
                startActivity(i);

            }
        }.start();


    }
    public void saveAnswer(View v)
    {

        c+=1;

//        rdb1.setChecked(false);
//        rdb2.setChecked(false);
//        rdb3.setChecked(false);


        if (c < 5)
        {
            viewQuestions();

        }
        else
        {

            SharedPreferences sharedPref = getSharedPreferences("score",0);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("score_entertainment",score);
            editor.commit();

            Intent intent = new Intent(Entertainment.this, Score.class);
            startActivity(intent);

        }



    }

    public void viewQuestions() {

        rdb1.setVisibility(View.VISIBLE);
        rdb2.setVisibility(View.VISIBLE);
        rdb3.setVisibility(View.VISIBLE);
        txtEntertainment.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);

        String movieQ;

        if (index < entertainmentQ.size()) {

            movieQ = entertainmentQ.get(index);

            if (movieQ.equals(getResources().getString(R.string.film)))
            {

                ArrayList<String> film = new ArrayList<>();


                film.add("Arnold Schwarzenegger");
                film.add("Steven Seagal");
                film.add("Denzel Washington");


                Collections.shuffle(film);

                EntertainmentImage.setImageResource(R.drawable.as);

                txtEntertainment.setText(movieQ);
                rdb1.setText(film.get(0));
                rdb2.setText(film.get(1));
                rdb3.setText(film.get(2));
            }

            else if (movieQ.equals(getResources().getString(R.string.movie)))
            {

                ArrayList<String> movie = new ArrayList<>();

                txtEntertainment.setText(movieQ);
                movie.add("Whoopi Goldberg");
                movie.add("Julia Roberts");
                movie.add("Terry Pheto");

                Collections.shuffle(movie);

                EntertainmentImage.setImageResource(R.drawable.whoopi);

                rdb1.setText(movie.get(0));
                rdb2.setText(movie.get(1));
                rdb3.setText(movie.get(2));

            }

            else if (movieQ.equals(getResources().getString(R.string.tvcomedy)))
            {

                ArrayList<String> tvcomedy = new ArrayList<>();

                txtEntertainment.setText(movieQ);
                tvcomedy.add("Mr Bean");
                tvcomedy.add("Jack Black");
                tvcomedy.add("Jim Carrey");



                Collections.shuffle(tvcomedy);

                EntertainmentImage.setImageResource(R.drawable.bean);

                rdb1.setText(tvcomedy.get(0));
                rdb2.setText(tvcomedy.get(1));
                rdb3.setText(tvcomedy.get(2));
            }

            else if (movieQ.equals(getResources().getString(R.string.music)))
            {

                ArrayList<String> music = new ArrayList<>();

                txtEntertainment.setText(movieQ);
                music.add("Beyonce Knowles");
                music.add("Rihanna");
                music.add("Mariah Carey");

                Collections.shuffle(music);

                EntertainmentImage.setImageResource(R.drawable.musician);

                rdb1.setText(music.get(0));
                rdb2.setText(music.get(1));
                rdb3.setText(music.get(2));

            }


        }

        index++;
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        selected = (RadioButton) radioGroup.findViewById(i);

        answer = selected.getText().toString();

        String q1 = getResources().getString(R.string.film);
        String q2 = getResources().getString(R.string.music);
        String q3 = getResources().getString(R.string.tvcomedy);
        String q4 = getResources().getString(R.string.movie);


        if (q1.equalsIgnoreCase(getResources().getString(R.string.film)))
        {
            if (answer.equals(getResources().getString(R.string.filmA)))
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



        if(q2.equalsIgnoreCase(getResources().getString(R.string.music)))
        {
            if(answer.equals(getResources().getString(R.string.musicA)))
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

        if(q3.equalsIgnoreCase(getResources().getString(R.string.tvcomedy)))
        {
            if(answer.equals(getResources().getString(R.string.tvcomedyA)))
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

        if(q4.equalsIgnoreCase(getResources().getString(R.string.movie)))
        {
            if(answer.equals(getResources().getString(R.string.movieA)))
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
