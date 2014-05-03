package com.twu.tictactoe;

import java.io.PrintStream;

public class GameWinner {

    private PrintStream printStream;

    public GameWinner(PrintStream printStream){
        this.printStream = printStream;
    }


    public boolean checkGameWinner(int[] currentBoard, int playerNumber) {

        if((currentBoard[0] == currentBoard[1] && currentBoard[0] == currentBoard[2] && currentBoard[0] != 0)||
                (currentBoard[6] == currentBoard[7] && currentBoard[6] == currentBoard[8] && currentBoard[0] != 0)||
                (currentBoard[0] == currentBoard[3] && currentBoard[0] == currentBoard[6] && currentBoard[0] != 0)||
                (currentBoard[1] == currentBoard[4] && currentBoard[1] == currentBoard[7] && currentBoard[0] != 0)||
                (currentBoard[2] == currentBoard[5] && currentBoard[2] == currentBoard[8] && currentBoard[0] != 0)||
                (currentBoard[0] == currentBoard[4] && currentBoard[0] == currentBoard[8] && currentBoard[0] != 0)||
                (currentBoard[2] == currentBoard[4] && currentBoard[2] == currentBoard[6] && currentBoard[0] != 0))
        {

            printStream.println("Player "+Integer.toString(playerNumber)+" wins the game!");
            return true;
        }

        return false;
    }
}
