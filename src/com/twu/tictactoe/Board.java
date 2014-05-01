package com.twu.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Board {

    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Board(BufferedReader bufferedReader, PrintStream printStream){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void draw() {
        printStream.println("   |   |   \n-----------\n   |   |   \n" +
                "-----------\n   |   |   ");
    }

    public void start() {
        draw();
        printStream.print("Please choose a number between 1-9 corresponding to the board: ");
        char[][] firstChoice = handleChoice();
        String currentBoard = redraw(firstChoice);
        printStream.println(currentBoard);
    }

    public String redraw(char[][] firstChoice) {

        String redrawBoard = "";

        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                if(column != 2) {
                    redrawBoard += firstChoice[row][column] + "  | ";
                }
                else{
                    redrawBoard += firstChoice[row][column];

                }
            }

            redrawBoard += "\n";

            if(row != 2 ){
                redrawBoard += ("-----------");
            }

            redrawBoard += "\n";
        }

        return redrawBoard;
    }

    public char[][] handleChoice(){
        String firstChoice = readline();
        char[][] currentBoard = new char[3][3];

        switch (Integer.parseInt(firstChoice)){
            case 1: currentBoard[0][0] = 'X';
                break;
            case 2: currentBoard[0][1] = 'X';
                break;
            case 3: currentBoard[0][2] = 'X';
                break;
            case 4: currentBoard[1][0] = 'X';
                break;
            case 5: currentBoard[1][1] = 'X';
                break;
            case 6: currentBoard[1][2] = 'X';
                break;
            case 7: currentBoard[2][0] = 'X';
                break;
            case 8: currentBoard[2][1] = 'X';
                break;
            case 9: currentBoard[2][2] = 'X';
                break;
        }

        return currentBoard;
    }

    private String readline() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
