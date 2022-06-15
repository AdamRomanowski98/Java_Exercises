package com.practise.lotto;
import com.practise.lotto.Database;
import com.practise.lotto.Lotto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LottoTestSuite {

    private static int counter;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting tests ");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("All tests has been finished");
    }

    @BeforeEach
    public void beforeEach(){
        counter++;
        System.out.println("Executing test " +counter);
    }

    private Set<Integer> generateNumbers(){
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();

        do {
            int randomNumber = random.nextInt(36) + 1;
            randomNumbers.add(randomNumber);

        } while(randomNumbers.size()<5);

        return randomNumbers;
    }

    private Set<Integer> generateNumbersForJackpot(int numbers){
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();

        if(numbers == 2){
            do{
                int randomNumber = random.nextInt(10)+1;
                randomNumbers.add(randomNumber);
            }while(randomNumbers.size()<2);
        }

        if(numbers == 5){
            do{
                int randomNumber = random.nextInt(50)+1;
                randomNumbers.add(randomNumber);
            }while(randomNumbers.size()<5);
        }

        return randomNumbers;
    }

    @Mock
    Database database = mock(Database.class);

    Lotto lotto = new Lotto(database);
    Set<Integer> numbers =  new HashSet<>();

    @Nested
    @DisplayName("miniLotto method tests")
    class testsMiniLotto{

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

    @Nested
    @DisplayName("Tests for method jackopot")
    class testJackpot{

        @Test
        void testWhenUserProvidesWrongSetSize(){
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);

            Set<Integer> randomNumbers = generateNumbersForJackpot(2);
            when(database.wylosuj(2)).thenReturn(randomNumbers);

            Integer result = lotto.jackpot(numbers);
            assertNull(result);
        }

        @Test
        void testWhenUserProvidesTwoNumbers(){
            numbers.add(4);
            numbers.add(9);

            Set<Integer> randomNumbers = generateNumbersForJackpot(2);
            when(database.wylosuj(2)).thenReturn(randomNumbers);

            Integer result = lotto.jackpot(numbers);
            numbers.retainAll(randomNumbers);

            assertEquals(numbers.size(), result);
        }

        @Test
        void testWhenUserProvidesFiveNumbers(){
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            numbers.add(4);
            numbers.add(5);

            Set<Integer> randomNumbers = generateNumbersForJackpot(5);
            when(database.wylosuj(5)).thenReturn(randomNumbers);

            Integer result = lotto.jackpot(numbers);
            numbers.retainAll(randomNumbers);

            assertEquals(numbers.size(), result);
        }

        @Test
        void testWhenUserProvidesTwoNumbersButOutOfRange(){
            numbers.add(11);
            numbers.add(22);

            Set<Integer> randomNumbers = generateNumbersForJackpot(2);
            when(database.wylosuj(2)).thenReturn(randomNumbers);

            Integer result = lotto.jackpot(numbers);

            assertNull(result);
        }

        @Test
        void testWhenUserProvidesFiveNumbersButOutOfRange(){
            numbers.add(52);
            numbers.add(32);
            numbers.add(21);
            numbers.add(0);
            numbers.add(12);

            Set<Integer> randomNumbers = generateNumbersForJackpot(5);
            when(database.wylosuj(5)).thenReturn(randomNumbers);

            Integer result = lotto.jackpot(numbers);

            assertNull(result);
        }
    }



}
