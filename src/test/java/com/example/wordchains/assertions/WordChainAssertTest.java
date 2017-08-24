package com.example.wordchains.assertions;

import org.junit.Test;

import java.util.Collections;

import static com.example.wordchains.assertions.WordChainAssert.assertThat;
import static java.util.Arrays.asList;

public class WordChainAssertTest {
    @Test
    public void shouldConfirmChainCorrectness() throws Exception {
        assertThat(asList("cat", "cot", "cog", "dog")).isCorrect();
        assertThat(asList("lead", "load")).isCorrect();
        assertThat(asList("lead", "load", "goad", "gold")).isCorrect();
        assertThat(asList("ruby", "rubs", "robs", "rods", "rode", "code")).isCorrect();
    }

    @Test(expected = AssertionError.class)
    public void shouldNotConfirmEmptyChainCorrectness() throws Exception {
        assertThat(Collections.emptyList()).isCorrect();
    }

    @Test(expected = AssertionError.class)
    public void shouldNotConfirmSingletonChainCorrectness() throws Exception {
        assertThat(Collections.singletonList("cat")).isCorrect();
    }

    @Test(expected = AssertionError.class)
    public void shouldNotConfirmChainCorrectness() throws Exception {
        assertThat(asList("load", "gold")).isCorrect();
    }
}
