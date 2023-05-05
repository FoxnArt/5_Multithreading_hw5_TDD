package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook sut;

    @BeforeEach
    public void beforeEach() {
        sut = PhoneBook.instance.get();
    }

    @AfterEach
    public void afterEach() {
        sut = null;
    }
   
    @ParameterizedTest
    @MethodSource("addSource")
    public void testAdd(String name, String number, int expected) {
        // when:
        var result = sut.add(name, number);

        // then:
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> addSource() {
        // given
        return Stream.of(
                Arguments.of("Petrov", "+7(965)115-23-23", 1),
                Arguments.of("Ivanov", "+7(905)464-37-32", 2),
                Arguments.of("Petrov", "+7(965)115-23-23", 2)
        );
    }
}
