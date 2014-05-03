package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameWinnerTest {

    private PrintStream printStream;
    private GameWinner currentWinner;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        currentWinner = new GameWinner(printStream);
    }

    @Test
    public void shouldReturnPlayerOneAsWinnerWhenGivenAThreeInARowScenario(){
        int[] playerOneWins = {1, 1, 1, 2, 2, 0, 0, 0, 0};
        int playerNumber = 1;
        currentWinner.checkGameWinner(playerOneWins, playerNumber);
        verify(printStream).println("Player 1 wins the game!");
    }
}
