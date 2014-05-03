package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class BoardTest {
    private Board testBoard;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private DrawBoard drawBoard;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        drawBoard = mock(DrawBoard.class);
        testBoard = new Board(bufferedReader, printStream, drawBoard, null);
    }

    @Test
    public void shouldReturnArrayIndicatingPlayerOnePosition(){
        int[] playerOneBoard = testBoard.fillBoardArray("3", 1);
        int[] properBoard = {0, 0, 1, 0, 0, 0, 0, 0, 0};

        assertArrayEquals(properBoard, playerOneBoard);
    }

    @Test
    public void shouldReturnArrayIndicatingPlayerTwoPosition(){
        int[] playerTwoBoard = testBoard.fillBoardArray("5", 2);
        int[] properBoard = {0, 0, 0, 0, 2, 0, 0, 0, 0};

        assertArrayEquals(properBoard, playerTwoBoard);
    }

    @Test
    public void shouldReturnLocationErrorWhenPassedSameLocation() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3").thenReturn("3").thenReturn("5");
        testBoard.fillBoardArray("3", 1);
        testBoard.fillBoardArray("3", 2);

        verify(printStream, times(3)).println("Position is already taken!");
    }

    @Test
    public void shouldReturnFullArrayWhenCompleted(){
        int[] fullBoard = {1, 2, 1, 2, 1, 2, 1, 2, 1};

        assertFalse(testBoard.isBoardEmpty(fullBoard));
    }

    @Test
    public void shouldAlternateTurnsUntilArrayIsFull() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2").thenReturn("3")
                .thenReturn("4").thenReturn("5").thenReturn("6")
                .thenReturn("7").thenReturn("8").thenReturn("9");
        testBoard.playGame();

        verify(printStream).println("The game is a draw!");
    }
}
