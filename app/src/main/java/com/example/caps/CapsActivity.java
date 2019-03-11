package com.example.caps;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        score = 0;
        qNum = 1;
        ask();
    }

    private void ask() {
        String qa[] = game.qa();
        question = qa[0];
        answer = qa[1];
        ((TextView) findViewById(R.id.question)).setText(question);
        ((TextView) findViewById(R.id.score)).setText("SCORE " + score);
        ((TextView) findViewById(R.id.question_num)).setText("Q# " + qNum);
    }

    public void onDone(View v) {
        EditText user_answer = (EditText) findViewById(R.id.answer);
        String user_ans = user_answer.getText().toString();
        user_answer.getText().clear();
        if (user_ans.equalsIgnoreCase(answer))
            score++;
        String log = "Q# " + qNum + ": " + question + "\nYour answer: " + user_ans.toUpperCase() + "\nCorrect answer: " + answer + "\n\n";
        ((TextView) findViewById(R.id.log)).setText(log + ((TextView) findViewById(R.id.log)).getText());
        qNum++;
        if (qNum > 9) {
            ((TextView) findViewById(R.id.question_num)).setText("Game Over!");
            ((Button) findViewById(R.id.submit)).setEnabled(false);
//            finish();
        } else {
            ask();
        }
    }
}
