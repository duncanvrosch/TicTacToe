package com.example.duncan.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;

    public int Turn = 0;

    Boolean gameWon = false;

    private GameState gamestate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
    }

    public void tileClicked(View view) {

        if (!gameWon) {

            int id = view.getId();
            int row = 0;
            int column = 0;

            Button button = (Button) findViewById(R.id.button3);

            switch (id) {
                case R.id.button3:
                    row = 0;
                    column = 0;
                    break;
                case R.id.button4:
                    row = 0;
                    column = 1;
                    button = (Button) findViewById(R.id.button4);
                    break;
                case R.id.button5:
                    row = 0;
                    column = 2;
                    button = (Button) findViewById(R.id.button5);
                    break;
                case R.id.button6:
                    row = 1;
                    column = 0;
                    button = (Button) findViewById(R.id.button6);
                    break;
                case R.id.button7:
                    row = 1;
                    column = 1;
                    button = (Button) findViewById(R.id.button7);
                    break;
                case R.id.button8:
                    row = 1;
                    column = 2;
                    button = (Button) findViewById(R.id.button8);
                    break;
                case R.id.button9:
                    row = 2;
                    column = 0;
                    button = (Button) findViewById(R.id.button9);
                    break;
                case R.id.button10:
                    row = 2;
                    column = 1;
                    button = (Button) findViewById(R.id.button10);
                    break;
                case R.id.button11:
                    row = 2;
                    column = 2;
                    button = (Button) findViewById(R.id.button11);
                    break;
            }

            TileState state = game.choose(row, column);

            Boolean turnMade = false;

            switch (state) {
                case CROSS:
                    button.setText("X");
                    turnMade = true;
                    Turn = Turn + 1;
                    break;

                case CIRCLE:
                    button.setText("O");
                    turnMade = true;
                    Turn = Turn + 1;
                    break;

                case INVALID:
                    break;
            }

            if (turnMade) {

                gamestate = game.won(Turn);

                // if still in progress, do nothing
                if (gamestate == GameState.IN_PROGRESS) {
                }

                // if player one has won, show message
                else if (gamestate == GameState.PLAYER_ONE) {
                    TextView one = (TextView) findViewById(R.id.One);
                    one.setVisibility(View.VISIBLE);
                    gameWon = true;
                }

                // if player two has won, show message
                else if (gamestate == GameState.PLAYER_TWO) {
                    TextView two = (TextView) findViewById(R.id.Two);
                    two.setVisibility(View.VISIBLE);
                    gameWon = true;
                }

                // if draw, set drawtext to visible
                else if (gamestate == GameState.DRAW) {
                    TextView draw = (TextView) findViewById(R.id.Draw);
                    draw.setVisibility(View.VISIBLE);
                }
            }
        }
    }

        public void resetClicked (View view){

            // starts new game
            game = new Game();

            gameWon = false;

            TextView one = (TextView) findViewById(R.id.One);
            one.setVisibility(View.INVISIBLE);
            TextView two = (TextView) findViewById(R.id.Two);
            two.setVisibility(View.INVISIBLE);
            TextView draw = (TextView) findViewById(R.id.Draw);
            draw.setVisibility(View.INVISIBLE);

            Turn = 0;

            Button button = (Button) findViewById(R.id.button3);
            button.setText("");
            button = (Button) findViewById(R.id.button4);
            button.setText("");
            button = (Button) findViewById(R.id.button5);
            button.setText("");
            button = (Button) findViewById(R.id.button6);
            button.setText("");
            button = (Button) findViewById(R.id.button7);
            button.setText("");
            button = (Button) findViewById(R.id.button8);
            button.setText("");
            button = (Button) findViewById(R.id.button9);
            button.setText("");
            button = (Button) findViewById(R.id.button10);
            button.setText("");
            button = (Button) findViewById(R.id.button11);
            button.setText("");
        }

    }
