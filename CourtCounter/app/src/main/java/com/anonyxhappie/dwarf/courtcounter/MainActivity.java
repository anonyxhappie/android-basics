package com.anonyxhappie.dwarf.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int aTotal;
    int bTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayScoreOfA(int score){
        TextView tvTeamAScore = (TextView) findViewById(R.id.tv_teamAScore);
        tvTeamAScore.setText(""+score);
    }

    public void oneOfA(View view){
        aTotal+=1;
        displayScoreOfA(aTotal);
    }

    public void twoOfA(View view){
        aTotal+=2;
        displayScoreOfA(aTotal);
    }

    public void threeOfA(View view){
        aTotal+=3;
        displayScoreOfA(aTotal);
    }

    private void displayScoreOfB(int score){
        TextView tvTeamBScore = (TextView) findViewById(R.id.tv_teamBScore);
        tvTeamBScore.setText(""+score);
    }

    public void oneOfB(View view){
        bTotal+=1;
        displayScoreOfB(bTotal);
    }

    public void twoOfB(View view){
        bTotal+=2;
        displayScoreOfB(bTotal);
    }

    public void threeOfB(View view){
        bTotal+=3;
        displayScoreOfB(bTotal);
    }


    public void reset(View view){
        aTotal = 0;
        bTotal = 0;
        displayScoreOfA(aTotal);
        displayScoreOfB(bTotal);
    }
}
