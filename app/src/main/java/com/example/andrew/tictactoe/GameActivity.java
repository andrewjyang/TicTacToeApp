/**
 * Gamectivity is a class where the users actually play Tic Tac Toe.
 **/

package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity {

    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;
    private TicTacToeBoard tictactoe;

    public boolean gameOver = false;

    private String player1Name;
    private String player2Name;

    final private char player1Symbol = 'X';
    final private char player2Symbol = 'O';

    private int turnCounter;

    private Coordinates userCoordinates;

    ImageView currentPlayerImage;
    TextView gameStatus;


    private void initializeTTTBoard(){
        tictactoe = new TicTacToeBoard(3);
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("player1Name");
        player2Name = intent.getStringExtra("player2Name");

        turnCounter = 0;

        userCoordinates = new Coordinates(0,0);

        currentPlayerImage = (ImageView) findViewById(R.id.currentPlayerID);
        currentPlayerImage.setImageDrawable(getDrawable(R.drawable.small_blue_fish));

        gameStatus = (TextView) findViewById(R.id.gameStatusID);
        gameStatus.setText(player1Name + "'s turn");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeTTTBoard();

        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv1.setOnClickListener(new onClickBoard(new Coordinates(0,0), iv1));

        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv2.setOnClickListener(new onClickBoard(new Coordinates(0,1), iv2));

        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv3.setOnClickListener(new onClickBoard(new Coordinates(0,2), iv3));

        iv4 = (ImageView) findViewById(R.id.imageView4);
        iv4.setOnClickListener(new onClickBoard(new Coordinates(1,0), iv4));

        iv5 = (ImageView) findViewById(R.id.imageView5);
        iv5.setOnClickListener(new onClickBoard(new Coordinates(1,1), iv5));

        iv6 = (ImageView) findViewById(R.id.imageView6);
        iv6.setOnClickListener(new onClickBoard(new Coordinates(1,2), iv6));

        iv7 = (ImageView) findViewById(R.id.imageView7);
        iv7.setOnClickListener(new onClickBoard(new Coordinates(2,0), iv7));

        iv8 = (ImageView) findViewById(R.id.imageView8);
        iv8.setOnClickListener(new onClickBoard(new Coordinates(2,1), iv8));

        iv9 = (ImageView) findViewById(R.id.imageView9);
        iv9.setOnClickListener(new onClickBoard(new Coordinates(2,2), iv9));


        Button exitButton = (Button) findViewById(R.id.exitButtonID);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameActivity.this.finish();
            }
        });

        Button playAgainButton = (Button) findViewById(R.id.playAgainButtonID);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameActivity.this.finish();
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                intent.putExtra("player1Name", player1Name);
                intent.putExtra("player2Name", player2Name);
                GameActivity.this.startActivity(intent);
                gameOver = false;
            }
        });
    }

    private class onClickBoard implements View.OnClickListener {

        Coordinates coordinates;
        onClickBoard(Coordinates coordinates, ImageView imageClick){
            this.coordinates = coordinates;
        }

        @Override
        public void onClick(View view) {
            Log.d("ImageView Coordinates: ", Integer.toString(coordinates.getRow()) + ", " + Integer.toString(coordinates.getCol()));

            // check for valid move
            // check if game is over
            if(gameOver){
                Toast.makeText(GameActivity.this, "Invalid Move: The Game is Over!", Toast.LENGTH_LONG).show();
                return;
            }
            // check if repeated move
            if(coordinates.getCheckRepeat()){
                Toast.makeText(GameActivity.this, "Invalid Move: This Cell is Already Filled", Toast.LENGTH_LONG).show();
                return;
            }

            turnCounter++;
            if(turnCounter%2 == 0){
                // update ImageView when clicked
                ((ImageView)view).setImageDrawable(getDrawable(R.drawable.yellow_fish));

                // update text view of current player
                gameStatus = (TextView) findViewById(R.id.gameStatusID);
                gameStatus.setText(player1Name + "'s turn");

                // make move
                tictactoe.makeMove(coordinates, player1Symbol);
                coordinates.setCheckRepeat(true);

                // check winner
                if(tictactoe.isWinner(player1Symbol)){
                    gameStatus.setText("Congrats, " + player2Name + "! You won! Play again?");
                    gameOver = true;
                    return;

                // check if game board is full
                }else if(tictactoe.isFull()){
                    gameStatus.setText("The Tic Tac Toe board is full :(");
                    gameOver = true;
                    return;

                // update currentplayer Image
                }else{
                    currentPlayerImage = (ImageView) findViewById(R.id.currentPlayerID);
                    currentPlayerImage.setImageDrawable(getDrawable(R.drawable.small_blue_fish));
                }

            }
            else {   //turnCounter%2 != 0
                // update ImageView when clicked
                ((ImageView) view).setImageDrawable(getDrawable(R.drawable.blue_fish));


                // update text view of current player
                gameStatus = (TextView) findViewById(R.id.gameStatusID);
                gameStatus.setText(player2Name + "'s turn");

                // make move
                tictactoe.makeMove(coordinates, player2Symbol);
                coordinates.setCheckRepeat(true);

                // check winner
                if (tictactoe.isWinner(player2Symbol)) {
                    gameStatus.setText("Congrats, " + player1Name + "! You won! Play again?");
                    gameOver = true;
                    return;

                // check if gameboard is full
                }else if(tictactoe.isFull()){
                    gameStatus.setText("The Tic Tac Toe board is full :(");
                    gameOver = true;
                    return;

                // update currentplayer Image
                }else{
                    currentPlayerImage = (ImageView) findViewById(R.id.currentPlayerID);
                    currentPlayerImage.setImageDrawable(getDrawable(R.drawable.small_yellow_fish));
                }

            }

        }
    }

}
