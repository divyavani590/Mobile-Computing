package com.example.drivetomsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

// classes needed to launch navigation UI
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to handle Click Event
             *
             * @param view
             */
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this,
                        MapActivity.class);

                startActivity(myIntent);

            }
        });
    }
}
