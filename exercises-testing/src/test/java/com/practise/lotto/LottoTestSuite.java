package com.practise.lotto;
import com.practise.lotto.Database;
import com.practise.lotto.Lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LottoTestSuite {

    private Set<Integer> generateNumbers(){
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();

        do {
            int randomNumber = random.nextInt(36) + 1;
            randomNumbers.add(randomNumber);

        } while(randomNumbers.size()<5);



        return randomNumbers;
    }

    @Mock
    Database database = mock(Database.class);

    Lotto lotto = new Lotto(database);
    Set<Integer> numbers =  new HashSet<>();

    @Test
    void testIfUserEntersMoreThanFiveNumbers(){

        numbers.add(5);
        numbers.add(4);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(6);

        Set<Integer> randomNumbers = generateNumbers();

        when(database.wylosuj(5)).thenReturn(randomNumbers);

        Integer result = lotto.miniLotto(numbers);

        assertNull(result);
    }

    @Test
    void testIfUserEntersLessThanFiveNumbers(){
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Set<Integer> randomNumbers = generateNumbers();

        when(database.wylosuj(5)).thenReturn(randomNumbers);

        Integer result = lotto.miniLotto(numbers);

        assertNull(result);
    }

    @Test
    void testTheCommonNumbers(){
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Set<Integer>randomNumbers = generateNumbers();
        when(database.wylosuj(5)).thenReturn(randomNumbers);
        Integer result = lotto.miniLotto(numbers);
        numbers.retainAll(randomNumbers);

        assertEquals(numbers.size(), result);
    }

    @Test
    void testIfUserEntersNumberInTheProvidedRange(){
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(37);

        Set<Integer> randomNumbers = generateNumbers();
        when(database.wylosuj(5)).thenReturn(randomNumbers);
        Integer result = lotto.miniLotto(numbers);
        assertNull(result);
    }

}
