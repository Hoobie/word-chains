package com.example.wordchains;

import com.example.wordchains.solver.SimpleSolver;
import com.example.wordchains.solver.Solver;

public class Main {
    public static void main(String[] args) {
        Solver solver = new SimpleSolver();
        System.out.println(solver.solve(args[0], args[1]));
    }
}
