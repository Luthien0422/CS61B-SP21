package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesOne(){
        IntList lst = IntList.of(2, 5, 4, 20, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 25 -> 4 -> 20 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesTwo(){
        IntList lst = IntList.of(4, 6, 8, 20, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 6 -> 8 -> 20 -> 18", lst.toString());
        assertFalse(changed);
    }
    @Test
    public void testSquarePrimesThree(){
        IntList lst = IntList.of(2, 10, 7, 20, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 10 -> 49 -> 20 -> 18", lst.toString());
        assertTrue(changed);
    }
    @Test
    public void testSquarePrimesFour(){
        IntList lst = IntList.of(2, 4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 4", lst.toString());
        assertTrue(changed);
    }
}
