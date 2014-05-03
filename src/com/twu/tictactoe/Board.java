package com.twu.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Board {

    private DrawBoard drawBoard;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    int[] currentBoard = new int[9];

    public Board(BufferedReader bufferedReader, PrintStream printStream, DrawBoard drawBoard){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.drawBoard = drawBoard;
    }

    public void playGame() {
        printStream.print("Player 1, Please choose a number between 1-9 corresponding to the board: ");
        String first = readline();
        currentBoard = fillBoardArray(first, 1);
        drawBoard.redraw(currentBoard);
        printStream.print("Player 2, Please choose a number between 1-9 corresponding to the board: ");
        String second = readline();

        while(second.equals(first)){
            printStream.println("Position is already taken!");
            printStream.print("Player 2, Please choose a number between 1-9 corresponding to the board: ");
            second = readline();
        }
        currentBoard = fillBoardArray(second, 2);
        drawBoard.redraw(currentBoard);
    }

    public int[] fillBoardArray(String position, int playerNumber) {
        int intPosition = Integer.parseInt(position);

        if(playerNumber == 1) {
            currentBoard[intPosition - 1] = 1;
        }
        else if(playerNumber == 2){
            currentBoard[intPosition - 1] = 2;
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


