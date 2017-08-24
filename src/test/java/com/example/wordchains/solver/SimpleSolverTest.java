package com.example.wordchains.solver;

import org.junit.Test;

import static com.example.wordchains.assertions.WordChainAssert.assertThat;

public class SimpleSolverTest {

    private static final Solver SOLVER = new SimpleSolver();

    @Test
    public void shouldReturnPossiblyNotOptimalSolution() throws Exception {
        assertThat(SOLVER.buildChain("cat", "dog"))
                .isCorrect()
                .startsWith("cat")
                .endsWith("dog");

        assertThat(SOLVER.buildChain("lead", "gold"))
                .isCorrect()
                .startsWith("lead")
                .endsWith("gold");

        assertThat(SOLVER.buildChain("ruby", "code"))
                .isCorrect()
                .startsWith("ruby")
                .endsWith("code");
    }

    @Test
    public void shouldReturnOptimalSolution() throws Exception {
        assertThat(SOLVER.buildChain("cat", "dog")).hasSize(4);

        assertThat(SOLVER.buildChain("lead", "gold")).hasSize(4);

        assertThat(SOLVER.buildChain("ruby", "code")).hasSize(6);
    }
}