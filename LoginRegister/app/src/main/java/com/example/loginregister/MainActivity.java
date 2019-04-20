package com.example.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    /**
     * Function to handle Create callback
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener()
        {
            /**
             * Function to handle Click Event
             * @param view
             */
            @Override
            public void onClick(View view) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        RegisterActivity.class);

                startActivity(myIntent);
            }
        });


        Button button = (Button) findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Function to handle Click Event
             * @param view
             */
            @Override
            public void onClick(View view) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        LoginActivity.class);

                startActivity(myIntent);
            }
        });



    }
}
