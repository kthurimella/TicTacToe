package com.twu.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Board {

    private GameWinner gameWinner;
    private DrawBoard drawBoard;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    int[] currentBoard = new int[9];

    public Board(BufferedReader bufferedReader, PrintStream printStream, DrawBoard drawBoard, GameWinner gameWinner){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.drawBoard = drawBoard;
        this.gameWinner = gameWinner;
    }

    public void playGame() {

        int playerNumber = 1;

        while(isBoardEmpty(currentBoard)) {

            if (playerNumber % 2 == 0) {
                playerNumber = 2;
            }
            else if (playerNumber % 2 == 1) {
                playerNumber = 1;
            }


            printStream.print("Player "+Integer.toString(playerNumber)+", Please choose a number between 1-9 corresponding to the board: ");
            String choice = readline();
            currentBoard = fillBoardArray(choice, playerNumber);
            drawBoard.redraw(currentBoard);

            if(gameWinner.checkGameWinner(currentBoard, playerNumber)) {
                break;
            }

            playerNumber++;
        }
    }

    public int[] fillBoardArray(String position, int playerNumber) {
        int intPosition = Integer.parseInt(position);

        while(currentBoard[intPosition - 1] != 0){
            printStream.println("Position is already taken!");
            printStream.print("Player "+Integer.toString(playerNumber)+", Please choose a number between 1-9 corresponding to the board: ");
            intPosition = Integer.parseInt(readline());
        }

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

    public boolean isBoardEmpty(int[] fullBoard) {
        for (int aFullBoard : fullBoard) {
            if (aFullBoard == 0) return true;
        }

        printStream.println("The game is a draw!");
        return false;
    }
}


