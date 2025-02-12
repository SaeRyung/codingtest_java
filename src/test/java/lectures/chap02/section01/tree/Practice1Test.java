package lectures.chap02.section01.tree;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/* 이중 우선순위 큐 - 백준 (7662) */
class Practice1Test {

    private Practice1 practice1;
    private static String input;
    private static String output;

    @BeforeAll
    static void set() {

        input = "2\n" +
                "7\n" +
                "I 16\n" +
                "I -5643\n" +
                "D -1\n" +
                "D 1\n" +
                "D 1\n" +
                "I 123\n" +
                "D -1\n" +
                "9\n" +
                "I -45\n" +
                "I 653\n" +
                "D 1\n" +
                "I -642\n" +
                "I 45\n" +
                "I 97\n" +
                "D 1\n" +
                "D -1\n" +
                "I 333";

        output = "EMPTY\n" +
                "333 -45";

    }

    static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input, output)
        );
    }

    @BeforeEach
    void setUp() {
        practice1 = new Practice1();
    }


    @DisplayName("이중 우선순위 큐 테스트")
    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(String input, String output) throws Exception {
        String result = practice1.solution(input);
        Assertions.assertEquals(output, result);
    }
}