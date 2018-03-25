package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int totalPoints = 0;

    //        Question 1
    boolean isQ1A1;
    boolean isQ1A2;
    boolean isQ1A3;

    //        Question 2
    boolean isQ2A1;
    boolean isQ2A2;

    //        Question 3
    String answerQ3;


    //        Question 4
    boolean isQ4A1;
    boolean isQ4A2;
    boolean isQ4A3;

    //        Question 5
    String answerQ5;


    //        Question 6
    boolean isQ6A1;
    boolean isQ6A2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        Saving values when rotating
        if (savedInstanceState != null) {
            totalPoints = savedInstanceState.getInt("totalPoints");
            isQ1A1 = savedInstanceState.getBoolean("isQ1A1");
            isQ1A2 = savedInstanceState.getBoolean("isQ1A2");
            isQ1A3 = savedInstanceState.getBoolean("isQ1A3");
            isQ2A1 = savedInstanceState.getBoolean("isQ2A1");
            isQ2A2 = savedInstanceState.getBoolean("isQ2A2");
            answerQ3 = savedInstanceState.getString("answerQ3");
            isQ4A1 = savedInstanceState.getBoolean("isQ4A1");
            isQ4A2 = savedInstanceState.getBoolean("isQ4A2");
            isQ4A3 = savedInstanceState.getBoolean("isQ4A3");
            answerQ5 = savedInstanceState.getString("answerQ5");
            isQ6A1 = savedInstanceState.getBoolean("isQ6A1");
            isQ6A2 = savedInstanceState.getBoolean("isQ6A2");
        }

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("totalPoints", totalPoints);
        outState.putBoolean("isQ1A1", isQ1A1);
        outState.putBoolean("isQ1A2", isQ1A2);
        outState.putBoolean("isQ1A3", isQ1A3);
        outState.putBoolean("isQ2A1", isQ2A1);
        outState.putBoolean("isQ2A2", isQ2A2);
        outState.putString("answerQ3", answerQ3);
        outState.putBoolean("isQ4A1", isQ4A1);
        outState.putBoolean("isQ4A2", isQ4A2);
        outState.putBoolean("isQ4A3", isQ4A3);
        outState.putString("answerQ5", answerQ5);
        outState.putBoolean("isQ6A1", isQ6A1);
        outState.putBoolean("isQ6A2", isQ6A2);

    }


    public void submitAnswers(View view) {

        //        Question 1
        isQ1A1 = ((CheckBox) findViewById(R.id.q1a1)).isChecked();
        isQ1A2 = ((CheckBox) findViewById(R.id.q1a2)).isChecked();
        isQ1A3 = ((CheckBox) findViewById(R.id.q1a3)).isChecked();

        //        Question 2
        isQ2A1 = ((RadioButton) findViewById(R.id.q2a1)).isChecked();
        isQ2A2 = ((RadioButton) findViewById(R.id.q2a2)).isChecked();

        //        Question 3
        answerQ3 = ((EditText) findViewById(R.id.q3)).getText().toString();
        String correctAnswerQ3V1 = getText(R.string.correctAnswer3V1).toString();
        String correctAnswerQ3V2 = getText(R.string.correctAnswer3V2).toString();

        //        Question 4
        isQ4A1 = ((CheckBox) findViewById(R.id.q4a1)).isChecked();
        isQ4A2 = ((CheckBox) findViewById(R.id.q4a2)).isChecked();
        isQ4A3 = ((CheckBox) findViewById(R.id.q4a3)).isChecked();

        //        Question 5
        answerQ5 = ((EditText) findViewById(R.id.q5)).getText().toString();
        String correctAnswerQ5 = getText(R.string.correctAnswer5).toString();

        //        Question 6
        isQ6A1 = ((RadioButton) findViewById(R.id.q6a1)).isChecked();
        isQ6A2 = ((RadioButton) findViewById(R.id.q6a2)).isChecked();

//        Points & summary
        totalPoints = pointsQ1(isQ1A1, isQ1A2, isQ1A3) + pointsQ2(isQ2A1, isQ2A2) + pointsQ3(answerQ3, correctAnswerQ3V1, correctAnswerQ3V2);
        totalPoints = totalPoints + pointsQ4(isQ4A1, isQ4A2, isQ4A3) + pointsQ5(answerQ5, correctAnswerQ5) + pointsQ6(isQ6A1, isQ6A2);
        String summary = createSummary(totalPoints);
        displayScore(summary);
    }

    //    Question 1 points
    private int pointsQ1(boolean isQ1A1, boolean isQ1A2, boolean isQ1A3) {
        int pointsQuestion1 = 0;

        if (!isQ1A3 && (isQ1A1 && isQ1A2)) {
            pointsQuestion1 = pointsQuestion1 + 1;
        }
        return pointsQuestion1;
    }

    //    Question 2 points
    private int pointsQ2(boolean isQ2A1, boolean isQ2A2) {
        int pointsQuestion2 = 0;

        if (!isQ2A1 && isQ2A2) {
            pointsQuestion2 = pointsQuestion2 + 1;
        }
        return pointsQuestion2;
    }

    //    Question 3 points
    private int pointsQ3(String answerQ3, String correctAnswerQ3V1, String correctAnswerQ3V2) {
        int pointsQuestion3 = 0;

        if (answerQ3.equals(correctAnswerQ3V1) || answerQ3.equals(correctAnswerQ3V2)) {
            pointsQuestion3 = pointsQuestion3 + 1;
        }
        return pointsQuestion3;
    }

    //    Question 4 points
    private int pointsQ4(boolean isQ4A1, boolean isQ4A2, boolean isQ4A3) {
        int pointsQuestion4 = 0;

        if (!isQ4A2 && (isQ4A1 && isQ4A3)) {
            pointsQuestion4 = pointsQuestion4 + 1;
        }
        return pointsQuestion4;
    }

    //    Question 5 points
    private int pointsQ5(String answerQ5, String correctAnswerQ5) {
        int pointsQuestion5 = 0;

        if (answerQ5.equals(correctAnswerQ5)) {
            pointsQuestion5 = pointsQuestion5 + 1;
        }
        return pointsQuestion5;
    }

    //    Question 6 points
    private int pointsQ6(boolean isQ6A1, boolean isQ6A2) {
        int pointsQuestion6 = 0;

        if (!isQ6A1 && isQ6A2) {
            pointsQuestion6++;
        }
        return pointsQuestion6;
    }

    private String createSummary(int totalPoints) {

        String summary = getString(R.string.summaryThanks);
        summary = summary + "\n" + getString(R.string.summaryScore) +" " + totalPoints + " " + getString(R.string.summaryPoints);

        if (totalPoints < 3) {
            summary = summary + "\n" + getString(R.string.summaryToastOne);
        } else if (totalPoints < 5) {
            summary = summary + "\n" + getString(R.string.summaryToastTwo);
        } else {
            summary = summary + "\n" + getString(R.string.summaryToastThree);
        }

        return summary;
    }

    private void displayScore(String summary) {
        Toast yourScore = Toast.makeText(this, summary, Toast.LENGTH_LONG);
        yourScore.show();
    }


}
