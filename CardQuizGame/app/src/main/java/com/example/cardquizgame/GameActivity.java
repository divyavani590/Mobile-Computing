package com.example.cardquizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**created GameActivity class, implementing from the AppCompatActivity */
public class GameActivity extends AppCompatActivity {
    EditText q1;
    TextView correct_1,wrong_1, score;
    int correctScore;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Button b =(Button) findViewById(R.id.submit);

        q1 = (EditText)findViewById(R.id.question1);

        correct_1 = (TextView)findViewById(R.id.correct1);
        wrong_1 = (TextView)findViewById(R.id.wrong1);

        score = (TextView)findViewById(R.id.score);

        correctScore = 0;

        b.setOnClickListener(new View.OnClickListener() {
            /**
             * Function to handle Click Event
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                final View currView = view;
                final String FirstQuestion = q1.getText().toString().trim();
                /**creating Alert Dialog box*/
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameActivity.this);
                alertDialog.setMessage("Are you sure, you want to submit your answer?");
                /**creating two buttons yes and no for alert dialog box*/
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            /**
                             * @param dialog
                             * @param which
                             */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean isValid = false;
                        if(FirstQuestion.length()==0)
                        {
                            q1.requestFocus();
                            q1.setError("Should type the answer manually");
                            isValid = false;
                        }
                        if(FirstQuestion.equalsIgnoreCase("Washington")){
                            correct_1.setVisibility((currView.VISIBLE));
                            correctScore++;
                        }
                        else{
                            wrong_1.setVisibility(currView.VISIBLE);
                        }

                        Intent myIntent = new Intent(GameActivity.this,
                                Game2Activity.class);
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
