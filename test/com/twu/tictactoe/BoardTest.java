package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BoardTest {
    private Board testBoard;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        testBoard = new Board(bufferedReader, printStream);
    }

    @Test
    public void shouldReturnBoardWhenBoardIsDrawn(){
        testBoard.draw();
        verify(printStream).println("   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldReturnArrayWithCorrectPosition() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3");
        char[][] currentArray = testBoard.handleChoice();
        char[][] expectedArray = {{ 0 ,0 ,'X' },{0,0,0 },{0, 0, 0}};
        assertArrayEquals(expectedArray, currentArray);
    }

    @Test
    public void shouldReturnBoardWithCorrectPosition() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3");
        testBoard.redraw(testBoard.handleChoice());
        verify(printStream).println("  |   | X \n-----------\n  |   | \n-----------\n  |   |  \n");
    }

    @Test
    public void shouldReturnBoardWithPlayerTwoMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");
        testBoard.redraw(testBoard.handleChoice());
        verify(printStream).println("  |   | X \n-----------\n  | O  | \n-----------\n  |   |  \n");
    }

    
}
