package com.example.wordchains.solver;

import org.junit.Test;

import java.util.List;

import static com.example.wordchains.assertions.WordChainAssert.assertThat;

public class SimpleSolverTest {

    @Test
    public void shouldReturnPossiblyNotOptimalSolution() throws Exception {
        // given
        Solver solver = new SimpleSolver();

        // when
        List<String> chain = solver.buildChain("cat", "dog");

        // then
        assertThat(chain)
                .isCorrect()
                .startsWith("cat")
                .endsWith("dog");
    }
}