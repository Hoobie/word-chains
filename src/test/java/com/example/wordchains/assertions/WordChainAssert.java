package com.example.wordchains.assertions;

import com.example.wordchains.loader.WordListFileLoader;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class WordChainAssert extends ListAssert<String> {

    private static final Set<String> WORD_LIST = new WordListFileLoader().load();

    private WordChainAssert(List<String> actual) {
        super(actual);
    }

    public static WordChainAssert assertThat(List<String> actual) {
        return new WordChainAssert(actual);
    }

    public WordChainAssert isCorrect() {
        isNotEmpty();
        Assertions.assertThat(actual.size()).isGreaterThanOrEqualTo(2);
        IntStream.range(1, actual.size())
                .forEach(i -> {
                    String prev = actual.get(i - 1);
                    String next = actual.get(i);
                    Assertions.assertThat(prev.length()).isEqualTo(next.length());
                    Assertions.assertThat(WORD_LIST).contains(prev);
                    Assertions.assertThat(WORD_LIST).contains(next);
                    long count = IntStream.range(0, prev.length())
                            .filter(j -> prev.charAt(j) != next.charAt(j))
                            .count();
                    Assertions.assertThat(count).isLessThanOrEqualTo(1);
                });
        return this;
    }
}
