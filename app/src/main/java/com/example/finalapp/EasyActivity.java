package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class EasyActivity extends AppCompatActivity {

    private static final long COUNTDOWN_IN_MILLIS = 16000;

    private QuestionLibraryEasy mQuestionLibrary = new QuestionLibraryEasy();
    private TextView textViewscore;
    private TextView textViewquestion;
    private EditText editText;
    private Button buttonenter;
    private Button Buttonend;
    private TextView textViewdisplaytimer;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button bdot;
    private Button bclr;

    private CountDownTimer countDownTimer;
    private long timeleftInMillis;

    private String answer;
    private int score = 0;
    private int questionnumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        textViewquestion = (TextView) findViewById(R.id.textviewquestion);
        editText = (EditText) findViewById(R.id.editTextanswer);
        textViewscore = (TextView) findViewById(R.id.textViewscore);
        buttonenter = (Button) findViewById(R.id.buttonenter);
        textViewdisplaytimer = (TextView) findViewById(R.id.textViewtimerdisplay);
        Buttonend = (Button) findViewById(R.id.buttonend);

        b1 = (Button) findViewById(R.id.n1);
        b2 = (Button) findViewById(R.id.n2);
        b3 = (Button) findViewById(R.id.n3);
        b4 = (Button) findViewById(R.id.n4);
        b5 = (Button) findViewById(R.id.n5);
        b6 = (Button) findViewById(R.id.n6);
        b7 = (Button) findViewById(R.id.n7);
        b8 = (Button) findViewById(R.id.n8);
        b9 = (Button) findViewById(R.id.n9);
        b0 = (Button) findViewById(R.id.n0);
        bdot = (Button) findViewById(R.id.ndot);
        bclr = (Button) findViewById(R.id.n1clr1);

        editText.setText("");
        updatequestion();
        timeleftInMillis = COUNTDOWN_IN_MILLIS;
        startcountDown();

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "0"));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "1"));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "2"));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "3"));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "4"));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "5"));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "6"));
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "7"));
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "8"));
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "9"));
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(), "."));
            }
        });
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Nothing to clear", Toast.LENGTH_SHORT).show();
                } else {
                    editText.setText(editText.getText().delete(editText.getText().length() - 1, editText.getText().length()));

                }
            }
        });

    }

    public void Enter(View view) {
        int n = mQuestionLibrary.getQuestioncount();
        if (questionnumber < n) {
            if (editText.getText().toString().equals(answer)) {
                score = score + 10;
                updateScore(score);
                editText.setText("");
                updatequestion();
                countDownTimer.cancel();
                timeleftInMillis = COUNTDOWN_IN_MILLIS;
                startcountDown();
            }
            else if (editText.getText().toString().matches("")) {
                Toast.makeText(getApplicationContext(), "Enter answer first", Toast.LENGTH_SHORT).show();
            }
            else {
                score = score - 5;
                updateScore(score);
                editText.setText("");
                if (score <= 0) {
                    textViewquestion.setText("You lost, Game Over!! :( \n Try again!!\nYour score is: " + score);
                    textViewscore.setText("");
                    buttonenter.setEnabled(false);
                    b0.setEnabled(false);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                    bdot.setEnabled(false);
                    bclr.setEnabled(false);
                    timeleftInMillis = 0;
                    updateCountDownText();
                    countDownTimer.cancel();
                }
                else {
                    updatequestion();
                    countDownTimer.cancel();
                    timeleftInMillis = COUNTDOWN_IN_MILLIS;
                    startcountDown();
                }
            }
        }
        else {
            if (editText.getText().toString().equals(answer)) {
                score = score + 10;
                updateScore(score);
                editText.setText("");
                textViewquestion.setText("");
            }
            else if (editText.getText().toString().matches("")) {
                Toast.makeText(getApplicationContext(), "Enter answer first", Toast.LENGTH_SHORT).show();
            }
            else {
                score = score - 5;
                updateScore(score);
                if (score <= 0) {
                    textViewquestion.setText("You lost, Game Over!! :( \n Try again!!\nYour score is: " + score);
                    editText.setFocusable(false);
                    textViewscore.setText("");
                    buttonenter.setEnabled(false);
                    b0.setEnabled(false);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                    bdot.setEnabled(false);
                    bclr.setEnabled(false);
                    timeleftInMillis = 0;
                    updateCountDownText();
                    countDownTimer.cancel();
                }
                editText.setText("");
                textViewquestion.setText("");
            }
            Toast.makeText(getApplicationContext(), "End of questions", Toast.LENGTH_SHORT).show();
            textViewquestion.setText("Congratulations!! :)\nYou have finished the game with\nScore: " + score);
            editText.setFocusable(false);
            textViewscore.setText("");
            buttonenter.setEnabled(false);
            b0.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            bdot.setEnabled(false);
            bclr.setEnabled(false);
            timeleftInMillis = 0;
            updateCountDownText();
            countDownTimer.cancel();
        }
    }

    public void End(View view) {
        Toast.makeText(getApplicationContext(), "You have ended the game\nYour score is: " + score, Toast.LENGTH_SHORT).show();
        Intent gotoFirst = new Intent(this, MainActivity.class);
        startActivity(gotoFirst);
    }

    private void startcountDown(){
        countDownTimer = new CountDownTimer(timeleftInMillis,1000) {
            @Override
            public void onTick(long l) {
                timeleftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                if(editText.getText().toString().matches("")){
                    score = score - 5;
                    updateScore(score);
                }
                if(questionnumber < mQuestionLibrary.getQuestioncount() && score > 0) {
                    updatequestion();
                    countDownTimer.cancel();
                    timeleftInMillis = COUNTDOWN_IN_MILLIS;
                    startcountDown();
                }
                else{
                    timeleftInMillis = 0;
                    updateCountDownText();
                    textViewquestion.setText("Congratulations!! :)\nYou have finished the game with\nScore: "+score);
                    editText.setFocusable(false);
                    textViewscore.setText("");
                    buttonenter.setEnabled(false);
                    b0.setEnabled(false);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);
                    b8.setEnabled(false);
                    b9.setEnabled(false);
                    bdot.setEnabled(false);
                    bclr.setEnabled(false);
                    timeleftInMillis=0;
                    updateCountDownText();
                    countDownTimer.cancel();
                }
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int) (timeleftInMillis / 1000 ) /60;
        int seconds = (int) (timeleftInMillis/1000) % 60;
        String timeformatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewdisplaytimer.setText(timeformatted);
    }

    public void updatequestion(){
        int question_num = questionnumber + 1;
        textViewquestion.setText("Question : "+ question_num + "\n\n" + mQuestionLibrary.getQuestion(questionnumber));
        answer = mQuestionLibrary.getCorrectAnswer(questionnumber);
        questionnumber++;
    }

    public void updateScore(int point){
        textViewscore.setText("Score : "+ point);
    }
}