package com.twu.tictactoe;

import java.io.PrintStream;

public class DrawBoard {


    private PrintStream printStream;
    String[] pieces = {"     ", "  X  ", "  O  "};

    public DrawBoard(PrintStream printStream){
        this.printStream = printStream;
    }

    public void initialDraw() {
        printStream.println("   |   |   \n-----------\n   |   |   \n" +
                "-----------\n   |   |   ");
    }

    public void redraw(int[] currentBoard) {
        printStream.println(pieces[currentBoard[0]] + '|' + pieces[currentBoard[1]] + '|' + pieces[currentBoard[2]]);
        printStream.println("-----------------");
        printStream.println(pieces[currentBoard[3]] + '|' + pieces[currentBoard[4]] + '|' + pieces[currentBoard[5]]);
        printStream.println("-----------------");
        printStream.println(pieces[currentBoard[6]] + '|' + pieces[currentBoard[7]] + '|' + pieces[currentBoard[8]]);
    }

}
