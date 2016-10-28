package com.example.android.quizappportia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Score extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        SharedPreferences sharedPref = getSharedPreferences("score",0);

        int scoreE = sharedPref.getInt("score_entertainment",0);

        TextView score = (TextView) findViewById(R.id.score);
        TextView msg = (TextView) findViewById(R.id.txtMessage);
        ImageView icon = (ImageView) findViewById(R.id.imgIcons);

        if(scoreE == 0)
        {
            msg.setText("SORRY,LOSER!");
            icon.setImageResource(R.drawable.sad);

        }
        else if(scoreE == 25)
        {
            msg.setText("SORRY,PLEASE TRY AGAIN!");
            icon.setImageResource(R.drawable.sad1);
        }
        else if(scoreE == 50)
        {
            msg.setText("GOOD,YOU TRIED!");
            icon.setImageResource(R.drawable.happy);
        }

        else if(scoreE == 75)
        {
            msg.setText("VERY GOOD,WELL DONE!!");
            icon.setImageResource(R.drawable.happy_face);
        }

        else if(scoreE == 100)
        {
            msg.setText("EXCELLENT!!!!!");
            icon.setImageResource(R.drawable.happy1);
        }
        else
        {
            score.setText("Invalid score");
        }

        score.setText("" + scoreE + "%" );


    }


}
