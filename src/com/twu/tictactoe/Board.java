package com.twu.tictactoe;


import java.io.PrintStream;

public class Board {

    private PrintStream printStream;

    public Board(PrintStream printStream){
        this.printStream = printStream;
    }

    public void draw() {
        for(int i = 0; i < 3; i++){
            printStream.println("   |   |   ");
            if(i != 2 ){
                printStream.println("-----------");
            }
        }
    }

    public void start() {
        draw();
    }
}
