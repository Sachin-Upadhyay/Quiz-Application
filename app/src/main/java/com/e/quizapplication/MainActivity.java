package com.e.quizapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button answer1,answer2,answer3,answer4,submit,back,sound;
    TextView score,question;
    private Questions mQuestions=new Questions();
    private String mAnswer;
    private int mScore =0;
    MediaPlayer mp,mp1,mp2;
    private int mQuestion_number=1;
    //private int mQuestionsLenght=mQuestions.mQuestions.length;
    int a=0;
    int array[]={0,0,0,0,0,0,0,0,0,0,0};
    //Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //r=new Random();
        answer1=(Button)findViewById(R.id.answer1);
        answer2=(Button)findViewById(R.id.answer2);
        answer3=(Button)findViewById(R.id.answer3);
        answer4=(Button)findViewById(R.id.answer4);
        score=(TextView)findViewById(R.id.score);
        question=(TextView)findViewById(R.id.question);
        submit=(Button)findViewById(R.id.submit);
        back=(Button)findViewById(R.id.back);
        sound=(Button)findViewById(R.id.sound);
        mp=MediaPlayer.create(this,R.raw.sound);
        mp1=MediaPlayer.create(this,R.raw.sound1);
        mp2=MediaPlayer.create(this,R.raw.sound2);

        score.setText("Score"+mScore);

        updateQuestion(a);


        submit.setEnabled(false);
        mp2.start();
        //updateQuestion(r.nextInt(mQuestionsLenght));


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array[a]=1;

                if(answer1.getText()==mAnswer){

                    mp.start();
                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    mScore++;
                    score.setText("Score"+mScore);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    submit.setEnabled(true);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);

                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer1.setBackgroundColor(getResources().getColor(R.color.white));
                                answer1.setEnabled(true);
                                answer2.setEnabled(true);
                                answer3.setEnabled(true);
                                answer4.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                answer1.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setBackgroundColor(getResources().getColor(R.color.white));
                                if(a>0){
                                    a--;
                                    mQuestion_number--;
                                    updateQuestion(a);
                                    if(answer1.getText()==mAnswer){
                                        answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                    }
                                    else if(answer2.getText()==mAnswer){
                                        answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                    }
                                    else if(answer3.getText()==mAnswer){
                                        answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                    }
                                    else
                                    {
                                        answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                    }
                                    answer1.setEnabled(false);
                                    answer2.setEnabled(false);
                                    answer3.setEnabled(false);
                                    answer4.setEnabled(false);

                                    submit.setEnabled(true);
                                }


                            }
                        });



                }
                else
                {
                    array[a]=1;
                    submit.setEnabled(true);
                    answer1.setBackgroundColor(getResources().getColor(R.color.Red));
                    mp1.start();
                    if(answer2.getText()==mAnswer) {
                        answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else if(answer3.getText() == mAnswer)
                    {
                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                    else {
                        answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer1.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setBackgroundColor(getResources().getColor(R.color.white));
                                answer1.setEnabled(true);
                                answer2.setEnabled(true);
                                answer3.setEnabled(true);
                                answer4.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);

                            }

                             }
                    });




                }
                mQuestion_number++;
                if (mQuestion_number==6){
                    mp2.stop();
                    if(mScore==5){
                        win();
                    }
                    else {
                        gameover();
                    }
                }
            }
        });

submit.setEnabled(false);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array[a]=1;

                if(answer2.getText()==mAnswer){
                    mp.start();
                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    mScore++;
                    score.setText("Score"+mScore);
                    answer2.setEnabled(false);

                    answer1.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    submit.setEnabled(true);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer2.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setEnabled(true);
                                answer1.setEnabled(true);
                                answer3.setEnabled(true);
                                answer4.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);


                            }

                            }
                    });
                }
                else
                {
                    array[a]=1;
                    submit.setEnabled(true);
                    answer2.setBackgroundColor(getResources().getColor(R.color.Red));
                    mp1.start();
                    if(answer1.getText()==mAnswer) {
                        answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else if(answer3.getText() == mAnswer)
                    {
                        answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else {
                        answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    answer2.setEnabled(false);
                    answer1.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer1.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setEnabled(true);
                                answer1.setEnabled(true);
                                answer3.setEnabled(true);
                                answer4.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);

                            }

                            }
                    });


                }
                mQuestion_number++;
                if (mQuestion_number==6){
                    mp2.stop();
                    if(mScore==5){
                        win();
                    }
                    else {
                        gameover();
                    }
                }
            }
        });

       submit.setEnabled(false);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array[a]=1;

                if(answer3.getText()==mAnswer){
                    mp.start();
                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    mScore++;
                    score.setText("Score"+mScore);
                    answer3.setEnabled(false);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer4.setEnabled(false);
                    submit.setEnabled(true);

                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer3.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setEnabled(true);
                                answer1.setEnabled(true);
                                answer2.setEnabled(true);
                                answer4.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);

                            }

                              }
                    });
                }
                else
                {
                    array[a]=1;
                    submit.setEnabled(true);
                    answer3.setBackgroundColor(getResources().getColor(R.color.Red));
                    mp1.start();
                    if(answer1.getText()==mAnswer) {
                        answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else if(answer2.getText() == mAnswer)
                    {
                        answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else {
                        answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    answer3.setEnabled(false);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer4.setEnabled(false);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer1.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setEnabled(true);
                                answer1.setEnabled(true);
                                answer2.setEnabled(true);
                                answer4.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }

                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);

                            }

                              }
                    });


                }
                mQuestion_number++;
                if (mQuestion_number==6){
                    mp2.stop();
                    if(mScore==5){
                        win();
                    }
                    else {
                        gameover();
                    }
                }
            }
        });

        submit.setEnabled(false);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array[a]=1;

                if(answer4.getText()==mAnswer){
                    mp.start();
                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    mScore++;
                    score.setText("Score"+mScore);
                    answer4.setEnabled(false);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    submit.setEnabled(true);

                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer4.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setEnabled(true);
                                answer1.setEnabled(true);
                                answer2.setEnabled(true);
                                answer3.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);

                            }

                            }
                    });
                }
                else
                {
                    array[a]=1;
                    submit.setEnabled(true);
                    answer4.setBackgroundColor(getResources().getColor(R.color.Red));
                    mp1.start();
                    if(answer1.getText()==mAnswer) {
                        answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else if(answer2.getText() == mAnswer)
                    {
                        answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    else {
                        answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    answer4.setEnabled(false);
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            a++;
                            updateQuestion(a);
                            if(array[a]==0) {
                                submit.setEnabled(false);
                                //updateQuestion(r.nextInt(mQuestionsLenght));
                                answer1.setBackgroundColor(getResources().getColor(R.color.white));
                                answer2.setBackgroundColor(getResources().getColor(R.color.white));
                                answer3.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setBackgroundColor(getResources().getColor(R.color.white));
                                answer4.setEnabled(true);
                                answer1.setEnabled(true);
                                answer2.setEnabled(true);
                                answer3.setEnabled(true);
                            }
                            else
                            {
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);
                            }
                        }
                    });
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            answer1.setBackgroundColor(getResources().getColor(R.color.white));
                            answer2.setBackgroundColor(getResources().getColor(R.color.white));
                            answer3.setBackgroundColor(getResources().getColor(R.color.white));
                            answer4.setBackgroundColor(getResources().getColor(R.color.white));
                            if(a>0){
                                a--;
                                mQuestion_number--;
                                updateQuestion(a);
                                if(answer1.getText()==mAnswer){
                                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer2.getText()==mAnswer){
                                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else if(answer3.getText()==mAnswer){
                                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                else
                                {
                                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                }
                                answer1.setEnabled(false);
                                answer2.setEnabled(false);
                                answer3.setEnabled(false);
                                answer4.setEnabled(false);

                                submit.setEnabled(true);

                            }

                             }
                    });


                }
                mQuestion_number++;
                if (mQuestion_number==6){
                    mp2.stop();
                    if(mScore==5){
                        win();
                    }
                    else {
                        gameover();
                    }
                }
            }
        });


        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.stop();
            }
        });


    }
    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer =mQuestions.getCorrectAnswer(num);


    }

    private void gameover(){
        AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("You Lose! Your score is "+mScore+"points.")
                           .setCancelable(false)
                            .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                }
                            })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();

    }
    private void win(){
        AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Congratulations you Won")
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();

    }


}
