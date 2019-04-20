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

/**created Game2Activity class, implementing from the AppCompatActivity */
public class Game2Activity extends AppCompatActivity {
    TextView correct_2, wrong_2, score;
    CheckBox NC, Paris, NJ, India;
    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        Button b = (Button) findViewById(R.id.submit);

        correct_2 = (TextView) findViewById(R.id.correct2);
        wrong_2 = (TextView) findViewById(R.id.wrong2);

        score = (TextView) findViewById(R.id.score);

        NC = (CheckBox) findViewById(R.id.question2_1);
        Paris = (CheckBox) findViewById(R.id.question2_2);
        NJ = (CheckBox) findViewById(R.id.question2_3);
        India = (CheckBox) findViewById(R.id.question2_4);

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
                final View CurrView = view;
                /**creating Alert Dialog box*/
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Game2Activity.this);
                alertDialog.setMessage("Are you sure, you want to submit your answer?");
                /**creating two buttons yes and no for alert dialog box*/
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /**
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(NC.isChecked() && NJ.isChecked()){
                            correct_2.setVisibility(CurrView.VISIBLE);
                            correctScore++;
                        }
                        else{
                            wrong_2.setVisibility(CurrView.VISIBLE);
                        }
                        Intent myIntent = new Intent(Game2Activity.this,
                                Game3Activity.class);
                        myIntent.putExtra("correctAnsScore", correctScore);
                        startActivity(myIntent);
                            }
                        }
                );
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    /**
                     * @param dialog
                     * @param which
                     */
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
