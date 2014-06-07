package com.erinfan.codekata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;

/**
 * Created by techops on 6/6/14.
 */
public class GameTest {
    private Game game;
    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void should_create_different_4_random_digit() throws Exception {
        assertTrue(game.createRandomDigit());
        assertThat(game.getRandomDigit().length(), is(4));
    }

    @Test
    public void should_return_congratulations_if_user_input_is_correct() throws Exception {
        Game game = new Game();
        game.setRandomDigit("1234");
        game.startGuess("1324");
        assertThat(game.startGuess("1234"), is("Congratulations!"));
    }

    @Test
    public void should_return_correctString_when_user_input_digit() throws Exception {
        game.setRandomDigit("1234");
        assertThat(game.startGuess("1324"), is("1ABBA"));
    }

    @Test
    public void should_return_user_input_times() throws Exception {
        game.setRandomDigit("1234");
        assertThat(game.startGuess("1324"), is("1ABBA"));
        assertThat(game.startGuess("1324"), is("2ABBA"));
        assertThat(game.startGuess("1324"), is("3ABBA"));
    }

    @Test
    public void should_game_over_after_user_input_6_times() throws Exception {
        game.setRandomDigit("1234");
        game.startGuess("1234");
        game.startGuess("1234");
        game.startGuess("1234");
        game.startGuess("1234");
        game.startGuess("1234");
        game.startGuess("1234");
        assertThat(game.startGuess("1324"), is("Game Over"));
    }

    @Test
    public void should_show_user_input_times() throws Exception {
        game.setRandomDigit("1234");

    }
}
