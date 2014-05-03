package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrawBoardTest {

    private PrintStream printStream;
    private DrawBoard currentBoard;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        currentBoard = new DrawBoard(printStream);
    }

    @Test
    public void shouldReturnBoardWhenBoardIsDrawn(){
        currentBoard.initialDraw();
        verify(printStream).println("   |   |   \n-----------\n   |   |   \n-----------\n   |   |   ");
    }

    @Test
    public void shouldPrintBoardWithCorrectPlayerOneInput(){
        int[] testBoard = {0, 0, 1, 0, 0, 0, 0, 0, 0};
        currentBoard.redraw(testBoard);
        verify(printStream).println("     |     |  X  ");
    }

    @Test
    public void shouldPrintBoardWithCorrectPlayerOneAndTwoInput(){
        int[] testBoard = {0, 0, 1, 0, 2, 0, 0, 0, 0};
        currentBoard.redraw(testBoard);
        verify(printStream).println("     |     |  X  ");
        verify(printStream).println("     |  O  |     ");
    }


    }
