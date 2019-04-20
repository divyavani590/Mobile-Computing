package com.example.cardquizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**created Game3Activity class, implementing from the AppCompatActivity */
public class Game3Activity extends AppCompatActivity {

    TextView correct_3, wrong_3, score;
    RadioButton anemo, thermo, baro, hygro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        Button b =(Button) findViewById(R.id.submit);

        correct_3 = (TextView) findViewById(R.id.correct3);
        wrong_3 = (TextView) findViewById(R.id.wrong3);

        score = (TextView) findViewById(R.id.score);

        anemo = (RadioButton) findViewById(R.id.question3_1);
        thermo = (RadioButton) findViewById(R.id.question3_2);
        baro = (RadioButton) findViewById(R.id.question3_3);
        hygro = (RadioButton) findViewById(R.id.question3_4);

        b.setOnClickListener(new View.OnClickListener() {
            Intent intent = getIntent();
            int correctScore = intent.getIntExtra("correctAnsScore",0);
            /**
             * Function to handle Click Event
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                final View currView = view;
                /**creating Alert Dialog box*/
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Game3Activity.this);
                alertDialog.setMessage("Are you sure, you want to submit your answer?");
                /**creating two buttons yes and no for alert dialog box*/
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /**
                     * @param dialog
                     * @param which
                     */
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(thermo.isChecked()){
                                    correct_3.setVisibility(currView.VISIBLE);
                                    correctScore++;
                                }
                                else{
                                    wrong_3.setVisibility(currView.VISIBLE);
                                }


                                Intent myIntent = new Intent(Game3Activity.this,
                                        Game4Activity.class);
                                myIntent.putExtra("correctAnsScore", correctScore);
                                startActivity(myIntent);
                            }
                        }
                );
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        }
                );
                alertDialog.create();
                alertDialog.show();
            }
        });
    }
}
