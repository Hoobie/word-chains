package com.example.wordchains.loader;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordListFileLoaderTest {

    @Test
    public void shouldLoadWordListFromFile() {
        // given
        WordListLoader loader = new WordListFileLoader();

        // when
        Set<String> wordList = loader.load();

        // then
        assertThat(wordList)
                .isNotEmpty()
                .contains("cat")
                .contains("cot")
                .contains("cog")
                .contains("dog")
                .contains("lead")
                .contains("load")
                .contains("goad")
                .contains("gold");
    }
}