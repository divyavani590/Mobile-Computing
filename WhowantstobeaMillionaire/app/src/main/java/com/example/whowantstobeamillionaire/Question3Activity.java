package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
/** Created QuestionActivity for 3rd question*/
public class Question3Activity extends AppCompatActivity {

    RadioButton option1, option2, option3, option4;
    TextView score;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        /** declaring buttons,text view, radio buttons*/
        score = (TextView)findViewById(R.id.textView3);

        score.setText("You Earned:$200");

        Button button1 = (Button) findViewById(R.id.button3);

        option1 = (RadioButton) findViewById(R.id.question3_1);
        option2 = (RadioButton) findViewById(R.id.question3_2);
        option3 = (RadioButton) findViewById(R.id.question3_3);
        option4 = (RadioButton) findViewById(R.id.question3_4);

        button1.setOnClickListener(new View.OnClickListener() {
            /**
             * Function to handle Click Event
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                // Start NewActivity.class

                Bundle bundle = getIntent().getExtras();
                int value = bundle.getInt("score");
                /** if correct answer is checked, the page will go to next question page by updating score*/
                if (option1.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "This is the correct answer \n You Earned:$" + value,
                            Toast.LENGTH_LONG);
                    score.setText("You Earned:$"+ value);
                    toast.show();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent myIntent = new Intent(Question3Activity.this,
                                    Question4Activity.class);
                            myIntent.putExtra("score",500);
                            startActivity(myIntent);
                        }
                    }, 3000);
                }
                /**if the wrong answer is checked, it will go to lost page by keeping the same score*/
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "This is the incorrect answer \n You Earned:$200" ,
                            Toast.LENGTH_LONG);
                    toast.show();
                    Intent myIntent = new Intent(Question3Activity.this,
                            LostActivity.class);

                    startActivity(myIntent);
                }
            }
        });
    }
}