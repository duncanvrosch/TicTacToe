package com.example.duncan.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;
    Boolean gameWon = false;
    private GameState gamestate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            game = new Game();
        }

        else {

            game = (Game) savedInstanceState.getSerializable("game");

            boolean drawSeen = savedInstanceState.getBoolean("drawSeen");
            if (drawSeen) {
                TextView draw = (TextView) findViewById(R.id.Draw);
                draw.setVisibility(View.VISIBLE);
            }
            boolean oneWon = savedInstanceState.getBoolean("oneWon");
            if (oneWon) {
                TextView pOne = (TextView) findViewById(R.id.One);
                pOne.setVisibility(View.VISIBLE);
            }
            boolean twoWon = savedInstanceState.getBoolean("twoWon");
            if (twoWon) {
                TextView pTwo = (TextView) findViewById(R.id.Two);
                pTwo.setVisibility(View.VISIBLE);
            }

            Button button3 = (Button)findViewById(R.id.button3);
            TileState state = game.board[0][0];
            if (state == TileState.CROSS) {
                button3.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button3.setText("O");
            }
            Button button4 = (Button)findViewById(R.id.button4);
            state = game.board[0][1];
            if (state == TileState.CROSS) {
                button4.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button4.setText("O");
            }
            Button button5 = (Button)findViewById(R.id.button5);
            state = game.board[0][2];
            if (state == TileState.CROSS) {
                button5.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button5.setText("O");
            }
            Button button6 = (Button)findViewById(R.id.button6);
            state = game.board[1][0];
            if (state == TileState.CROSS) {
                button6.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button6.setText("O");
            }
            Button button7 = (Button)findViewById(R.id.button7);
            state = game.board[1][1];
            if (state == TileState.CROSS) {
                button7.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button7.setText("O");
            }
            Button button8 = (Button)findViewById(R.id.button8);
            state = game.board[1][2];
            if (state == TileState.CROSS) {
                button8.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button8.setText("O");
            }
            Button button9 = (Button)findViewById(R.id.button9);
            state = game.board[2][0];
            if (state == TileState.CROSS) {
                button9.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button9.setText("O");
            }
            Button button10 = (Button)findViewById(R.id.button10);
            state = game.board[2][1];
            if (state == TileState.CROSS) {
                button10.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button10.setText("O");
            }
            Button button11 = (Button)findViewById(R.id.button11);
            state = game.board[2][2];
            if (state == TileState.CROSS) {
                button11.setText("X");
            }
            else if (state == TileState.CIRCLE) {
                button11.setText("O");
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("game", game);

        TextView draw = (TextView) findViewById(R.id.Draw);
        boolean drawSeen = draw.isShown();
        outState.putBoolean("drawSeen", drawSeen);
        TextView one = (TextView) findViewById(R.id.One);
        boolean oneWon = one.isShown();
        outState.putBoolean("oneWon", oneWon);
        TextView two = (TextView) findViewById(R.id.Two);
        boolean twoWon = two.isShown();
        outState.putBoolean("twoWon", twoWon);

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
                    break;

                case CIRCLE:
                    button.setText("O");
                    turnMade = true;
                    break;

                case INVALID:
                    TextView start2 = (TextView) findViewById(R.id.Start);
                    start2.setVisibility(View.VISIBLE);
                    break;
            }

            if (turnMade) {

                gamestate = game.won();

                if (gamestate == GameState.IN_PROGRESS) {
                }

                else if (gamestate == GameState.PLAYER_ONE) {
                    TextView one = (TextView) findViewById(R.id.One);
                    one.setVisibility(View.VISIBLE);
                    gameWon = true;
                }

                else if (gamestate == GameState.PLAYER_TWO) {
                    TextView two = (TextView) findViewById(R.id.Two);
                    two.setVisibility(View.VISIBLE);
                    gameWon = true;
                }

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
