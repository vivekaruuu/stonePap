package com.example.stonepapsis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.stonepapsis.answercheck.answerCheck;


public class GameActivity extends AppCompatActivity {
    TextView Score1;
    TextView Score2;
    TextView displayBar;
    ImageView imgDisp1;
    ImageView imgDisp2;
    int choice1,choice2;
    int score1=0,score2=0;
    int turn=1;
    int presentRound=0;
    ConstraintLayout constraintLayout;
    public void onClick(View view) {
        if (turn == 1) {
            choice1 = Integer.parseInt(view.getTag().toString());
            turn = 2;
            displayBar.setText(MainActivity.Name2+ "'s chance");
        }
        else
        if (turn == 2) {
            presentRound++;
            choice2 = Integer.parseInt(view.getTag().toString());
            turn=1;
            switch(choice1){
                case 1:imgDisp1.setImageResource(R.drawable.rock);break;
                case 2:imgDisp1.setImageResource(R.drawable.paper);break;
                case 3:imgDisp1.setImageResource(R.drawable.scissors);break;

            }
            switch(choice2){
                case 1:imgDisp2.setImageResource(R.drawable.rock);break;
                case 2:imgDisp2.setImageResource(R.drawable.paper);break;
                case 3:imgDisp2.setImageResource(R.drawable.scissors);break;
            }

            String info;
            constraintLayout=findViewById(R.id.constraint);
            info=answerCheck.check(choice1,choice2);
            if(info.equals("Player 1 wins")) {
                score1++;
                info=MainActivity.Name1+" won";
                constraintLayout.setBackgroundColor(Color.RED);
            }
            else
            if(info.equals("Player 2 wins")) {
                score2++;
                info=MainActivity.Name2+" won";
                constraintLayout.setBackgroundColor(Color.BLUE);
            }
            Score1.setText(MainActivity.Name1+"\r\n"+score1);
            Score2.setText(MainActivity.Name2+"\r\n"+score2);
            displayBar.setText(info);
            DelayFunction();

        }
    }
    private void DelayFunction() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgDisp1.setImageDrawable(null);
                imgDisp2.setImageDrawable(null);
                displayBar.setText(MainActivity.Name1+ "'s chance");
                constraintLayout.setBackgroundResource(R.color.lightpink);
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
        else
            resultText.setText(MainActivity.Name2+"\n WON THE GAME!");
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
        Score2.setText(MainActivity.Name2);
        displayBar=findViewById(R.id.displayBar);
        displayBar.setText(MainActivity.Name1+ "'s chance");
        imgDisp1=findViewById(R.id.imgDisp1);
        imgDisp2=findViewById(R.id.imgDisp2);

    }
}
