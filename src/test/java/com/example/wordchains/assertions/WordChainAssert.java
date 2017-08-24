package com.example.wordchains.assertions;

import org.assertj.core.api.ListAssert;

import java.util.List;

public class WordChainAssert extends ListAssert<String> {

    private WordChainAssert(List<String> actual) {
        super(actual);
    }

    public static WordChainAssert assertThat(List<String> actual) {
        return new WordChainAssert(actual);
    }

    public WordChainAssert isCorrect() {
        throw new UnsupportedOperationException();
    }
}
