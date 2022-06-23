package com.practise.stream;

import com.practise.lotto.Database;



import org.junit.jupiter.api.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;



public class StreamTestSuite {
    @Test
    public void testCountEmptyStringUsingJava8() {
        //given
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //when
        long count = Main.getCountEmptyStringUsingJava8(strings);
        //then
        assertEquals(2, count);
    }

    @Test
    public void testCountLength3UsingJava8() {
        //given
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //when
        long count = Main.getCountLength3UsingJava8(strings);
        //then
        assertEquals(3, count);
    }

    @Test
    public void testDeleteEmptyStringsUsingJava8() {
        //given
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> expected = Arrays.asList("abc", "bc", "efg", "abcd", "jkl");
        //when
        List<String> result = Main.deleteEmptyStringsUsingJava8(strings);
        //then
        assertEquals(5, result.size());
        assertEquals(expected, result);
    }

    @Test
    public void testMergedStringUsingJava8() {
        //given
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        String expected = "abc,bc,efg,abcd,jkl";
        //when
        String result = Main.getMergedStringUsingJava8(strings, ",");
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testSquaresJava8() {
        //given
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> expected = Arrays.asList(9, 4, 49, 25);
        //when
        List<Integer> result = Main.getSquaresJava8(numbers);
        //then
        assertEquals(4, result.size());
        assertEquals(expected, result);
    }

    @Test
    public void testMaxJava8() {
        //given
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Integer expected = 7;
        //when
        Integer result = Main.getMaxJava8(numbers);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testMinJava8() {
        //given
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Integer expected = 2;
        //when
        Integer result = Main.getMinJava8(numbers);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testSumJava8() {
        //given
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Integer expected = 25;
        //when
        Integer result = Main.getSumJava8(numbers);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testAverageJava8() {
        //given
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Integer expected = 3;
        //when
        Integer result = Main.getAverageJava8(numbers);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testIfEmpty(){
        List<Integer> numbers = new ArrayList<>();

        Integer resultMax = Main.getMaxJava8(numbers);
        Integer resultMin = Main.getMinJava8(numbers);
        Integer resultAverage = Main.getAverageJava8(numbers);

        assertNull(resultMax);
        assertNull(resultMin);
        assertNull(resultAverage);
    }
}
