package com.example.exam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1, editText2, editText3, editText4, editText5;

    /**
     * @param savedInstanceState
     * onCreate method is the default method when Activity is created
     * the main logic get started from here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);

        editText=(EditText)findViewById(R.id.editText);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);

        button.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v
             * onClick method will be started when the button is clicked
             * the logic inside the method get executed once the button is clicked
             */
            @Override
            public void onClick(View v) {

                Boolean isValid = true;
                if(editText.length() == 0)
                {
                    editText.requestFocus();
                    editText.setError("Enter Number");
                    isValid = false;
                }
                if(editText1.length() == 0)
                {
                    editText1.requestFocus();
                    editText1.setError("Enter Number");
                    isValid = false;
                }
                if(editText2.length() == 0)
                {
                    editText2.requestFocus();
                    editText2.setError("Enter Number");
                    isValid = false;
                }
                if(editText3.length() == 0)
                {
                    editText3.requestFocus();
                    editText3.setError("Enter Number");
                    isValid = false;
                }
                if(editText4.length() == 0)
                {
                    editText4.requestFocus();
                    editText4.setError("Enter Number");
                    isValid = false;
                }
                if(editText5.length() == 0)
                {
                    editText5.requestFocus();
                    editText5.setError("Enter Number");
                    isValid = false;
                }

                /**
                 * getting the editText values here
                 */
                float per = Float.parseFloat(editText.getText().toString());
                float a = Float.parseFloat(editText1.getText().toString());
                float b = Float.parseFloat(editText2.getText().toString());
                float c = Float.parseFloat(editText3.getText().toString());
                float d = Float.parseFloat(editText4.getText().toString());
                float f = Float.parseFloat(editText5.getText().toString());

                /**
                 * calculating percentages for each grades
                 */
                final float A = (a / per) * 100;
                final float B = (b / per) * 100;
                final float C= (c / per) * 100;
                final float D = (d / per) * 100;
                final float F = (f / per) * 100;

                /**
                 * Toasting the percentage values
                 */
                Toast myToast  = Toast.makeText(getApplicationContext(), "The percentage of the grade distribution are: \n A: " +A+ " %\n B: " +B+  " %\n C: " +C+  " %\n D: " +D+
                        " %\n F: " +F+ " %", Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                myToast.show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    /**
                     * run method is used for delaying the new activity to start
                     */
                    @Override
                    public void run() {
                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        i.putExtra("A", A);
                        i.putExtra("B", B);
                        i.putExtra("C", C);
                        i.putExtra("D", D);
                        i.putExtra("F", F);
                        startActivity(i);
                    }
                }, 3000);
            }
        });
    }
}
