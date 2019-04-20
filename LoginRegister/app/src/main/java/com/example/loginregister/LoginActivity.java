package com.example.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText Email, Pswd;

    /**
     * Function to handle Create callback
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button b =(Button) findViewById(R.id.button3);

        Email=(EditText)findViewById(R.id.editText);
        Pswd=(EditText)findViewById(R.id.editText2);


        b.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to handle Click Event
             * @param view
             */
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString().trim();
                String pswd = Pswd.getText().toString().trim();

                boolean isValid = false;

                String emailMock = "vasarlad1@montclair.edu";
                String pswdMock = "Divya@123";

                if(email.length()==0)
                {
                    Email.requestFocus();
                    Email.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }

                else if(pswd.length()==0)
                {
                    Pswd.requestFocus();
                    Pswd.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }

                if(email.equalsIgnoreCase(emailMock) && pswd.equalsIgnoreCase(pswdMock)){
                    isValid = true;
                }

                else{
                    Email.requestFocus();
                    Email.setError("Enter correct email");
                    isValid = false;
                }


                if(isValid) {
                    Toast.makeText(LoginActivity.this, "Login Successfully Completed", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(LoginActivity.this,
                            MainActivity.class);
                    startActivity(myIntent);
                }

            }

        });

    }
}
