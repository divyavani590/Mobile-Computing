package com.example.cardquizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**created Game4Activity class, implementing from the AppCompatActivity */
public class Game4Activity extends AppCompatActivity {

    TextView correct_4, wrong_4, score;
    CheckBox Act, In, Ser, CP, Frag;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);

        Button b =(Button) findViewById(R.id.submit);

        correct_4 = (TextView) findViewById(R.id.correct4);
        wrong_4 = (TextView) findViewById(R.id.wrong4);

        score = (TextView) findViewById(R.id.score);

        Act = (CheckBox) findViewById(R.id.question4_1);
        In = (CheckBox) findViewById(R.id.question4_2);
        Ser = (CheckBox) findViewById(R.id.question4_3);
        CP = (CheckBox) findViewById(R.id.question4_4);
        Frag = (CheckBox) findViewById(R.id.question4_5);

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
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Game4Activity.this);
                alertDialog.setMessage("Are you sure, you want to submit your answer?");
                /**creating two buttons yes and no for alert dialog box*/
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Act.isChecked() && In.isChecked() && Ser.isChecked() && CP.isChecked() && Frag.isChecked()){
                                    correct_4.setVisibility(currView.VISIBLE);
                                    correctScore++;
                                }
                                else{
                                    wrong_4.setVisibility(currView.VISIBLE);
                                }
                                Intent myIntent = new Intent(Game4Activity.this,
                                        Game5Activity.class);
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
