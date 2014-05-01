package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BoardTest {
    private Board testBoard;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        testBoard = new Board(printStream);
    }

    @Test
    public void shouldReturnBoardWhenBoardIsDrawn(){
        testBoard.start();
        verify(printStream, times(3)).println("   |   |   ");
    }
    
}
