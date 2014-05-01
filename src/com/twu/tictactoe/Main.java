package com.twu.tictactoe;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args){
        PrintStream out = System.out;
        Board ticTacToe = new Board(out);
        ticTacToe.start();
    }
}
