package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        DrawBoard drawBoard = new DrawBoard(out);
        GameWinner gameWinner = new GameWinner(out);
        Board ticTacToe = new Board(bufferedReader, out, drawBoard, gameWinner);
        CurrentGame currentGame = new CurrentGame(drawBoard, ticTacToe);
        currentGame.start();
    }
}
