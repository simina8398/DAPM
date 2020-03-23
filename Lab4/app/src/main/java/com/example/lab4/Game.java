package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    public void playAgain(View view){
        Intent intent= new Intent(this, Game.class);
        startActivity(intent);
    }


    // 0 = x, 1 = o
    int activePlayer = 0;
    boolean gameIsActive = true;
    // 2 unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        // get the current Image View (counter tag)
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                // setImageResource for counter as x
                counter.setImageResource(R.drawable.lab4_x);
                // change the player's turn
                activePlayer = 1;
            } else {
                // setImageResource for counter as zero
                counter.setImageResource(R.drawable.lab4_zero);
                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = "Player1 -> 0";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Player2 -> x";
                    }
                    // Make a toast with the messaje winner + " has won!"
                    //Toast.makeText(this,winner+" has won!", Toast.LENGTH_LONG).show();
                    findViewById(R.id.ll).setVisibility(View.VISIBLE);
                    TextView text= findViewById(R.id.text1);
                    text.setText(winner+" has won!");

                } else {
                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        // Make a toast with the messaje "It's a draw!"
                        //Toast.makeText(this,"It's a draw!", Toast.LENGTH_LONG).show();
                        findViewById(R.id.ll).setVisibility(View.VISIBLE);
                        TextView text= findViewById(R.id.text1);
                        text.setText("It's a draw!");
                    }
                }
            }
        }
    }
}
