package com.example.gpa_vasarlad1_calculator;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText FirstEditText,SecondEditText, ThirdEditText, FourthEditText, FifthEditText;
    TextView Output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);

        FirstEditText=(EditText)findViewById(R.id.editText);
        SecondEditText=(EditText)findViewById(R.id.editText2);
        FifthEditText=(EditText)findViewById(R.id.editText5);
        FourthEditText=(EditText)findViewById(R.id.editText4);
        ThirdEditText=(EditText)findViewById(R.id.editText3);

        Output=(TextView) findViewById(R.id.output);

        FirstEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(button.getText() == "Clear Form")
                    button.setText("Compute GPA");
            }
            public void afterTextChanged(Editable editable) { }
            public void beforeTextChanged(CharSequence cs, int i, int j, int k) { }
        });

        SecondEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(button.getText() == "Clear Form")
                    button.setText("Compute GPA");
            }
            public void afterTextChanged(Editable editable) { }
            public void beforeTextChanged(CharSequence cs, int i, int j, int k) { }
        });

        ThirdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(button.getText() == "Clear Form")
                    button.setText("Compute GPA");
            }
            public void afterTextChanged(Editable editable) { }
            public void beforeTextChanged(CharSequence cs, int i, int j, int k) { }
        });

        FourthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(button.getText() == "Clear Form")
                    button.setText("Compute GPA");
            }
            public void afterTextChanged(Editable editable) { }
            public void beforeTextChanged(CharSequence cs, int i, int j, int k) { }
        });

        FirstEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(button.getText() == "Clear Form")
                    button.setText("Compute GPA");
            }
            public void afterTextChanged(Editable editable) { }
            public void beforeTextChanged(CharSequence cs, int i, int j, int k) { }
        });

        FifthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(button.getText() == "Clear Form")
                    button.setText("Compute GPA");
            }
            public void afterTextChanged(Editable editable) { }
            public void beforeTextChanged(CharSequence cs, int i, int j, int k) { }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String grade = "";
                Double gradeValue;

                ConstraintLayout layout =  findViewById(R.id.parentLayout);
                String First = FirstEditText.getText().toString().trim();
                String Second = SecondEditText.getText().toString().trim();
                String Third = ThirdEditText.getText().toString().trim();
                String Fourth = FourthEditText.getText().toString().trim();
                String Fifth = FifthEditText.getText().toString().trim();

                // Start NewActivity.class

                if(button.getText() == "Clear Form"){
                    FirstEditText.setText("");
                    SecondEditText.setText("");
                    ThirdEditText.setText("");
                    FourthEditText.setText("");
                    FifthEditText.setText("");
                    Output.setText("");
                    layout.setBackgroundColor(Color.TRANSPARENT);
                    return;
                }

                Boolean isValid = true;
                if(FirstEditText.length() == 0)
                {
                    FirstEditText.requestFocus();
                    FirstEditText.setError("Enter Grade");
                    isValid = false;
                }
                else if(!First.matches("[A-C][+-]?|F")){
                    FirstEditText.requestFocus();
                    FirstEditText.setError("ENTER ONLY A,A-,B+,B,B-,C,F");
                    isValid = false;
                }
                if(SecondEditText.length() == 0)
                {
                    SecondEditText.requestFocus();
                    SecondEditText.setError("Enter Grade");
                    isValid = false;
                }
                else if(!Second.matches("[A-C][+-]?|F")){
                    SecondEditText.requestFocus();
                    SecondEditText.setError("ENTER ONLY A,A-,B+,B,B-,C,F");
                    isValid = false;
                }
                if(ThirdEditText.length() == 0)
                {
                    ThirdEditText.requestFocus();
                    ThirdEditText.setError("Enter Grade");
                    isValid = false;
                }
                else if(!Third.matches("[A-C][+-]?|F")){
                    ThirdEditText.requestFocus();
                    ThirdEditText.setError("ENTER ONLY A,A-,B+,B,B-,C,F");
                    isValid = false;
                }
                if(FourthEditText.length() == 0)
                {
                    FourthEditText.requestFocus();
                    FourthEditText.setError("Enter Grade");
                    isValid = false;
                }
                else if(!Fourth.matches("[A-C][+-]?|F")){
                    FourthEditText.requestFocus();
                    FourthEditText.setError("ENTER ONLY A,A-,B+,B,B-,C,F");
                    isValid = false;
                }
                if(FifthEditText.length() == 0)
                {
                    FifthEditText.requestFocus();
                    FifthEditText.setError("Enter Grade");
                    isValid = false;
                }
                else if(!Fifth.matches("[A-C][+-]?|F")){
                    FifthEditText.requestFocus();
                    FifthEditText.setError("ENTER ONLY A,A-,B+,B,B-,C,F");
                    isValid = false;
                }

                if(isValid == false){
                    return;
                }
                JSONObject obj = new JSONObject();
                int percentage  = 0;
                try {

                    obj.put("A", 95);
                    obj.put("A-", 88);
                    obj.put("B+", 82);
                    obj.put("B", 77);
                    obj.put("B-", 72);
                    obj.put("C", 50);

                    int sum = obj.getInt(First) + obj.getInt(Second) + obj.getInt(Third)+
                            obj.getInt(Fourth) + obj.getInt(Fifth);

                    percentage = sum/5;
                    System.out.print(percentage);

                } catch (JSONException e) {
                    // Do something to recover ... or kill the app.
                }

                if (percentage >= 90) {
                    gradeValue = 4.00;
                    grade = "A";
                } else if (percentage >= 85 && percentage <= 89) {
                    gradeValue = 3.67;
                    grade = "A-";
                } else if (percentage >= 80 && percentage <= 84) {
                    gradeValue = 3.33;
                    grade = "B+";
                } else if (percentage >= 75 && percentage <= 79) {
                    gradeValue = 3.00;
                    grade = "B";
                } else if (percentage >= 70 && percentage <= 74) {
                    gradeValue = 2.67;
                    grade = "B-";
                } else if (percentage >= 60 && percentage <= 69) {
                    gradeValue = 2.33;
                    grade = "C+";
                } else if (percentage >= 50 && percentage <= 59) {
                    gradeValue = 2.00;
                    grade = "C";
                }
                else if (percentage < 50) {
                    gradeValue = 0.00;
                    grade = "F";
                }
                Output.setText(grade);

                if(percentage < 60)
                {
                    layout.setBackgroundColor(Color.RED);
                }
                else if(percentage < 80 && percentage >= 60)
                {
                    layout.setBackgroundColor(Color.YELLOW);
                }
                else
                {
                    layout.setBackgroundColor(Color.GREEN);
                }

                button.setText("Clear Form");

            }
        });



    }
}
