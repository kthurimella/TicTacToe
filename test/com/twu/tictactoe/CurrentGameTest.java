package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CurrentGameTest {
    private DrawBoard drawBoard;
    private Board board;
    private CurrentGame currentGame;

    @Before
    public void setUp() throws Exception {
        drawBoard = mock(DrawBoard.class);
        board = mock(Board.class);
        currentGame = new CurrentGame(drawBoard, board);
    }

    @Test
    public void shouldCheckIfBoardIsInitializedWhenStarted(){
        currentGame.start();
        verify(drawBoard).initialDraw();
    }

    @Test
    public void shouldCheckIfGameIsBeingPlayedAfterFirstRound(){
        currentGame.start();
        verify(board).playGame();
    }
}
