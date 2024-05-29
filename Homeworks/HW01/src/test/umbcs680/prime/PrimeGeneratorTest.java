package umbcs680.prime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    // Positive Tests
    @Test
    public void prime_Generation_Between_1_to_20(){
        PrimeGenerator gen = new PrimeGenerator(1, 20);
        gen.generatePrimes();
        Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
        assertIterableEquals(Arrays.asList(expected), gen.getPrimes());
    }
    @Test
    public void test_Large_Range() {
        PrimeGenerator gen = new PrimeGenerator(1000000, 1001000);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        assertEquals(75, primes.size());
    }

    @Test
    public void test_Huge_Range() {
        PrimeGenerator gen = new PrimeGenerator(1000000000, 1000001000);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        assertEquals(49, primes.size());
    }
    @Test
    public void range_with_to_and_from_are_primes(){
        PrimeGenerator gen = new PrimeGenerator(2, 7);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        assertIterableEquals(Arrays.asList(new Long[]{2L, 3L, 5L, 7L}), primes);
    }
    @Test
    public void range_with_from_is_prime_to_is_not_prime(){
        PrimeGenerator gen = new PrimeGenerator(2, 9);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        assertIterableEquals(Arrays.asList(new Long[]{2L, 3L, 5L, 7L}), primes);
    }
    @Test
    public void range_with_from_is_not_prime_to_is_prime(){
        PrimeGenerator gen = new PrimeGenerator(4, 7);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        assertIterableEquals(Arrays.asList(new Long[]{5L, 7L}), primes);
    }
    @Test
    public void range_with_both_from_and_to_is_not_prime(){
        PrimeGenerator gen = new PrimeGenerator(4, 15);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        assertIterableEquals(Arrays.asList(new Long[]{5L, 7L, 11L, 13L}), primes);
    }
    // Negative cases

    @Test
    public void test_Invalid_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator(100, 10);
            fail("Exception not thrown for invalid range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=100 to=10", e.getMessage());
        }
    }

    @Test
    public void test_Negative_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator(-100, -10);
            fail("Exception not thrown for negative range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-100 to=-10", e.getMessage());
        }
    }

    @Test
    public void test_Negative_And_Positive_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator(-100, 10);
            fail("Exception not thrown for negative and positive range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-100 to=10", e.getMessage());
        }
    }

    @Test
    public void test_Zero_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator(0, 0);
            fail("Exception not thrown for zero range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=0 to=0", e.getMessage());
        }
    }

    @Test
    public void test_Zero_To_One_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator(0, 1);
            fail("Exception not thrown for zero to one range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=0 to=1", e.getMessage());
        }
    }

    @Test
    public void test_One_To_ZeroRange() {
        try {
            PrimeGenerator gen = new PrimeGenerator(1, 0);
            fail("Exception not thrown for one to zero range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=1 to=0", e.getMessage());
        }
    }

    @Test
    public void test_Large_Negative_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator(-100000000, -99999990);
            fail("Exception not thrown for large negative range");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-100000000 to=-99999990", e.getMessage());
        }
    }

    @Disabled
    public void Special_Characters_In_Range() {
        try {
            PrimeGenerator gen = new PrimeGenerator('@', 'z');
            fail("Special character range not rejected");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=@ to=z", e.getMessage());
        }
    }
    @Test
    public void test_Repeated_Range() {
            LinkedList<Long> primes = new LinkedList<>();
            try{
                PrimeGenerator gen = new PrimeGenerator(10, 10);
                gen.generatePrimes();
                primes = gen.getPrimes();
            }catch (Exception e){
                assertEquals("Wrong input values: from=10 to=10", e.getMessage());
            }
            assertTrue(primes.isEmpty());
    }


    @Test
    public void test_Empty_Range() {
            LinkedList<Long> primes = new LinkedList<>();
            try {
                PrimeGenerator gen = new PrimeGenerator(10, 9);
                gen.generatePrimes();
                primes = gen.getPrimes();
            }catch (Exception e){
                assertEquals("Wrong input values: from=10 to=9", e.getMessage());
            }
            assertTrue(primes.isEmpty());
    }

    @Test
    public void test_Inverted_Range() {
        LinkedList<Long> primes = new LinkedList<>();
        try{
            PrimeGenerator gen = new PrimeGenerator(100, 10);
            gen.generatePrimes();
            primes = gen.getPrimes();
            fail("Inverted range exception not caught");
        }catch (Exception e){
            assertEquals("Wrong input values: from=100 to=10", e.getMessage());
        }
        assertTrue(primes.isEmpty());
    }

}