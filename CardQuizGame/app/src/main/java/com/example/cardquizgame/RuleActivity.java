package com.example.cardquizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        Button b = (Button) findViewById(R.id.button);
        Button b1 = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener()
        {
            /**
             * Function to handle Click Event
             * @param view
             */
            @Override
            public void onClick(View view) {
                // Start NewActivity.class
                Intent myIntent = new Intent(RuleActivity.this,
                        GameActivity.class);

                startActivity(myIntent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener()
        {
            /**
             * Function to handle Click Event
             * @param view
             */
            @Override
            public void onClick(View view) {
                // Start NewActivity.class
                Intent myIntent = new Intent(RuleActivity.this,
                        HistoryActivity.class);

                startActivity(myIntent);
            }
        });
    }
}
