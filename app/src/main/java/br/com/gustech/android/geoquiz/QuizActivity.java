package br.com.gustech.android.geoquiz;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;*/
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Question.Question;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivty";
    private static final String KEY_INDEX = "index";
    private static final int REQUEST_CODE_CHEAT = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mCheatButton;

    private TextView mQuestionTextView;
    private int mCurrentIndex;
    private boolean mIsCheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, " metodo onCreate(Build) chamado");
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.questiontextView);

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mIsCheater = false;
                updateQuestion();
            }
        });
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (mCurrentIndex == 0){
                    mCurrentIndex = mQuestionBank.hashCode();
                }
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Strat CheatActivity
                //Intent intent = new Intent(QuizActivity.this,CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
                Intent intent = CheatActivity.newIntert(QuizActivity.this,answerIsTrue);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

      mTrueButton = (Button) findViewById(R.id.btrue);
      mTrueButton.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
              checkAnswer(true);
          }
      });
      mFalseButton = (Button) findViewById(R.id.bfalse);
      mFalseButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              checkAnswer(false);
          }
      });
      updateQuestion();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT){
            if (data == null){
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    protected void onSaveInstanceState(Bundle saveIntanceState){
        super.onSaveInstanceState(saveIntanceState);
        Log.i(TAG, "onSaveInstanceState");
        saveIntanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.questao1,false),
            new Question(R.string.questao2,true),
            new Question(R.string.questao3,false),
            new Question(R.string.questao4,false),
            new Question(R.string.questao5,false),
            new Question(R.string.questao6,true)
    };

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmTexteResID();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
        /*int messageResId = (answerIsTrue == userPressedTrue)?
                R.string.correto:
                R.string.incorreto;*/
        int messageResId = 0;
        if (mIsCheater){
            messageResId = R.string.jdgment_toast;
        }else {
            if (userPressedTrue == answerIsTrue){
                messageResId = R.string.correto;
            }else {
                messageResId = R.string.incorreto;
            }
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }


}
