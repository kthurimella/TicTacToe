package com.twu.tictactoe;

public class CurrentGame {


    private DrawBoard drawBoard;
    private Board board;

    public CurrentGame(DrawBoard drawBoard, Board board) {
        this.board = board;
        this.drawBoard = drawBoard;
    }

    public void start(){
        drawBoard.initialDraw();
        board.playGame();
    }

}
