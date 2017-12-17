/**
 * This app for two users to play Tic Tac Toe. Player 1 is represented by a blue fish and
 *  Player 2 is represented by a yellow fish. The first player to get 3 fish in a row vertically,
 *  horizontally, or diagonally wins.
 * CPSC 312-02, Fall 2017
 * Programming Assignment: 4
 * Sources: Stack Overflow
 *  yellow fish image: <div>Icons made by <a href="https://www.flaticon.com/authors/twitter" title="Twitter">Twitter</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
 *  blue fish image: <div>Icons made by <a href="https://www.flaticon.com/authors/twitter" title="Twitter">Twitter</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
 *
 * @author Andrew Yang
 * @version v1.0 October 16, 2017
 *
 *
 **/

/**
 * WelcomeActivity is a class that shows the rules of the game, gets names for players one and two,
 *  and advances the users to GameActivity.
 **/

package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button playButton = (Button) findViewById(R.id.playButtonID);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText player1EditText = (EditText) findViewById(R.id.player1InputID);
                String player1Name = player1EditText.getText().toString();

                EditText player2EditText = (EditText) findViewById(R.id.player2InputID);
                String player2Name = player2EditText.getText().toString();

                Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
                intent.putExtra("player1Name", player1Name);
                intent.putExtra("player2Name", player2Name);

                WelcomeActivity.this.startActivity(intent);
            }
        });
    }

}
