package com.example.android.quizappportia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Topics extends AppCompatActivity {

    ImageView imgTopic1;
    ImageView imgTopic2;
    ImageView imgTopic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics);

        imgTopic1 = (ImageView) findViewById(R.id.imgTopic1);
        imgTopic2 = (ImageView) findViewById(R.id.imgTopic2);
        imgTopic3 = (ImageView) findViewById(R.id.imgTopic3);

    }

    public void ShowQues1(View view)
    {
        Intent intent = new Intent(Topics.this,Entertainment.class);
        startActivity(intent);


    }

    public void ShowQues2(View view)
    {
        Intent intent = new Intent(Topics.this,Sports.class);
        startActivity(intent);
    }

    public void ShowQues3(View view)
    {
        Intent intent = new Intent(Topics.this,History.class);
        startActivity(intent);
    }


}
