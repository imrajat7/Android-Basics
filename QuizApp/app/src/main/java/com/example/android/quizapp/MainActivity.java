package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int answer1 = R.id.question_1_radio_1;
    int answer2 = R.id.question_2_radio_1;
    int answer3 = R.id.question_3_radio_3;
    String answer5 = "manifest";
    String answer6 = "Activity";
    int numberOfCorrectQuestions;
    int numberOfInCorrectQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View v) {

        numberOfCorrectQuestions = 0;
        numberOfInCorrectQuestions = 0;

        if (checkQuestion1()) {
            numberOfCorrectQuestions++;
        } else {
            numberOfInCorrectQuestions++;
        }

        if (checkQuestion2()) {
            numberOfCorrectQuestions++;
        } else {
            numberOfInCorrectQuestions++;
        }

        if (checkQuestion3()) {
            numberOfCorrectQuestions++;
        } else {
            numberOfInCorrectQuestions++;
        }

        if (checkQuestion4()) {
            numberOfCorrectQuestions++;
        } else {
            numberOfInCorrectQuestions++;
        }

        if (checkQuestion5()) {
            numberOfCorrectQuestions++;
        } else {
            numberOfInCorrectQuestions++;
        }

        if (checkQuestion6()) {
            numberOfCorrectQuestions++;
        } else {
            numberOfInCorrectQuestions++;
        }

        Toast.makeText(this, "You got " + numberOfCorrectQuestions + " correct.", Toast.LENGTH_SHORT).show();
    }

    public boolean checkQuestion1() {
        RadioGroup r = (RadioGroup) findViewById(R.id.question_1_radio_group);

        return r.getCheckedRadioButtonId() == answer1;
    }

    public boolean checkQuestion2() {
        RadioGroup r = (RadioGroup) findViewById(R.id.question_2_radio_group);

        return r.getCheckedRadioButtonId() == answer2;
    }

    public boolean checkQuestion3() {
        RadioGroup r = (RadioGroup) findViewById(R.id.question_3_radio_group);

        return r.getCheckedRadioButtonId() == answer3;
    }

    public boolean checkQuestion4() {
        CheckBox two = (CheckBox) findViewById(R.id.question_4_check_2);
        CheckBox four = (CheckBox) findViewById(R.id.question_4_check_4);

        return two.isChecked() && four.isChecked();
    }

    public boolean checkQuestion5() {
        EditText e = (EditText) findViewById(R.id.question_5_edit_text);

        return e.getText().toString().equalsIgnoreCase(answer5);
    }

    public boolean checkQuestion6() {
        EditText e = (EditText) findViewById(R.id.question_6_edit_text);

        return e.getText().toString().equalsIgnoreCase(answer6);
    }
}