package com.example.duncan.tictactoe;

public class Game {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private Boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public TileState choose(int row, int column) {

        TileState tile = board[row][column];
        switch (tile) {

            case BLANK:

                if (playerOneTurn) {
                    board[row][column] = TileState.CROSS;
                    playerOneTurn = false;
                    return TileState.CROSS;
                }

                else {
                    board[row][column] = TileState.CIRCLE;
                    playerOneTurn = true;
                    return TileState.CIRCLE;
                }

            default:
                return TileState.INVALID;
        }
    }

    public GameState won(int Turn) {

        if (!playerOneTurn) {

            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][0] == TileState.CROSS && board[i][1] == TileState.CROSS && board[i][2] == TileState.CROSS) {
                    return GameState.PLAYER_ONE;
                }
                else if (board[0][i] == TileState.CROSS && board[1][i] == TileState.CROSS && board[2][i] == TileState.CROSS) {
                    return GameState.PLAYER_ONE;
                }
            }

            if (board[0][0] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][2] == TileState.CROSS) {
                return GameState.PLAYER_ONE;
            }
            else if (board[0][2] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][0] == TileState.CROSS) {
                return GameState.PLAYER_ONE;
            }

            if (Turn == 9) {
                return GameState.DRAW;
            }
        }

        else if (playerOneTurn) {

            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][0] == TileState.CIRCLE && board[i][1] == TileState.CIRCLE && board[i][2] == TileState.CIRCLE) {
                    return GameState.PLAYER_TWO;
                }
                if (board[0][i] == TileState.CIRCLE && board[1][i] == TileState.CIRCLE && board[2][i] == TileState.CIRCLE) {
                    return GameState.PLAYER_TWO;
                }
                if (Turn == 9) {
                    return GameState.DRAW;
                }
            }

            if (board[0][0] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][2] == TileState.CIRCLE) {
                return GameState.PLAYER_TWO;
            }
            if (board[0][2] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][0] == TileState.CIRCLE) {
                return GameState.PLAYER_TWO;
            }
            if (Turn == 9) {
                return GameState.DRAW;
            }
        }

        return GameState.IN_PROGRESS;
    }
}