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


        for(int size = 0; size < 3; size++){
            printStream.println("   |   |   ");
            if(size != 2 ){
                printStream.println("-----------");
            }
        }
    }

    public void start() {
        draw();
        printStream.print("Please choose a number between 1-9 corresponding to the board: ");
        char[][] firstChoice = handleChoice();
        redraw(firstChoice);

    }

    public void redraw(char[][] firstChoice) {

        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                if(column != 2) {
                    printStream.print(firstChoice[row][column] + "  | ");
                }
                else{
                    printStream.println(firstChoice[row][column]);

                }
            }

            if(row != 2 ){
                printStream.println("-----------");
            }
        }
    }

    public char[][] handleChoice(){
        String firstChoice = readline();
        char[][] currentBoard = new char[3][3];
        printStream.println(firstChoice);

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
