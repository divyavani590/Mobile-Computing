package com.example.cardquizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**created Game5Activity class, implementing from the AppCompatActivity */
public class Game5Activity extends AppCompatActivity {

    TextView correct_5, wrong_5, score;
    RadioButton zero, one, two;
    private SharedPreferences gamePrefs;
    public static final String GAME_PREFS = "ScoreFile2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);
        gamePrefs = getSharedPreferences(GAME_PREFS, 0);

        Button b =(Button) findViewById(R.id.submit);

        correct_5 = (TextView) findViewById(R.id.correct5);
        wrong_5 = (TextView) findViewById(R.id.wrong5);

        score = (TextView) findViewById(R.id.score);

        zero = (RadioButton) findViewById(R.id.question5_1);
        one = (RadioButton) findViewById(R.id.question5_2);
        two = (RadioButton) findViewById(R.id.question5_3);

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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Game5Activity.this);
                alertDialog.setMessage("Are you sure, you want to submit your answer?");
                /**creating two buttons yes and no for alert dialog box*/
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(one.isChecked()){
                                    correct_5.setVisibility(currView.VISIBLE);
                                    correctScore++;
                                }
                                else{
                                    wrong_5.setVisibility(currView.VISIBLE);
                                }
                                /**saving scores and adding the scores to history page*/
                                SharedPreferences.Editor scoreEdit = gamePrefs.edit();
                                DateFormat dateForm = new SimpleDateFormat("dd MMMM yyyy");
                                String dateOutput = dateForm.format(new Date());
                                String scores = gamePrefs.getString("highScores", "");

                                if(scores.length()>0){
                                    String newScore = (""+dateOutput+" - "+correctScore+"|").concat(scores);
                                    scoreEdit.putString("highScores", newScore);
                                    scoreEdit.commit();
                                }
                                else{
                                    scoreEdit.putString("highScores", ""+dateOutput+" - "+correctScore);
                                    scoreEdit.commit();
                                }
                                /*score.append(": "+correctScore+"/5");
                                score.setVisibility(currView.VISIBLE);*/
                                Intent myIntent = new Intent(Game5Activity.this,
                                        ScoreActivity.class);
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
