package com.example.cardquizgame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**created HistoryActivity class, implementing from the AppCompatActivity */
public class HistoryActivity extends AppCompatActivity {

    public static final String GAME_PREFS = "ScoreFile2";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        TextView scoreView = (TextView)findViewById(R.id.textView9);
        SharedPreferences scorePrefs = getSharedPreferences(GAME_PREFS, 0);
        String[] savedScores = scorePrefs.getString("highScores", "").split("\\|");
        StringBuilder scoreBuild = new StringBuilder("");
        for(String score : savedScores){
            scoreBuild.append(score+"\n");
        }
        scoreView.setText(scoreBuild.toString());
    }
}
