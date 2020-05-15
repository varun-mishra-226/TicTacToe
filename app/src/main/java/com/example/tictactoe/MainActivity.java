package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winComb = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tapPos = Integer.parseInt(counter.getTag().toString());
        if (gameState[tapPos] == 2) {
            gameState[tapPos] = player;
            counter.setTranslationY(-1500);
            if (player == 0) {
                counter.setImageResource(R.drawable.yellow);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                player = 0;
            }
            counter.animate().translationYBy(1500).alpha(1).setDuration(300);
            for (int[] winComb : winComb) {
                if (gameState[winComb[0]] == gameState[winComb[1]] &&
                        gameState[winComb[1]] == gameState[winComb[2]] &&
                        gameState[winComb[0]] != 2) {
                    if (player == 0)
                        Toast.makeText(this, "Game won by: Red",
                                Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "Game won by: Yellow",
                                Toast.LENGTH_SHORT).show();
                    Button playAgain = (Button) findViewById(R.id.btnNewGame);
                    playAgain.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view)
    {
        Button playAgain = (Button)findViewById(R.id.btnNewGame);
        playAgain.setVisibility(View.INVISIBLE);
        GridLayout myGrid = (GridLayout)findViewById(R.id.gridLayout);
        for (int i=0; i<myGrid.getChildCount(); i++)
        {
            ImageView counter = (ImageView) view;
            counter.setImageDrawable(null);
        }
        player = 0;
        for (int i=0; i<9; i++) {
            gameState[i] = 2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
