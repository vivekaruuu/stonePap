package com.example.stonepapsis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String Name1,Name2,Rounds;
    EditText name1;
    EditText name2;
    EditText rounds;
    int selected1=1,selected2=1;

    public void buttonEffect(View view){
        Button button1=findViewById(R.id.doubleP);
        Button button2=findViewById(R.id.singleP);
        if(view.getTag().equals("5"))
        {
            if(selected2==2){
                button1.getBackground().setColorFilter(0xe0f47521,PorterDuff.Mode.SRC_ATOP);
                button2.getBackground().clearColorFilter();
                selected2=1;

            }else{
                button1.getBackground().setColorFilter(0xe0f47521,PorterDuff.Mode.SRC_ATOP);
            }
            selected1=2;

        }
        if(view.getTag().toString().equals("6")){
            if(selected1==2){
                button2.getBackground().setColorFilter(0xe0f47521,PorterDuff.Mode.SRC_ATOP);
                button1.getBackground().clearColorFilter();
                selected1=1;
            }
            else{
                button2.getBackground().setColorFilter(0xe0f47521,PorterDuff.Mode.SRC_ATOP);
            }
            selected2=2;
        }

    }


    public void onClick(View view) {
        Name1 = name1.getText().toString();
        Name2 = name2.getText().toString();
        Rounds = rounds.getText().toString();

        if (Name1.equals("") || Rounds.equals("0") || Rounds.equals("")) {
            Toast.makeText(this, "Enter all the information ", Toast.LENGTH_SHORT).show();
        } else {
            if(selected2==2) {
                Intent intent = new Intent(getApplicationContext(), SinglePlayer.class);
                startActivity(intent);
            }else {
                if (selected1 == 2) {
                    if(Name2.equals("")){
                        Toast.makeText(this, "Enter all the information ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                        startActivity(intent);
                    }
                }
                else
                    Toast.makeText(this, "select game mode ", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name2=findViewById(R.id.name2);
        name1=findViewById(R.id.name1);
        rounds=findViewById(R.id.rounds);
        name1.setFilters(new InputFilter[] {new InputFilter.LengthFilter(7)});
        name2.setFilters(new InputFilter[] {new InputFilter.LengthFilter(7)});




    }
}
