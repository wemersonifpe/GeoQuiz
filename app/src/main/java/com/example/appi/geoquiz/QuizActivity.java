package com.example.appi.geoquiz;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {


    private Button btrue;
    private Button bfalse;
    private Button bNext;
    private Button bprev;

    private TextView questionTextview;
    private int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextview = (TextView) findViewById(R.id.questiontextView);

        int question = mQuestionBank[mCurrentIndex].getTextResId();
        questionTextview.setText(question);

        bNext = (Button) findViewById(R.id.bnext);
        bNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int idQuestion = mQuestionBank[mCurrentIndex].getTextResId();
                questionTextview.setText(idQuestion);
            }



        });
        bprev = (Button) findViewById(R.id.bprev);
        bprev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int idQuestion = mQuestionBank[mCurrentIndex].getTextResId();
                questionTextview.setText(idQuestion);
            }



        });

        btrue = (Button) findViewById(R.id.btrue);
btrue.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){
        checkAnswer(true);
    }
});
        bfalse = (Button) findViewById(R.id.bfalse);
        bfalse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkAnswer(false);
            }
        });
    }
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.questao1, true),
            new Question(R.string.questao2, false),
            new Question(R.string.questao3, true),

    };

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        questionTextview.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isBtrue();
        int messageResId = (answerIsTrue == userPressedTrue) ?
                R.string.correto :
                R.string.incorreto;
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }
}