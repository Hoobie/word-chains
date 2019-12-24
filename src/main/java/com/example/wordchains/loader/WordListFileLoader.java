package com.example.wordchains.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordListFileLoader implements WordListLoader {

    private static final String WORD_LIST_FILE_NAME = "wordlist.txt";

    @Override
    public Set<String> load() {
        try (InputStream is = getClass().getResourceAsStream(WORD_LIST_FILE_NAME)) {
            if (is == null) return new HashSet<>();
            try (InputStreamReader isr = new InputStreamReader(is); BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.toCollection(HashSet::new));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }
}
