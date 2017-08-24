package com.example.wordchains.solver;

import java.util.List;

public interface Solver {
    List<String> buildChain(String startWord, String endWord);
}
