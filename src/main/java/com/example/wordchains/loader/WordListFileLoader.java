package com.example.wordchains.loader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordListFileLoader implements WordListLoader {

    private static final String WORD_LIST_FILE_NAME = "wordlist.txt";
    private static final String CP_1252_CHARSET = "Cp1252";

    @Override
    public Set<String> load() {
        try {
            Path wordListPath = Paths.get(ClassLoader.getSystemResource(WORD_LIST_FILE_NAME).toURI());
            return Files.lines(wordListPath, Charset.forName(CP_1252_CHARSET))
                    .collect(Collectors.toCollection(HashSet::new));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }
}
