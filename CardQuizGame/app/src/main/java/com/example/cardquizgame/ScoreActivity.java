package com.example.cardquizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**created ScoreActivity class, implementing from the AppCompatActivity */
public class ScoreActivity extends AppCompatActivity {

    public static final String GAME_PREFS = "ScoreFile2";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView scoreView = (TextView)findViewById(R.id.textView9);
        SharedPreferences scorePrefs = getSharedPreferences(GAME_PREFS, 0);
        String[] savedScores = scorePrefs.getString("highScores", "").split("\\|");

        scoreView.setText(savedScores[0].split("\\-")[1]);

        Button b = (Button) findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener()
        {
            /**
             * Function to handle Click Event
             * @param view
             */
            @Override
            public void onClick(View view) {
                // Start NewActivity.class
                Intent myIntent = new Intent(ScoreActivity.this,
                        HistoryActivity.class);

                startActivity(myIntent);
            }
        });
    }
}
