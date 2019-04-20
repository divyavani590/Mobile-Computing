package com.example.cardquizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    EditText FirstEditText,LastEditText, DateEditText, PswdEditText, EmailEditText;

    /**
     * Function to check if Date is valid
     * @param date
     * @return
     */
    public boolean isValidDate(String date)
    {
        // set date format, this can be changed to whatever format
        // you want, MM-dd-yyyy, MM.dd.yyyy, dd.MM.yyyy etc.
        // you can read more about it here:
        // http://java.sun.com/j2se/1.4.2/docs/api/index.html
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String errorMessage = "";
        // declare and initialize testDate variable, this is what will hold
        // our converted string

        Date testDate = null;

        // we will now try to parse the string into date form
        try
        {
            testDate = sdf.parse(date);
        }

        // if the format of the string provided doesn't match the format we
        // declared in SimpleDateFormat() we will get an exception

        catch (ParseException e)
        {
            errorMessage = "the date you provided is in an invalid date" +
                    " format.";
            return false;
        }

        // dateformat.parse will accept any date as long as it's in the format
        // you defined, it simply rolls dates over, for example, december 32
        // becomes jan 1 and december 0 becomes november 30
        // This statement will make sure that once the string
        // has been checked for proper formatting that the date is still the
        // date that was entered, if it's not, we assume that the date is invalid

        if (!sdf.format(testDate).equals(date))
        {
            errorMessage = "The date that you provided is invalid.";
            return false;
        }

        // if we make it to here without getting an error it is assumed that
        // the date was a valid one and that it's in the proper format

        return true;

    } // end isValidDate

    /**
     * Function to handle Create callback
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button b =(Button) findViewById(R.id.register1);

        FirstEditText=(EditText)findViewById(R.id.editText);
        LastEditText=(EditText)findViewById(R.id.editText2);
        DateEditText=(EditText)findViewById(R.id.editText5);
        EmailEditText=(EditText)findViewById(R.id.editText4);
        PswdEditText=(EditText)findViewById(R.id.editText3);

        b.setOnClickListener(new View.OnClickListener() {
            /**
             * Function to handle Click Event
             * @param view
             */
            @Override

            public void onClick(View view) {

                final String First = FirstEditText.getText().toString().trim();
                final String Last = LastEditText.getText().toString().trim();
                final String Dob = DateEditText.getText().toString().trim();
                final String Email = EmailEditText.getText().toString().trim();
                final String Pwd = PswdEditText.getText().toString().trim();

                Boolean isValid = true;

                //if the firstName editText is empty it will through an error
                if(First.length()==0)
                {
                    FirstEditText.requestFocus();
                    FirstEditText.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }
                //if the firstName editText characters are less than 3 or more than 30
                //the error message is shown
                else if(First.length()<3 || First.length()>30){
                    FirstEditText.requestFocus();
                    FirstEditText.setError("First Name should have more than 2 characters and less than 30 characters");
                    isValid = false;
                }
                //if the firstName has other than a-z or A-Z characters
                //the error message is shown
                else if(!First.matches("[a-zA-Z ]+"))
                {
                    FirstEditText.requestFocus();
                    FirstEditText.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    isValid = false;
                }

                //if the LastName editText is empty it will through an error
                if(Last.length()==0)
                {
                    LastEditText.requestFocus();
                    LastEditText.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }
                //if the lastName editText characters are more than 30
                //the error message is shown
                else if(Last.length()>30){
                    FirstEditText.requestFocus();
                    FirstEditText.setError("First Name should not be more than 30 characters");
                    isValid = false;
                }
                //if the lastName editText has other than a-z or A-Z characters
                //the error message is shown
                else if(!Last.matches("[a-zA-Z ]+"))
                {
                    FirstEditText.requestFocus();
                    FirstEditText.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    isValid = false;
                }

                //if the DateOfBirth editText is empty it will through an error
                if(Dob.length()==0)
                {
                    DateEditText.requestFocus();
                    DateEditText.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }
                //if the DateOfBirth editText format is other than MM/DD/YYYY
                //the error message is shown
                else if(!isValidDate(Dob))
                {
                    DateEditText.requestFocus();
                    DateEditText.setError("DOB Should be in MM/DD/YYYY format");
                    isValid = false;
                }

                //if the EMail editText is empty it will through an error
                if(Email.length()==0)
                {
                    EmailEditText.requestFocus();
                    EmailEditText.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }
                //the email editText should be in a email format form
                //otherwise the error message is shown
                else if(!Email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                {
                    EmailEditText.requestFocus();
                    EmailEditText.setError("ENTER ONLY IN EMAIL FORMAT");
                    isValid = false;
                }

                //if the Password editText is empty it will through an error
                if(Pwd.length()==0)
                {
                    PswdEditText.requestFocus();
                    PswdEditText.setError("FIELD CANNOT BE EMPTY");
                    isValid = false;
                }
                //the password should contain one uppercase character, one number, one special character
                //otherwise the error message is shown
                else if(!Pwd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{4,}$"))
                {
                    PswdEditText.requestFocus();
                    PswdEditText.setError("Password must contain Minimum eight characters, at least one lower, one upper, one special char and one number");
                    isValid = false;
                }

                //if all the above conditions satisfy the page will redirect to main page
                if(isValid) {
                    Toast.makeText(RegisterActivity.this, "Registration Successfully Completed", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(RegisterActivity.this,
                            MainActivity.class);
                    startActivity(myIntent);
                }

            }
        });

    }

}
