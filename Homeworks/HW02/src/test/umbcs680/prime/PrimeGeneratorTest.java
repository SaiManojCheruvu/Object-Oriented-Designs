package umbcs680.prime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    @Test
    public void Singleton_Test(){
        PrimeGenerator gen1 = PrimeGenerator.getInstance();
        PrimeGenerator gen2 = PrimeGenerator.getInstance();
        assertSame(gen1, gen2);
        assertNotNull(gen1);
        assertNotNull(gen2);
        assertEquals(gen1, gen2);
    }
    @Disabled
    public void Is_Exception_Being_Thrown_If_To_Is_attempted_To_Be_Set_Before_From(){
        try{
            PrimeGenerator gen1 = PrimeGenerator.getInstance();
            gen1.setTo(10L);
            System.out.println(gen1.from);
            fail("Exception not caught");
        }catch (Exception e){
            assertEquals("Set from before setting to", e.getMessage() );
        }
    }

    @Test
    public void prime_Generation_Between_1_to_20(){
        PrimeGenerator gen = PrimeGenerator.getInstance();
        gen.setFrom(2L);
        gen.setTo(20L);
        gen.generatePrimes();
        Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
        assertIterableEquals(Arrays.asList(expected), gen.getPrimes());
    }
    @Test
    public void Wrong_from_value() {
        try {
            PrimeGenerator gen = PrimeGenerator.getInstance();
            gen.setFrom(0L);
            gen.setTo(1001000);
            fail("Exception not caught");
        }catch (Exception e){
            assertEquals("Wrong input value: from=0", e.getMessage());
        }
    }
    @Test
    public void Wrong_to_value(){

            try {
                PrimeGenerator gen = PrimeGenerator.getInstance();
                gen.setFrom(2L);
                gen.setTo(0L);
                fail("Exception not caught");
            }catch (Exception e){
                assertEquals("Wrong input value: to=0", e.getMessage());
            }
    }
    @Test
    public void negative_from_value(){
        try {
            PrimeGenerator gen = PrimeGenerator.getInstance();
            gen.setFrom(-2L);
            gen.setTo(10L);
            fail("Exception not caught");
        }catch (Exception e){
            assertEquals("Wrong input value: from=-2", e.getMessage());
        }
    }


}