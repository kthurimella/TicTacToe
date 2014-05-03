package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
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
        testBoard = new Board(bufferedReader, printStream, drawBoard);
    }

    @Test
    public void shouldReturnArrayIndicatingPlayerOnePosition(){
        int[] playerOneBoard = testBoard.fillBoardArray("3", 1);
        int[] properBoard = {0, 0, 1, 0, 0, 0, 0, 0, 0};

        assertArrayEquals(properBoard, playerOneBoard);
    }

    @Test
    public void shouldReturnArrayIndicatingPlayerTwoPosition(){
        int[] playerOneBoard = testBoard.fillBoardArray("5", 2);
        int[] properBoard = {0, 0, 0, 0, 2, 0, 0, 0, 0};

        assertArrayEquals(properBoard, playerOneBoard);
    }
}
