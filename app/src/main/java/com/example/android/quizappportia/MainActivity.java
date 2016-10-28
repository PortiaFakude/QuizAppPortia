package com.example.android.quizappportia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private int status = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView btn = (ImageView) findViewById(R.id.imgStart);
        //btn.setVisibility(1);
       // final ProgressBar prg = (ProgressBar) findViewById(R.id.pgrbr);
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.relative);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Initialize a new instance of progress dialog
                //final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                final ProgressDialog pd = ProgressDialog.show(MainActivity.this,"Quiz loading...","Please wait",true);

                pd.getWindow().setGravity(Gravity.CENTER);

                //Set progress dialog style horizontal
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);


                //Set the progress dialog background color transparent
              // pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                //pd.setIndeterminate(false);

                //Show the progress dialog
                pd.show();

                // Set the progress status zero on each button click
                status  = 0;

                /*
                    A Thread is a concurrent unit of execution. It has its own call stack for
                    methods being invoked, their arguments and local variables. Each application
                    has at least one thread running when it is started, the main thread,
                    in the main ThreadGroup. The runtime keeps its own threads
                    in the system thread group.
                */


                // Start the lengthy operation in a background thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while( status  < 100){
                            // Update the progress status
                            status  +=1;

                            // Try to sleep the thread for 20 milliseconds
                            try{
                                Thread.sleep(50);


                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {


                                    pd.setProgress( status );
                                    // Show the progress on TextView
                                    //tv.setText( status +"");
                                    //If task execution completed
                                    if(status == 100)
                                    {
                                        pd.dismiss();
                                    }
                                    Intent intent = new Intent(MainActivity.this,Topics.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                }).start(); // Start the operation

                // Hide the button
                btn.setVisibility(view.GONE);

            }

        });


    }


}
