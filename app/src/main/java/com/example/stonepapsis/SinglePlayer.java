package com.example.stonepapsis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.stonepapsis.answercheck.answerCheck;

import java.util.Random;

public class SinglePlayer extends AppCompatActivity {
    TextView Score1;
    TextView Score2;
    TextView displayBar;
    ImageView imgDisp1;
    ImageView imgDisp2;
    int choice1;
    int score1=0,score2=0;
    int turn=1;
    int presentRound=0;
    String comp="DumbBot";
    ConstraintLayout constraintLayout;
    public void onClick(View view) {
        if (turn == 1) {
            choice1 = Integer.parseInt(view.getTag().toString());
            turn = 2;
            switch(choice1){
                case 1:imgDisp1.setImageResource(R.drawable.rock);break;
                case 2:imgDisp1.setImageResource(R.drawable.paper);break;
                case 3:imgDisp1.setImageResource(R.drawable.scissors);break;

            }
            displayBar.setText(comp+ "'s chance");
            presentRound++;
            int rand= new Random().nextInt(3)+1;

            switch(rand){
                case 1:imgDisp2.setImageResource(R.drawable.rock);break;
                case 2:imgDisp2.setImageResource(R.drawable.paper);break;
                case 3:imgDisp2.setImageResource(R.drawable.scissors);break;
            }

            String info;
            constraintLayout=findViewById(R.id.constraint);
            info= answerCheck.check(choice1,rand);
            if(info.equals("Player 1 wins")) {
                score1++;
                info=MainActivity.Name1+" wins";
                constraintLayout.setBackgroundColor(Color.GREEN);
            }
            else
            if(info.equals("Player 2 wins")) {
                score2++;
                info = comp+" wins";
                constraintLayout.setBackgroundColor(Color.RED);
            }

            Score1.setText(MainActivity.Name1+"\r\n"+score1);
            Score2.setText(comp+"\r\n"+score2);
            displayBar.setText(info);
            DelayFunction();

        }
    }
    private void DelayFunction() {
       // imgDisp1.animate().alpha(0).setDuration(1800);
        //imgDisp2.animate().alpha(0).setDuration(1800);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               //imgDisp2.animate().alpha(1);
               //imgDisp1.animate().alpha(1);
                imgDisp1.setImageDrawable(null);
                imgDisp2.setImageDrawable(null);
                displayBar.setText(MainActivity.Name1+ "'s chance");
                constraintLayout.setBackgroundResource(R.color.lightpink);
                turn=1;
                if(presentRound==Integer.parseInt(MainActivity.Rounds)){
                    roundEnd();
                }


            }
        }, 2000);
    }
    public void roundEnd(){
        TextView resultText=findViewById(R.id.ResultView);
        if(score1>score2)
            resultText.setText(MainActivity.Name1+"\n WON THE GAME!");
        else {
            if (score2 > score1)
                resultText.setText(comp + "\n WON THE GAME!");
            else
                resultText.setText("DRAW!");
        }
        resultText.setVisibility(View.VISIBLE);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        },2000);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        Score1=findViewById(R.id.Score1);
        Score2=findViewById(R.id.Score2);
        Score1.setText(MainActivity.Name1);
        Score2.setText(comp);
        displayBar=findViewById(R.id.displayBar);
        displayBar.setText(MainActivity.Name1+ "'s chance");
        imgDisp1=findViewById(R.id.imgDisp1);
        imgDisp2=findViewById(R.id.imgDisp2);

    }
}

