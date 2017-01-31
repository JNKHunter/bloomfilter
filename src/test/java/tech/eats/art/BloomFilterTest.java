package tech.eats.art;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jhunter on 1/30/17.
 */
public class BloomFilterTest {

    private BloomFilter filter;

    @Before
    public void setUp() {
        filter = new BloomFilter(11);
    }

    @Test
    public void testHash1() {
        int hashvalue1 = filter.hash1(25);
        assertEquals(5, hashvalue1);

        int hashvalue2 = filter.hash1(73);
        assertEquals(9, hashvalue2);

    }

    @Test
    public void testHash2(){
        int hashvalue1 = filter.hash2(25);
        assertEquals(2, hashvalue1);

        int hashvalue2 = filter.hash2(73);
        assertEquals(2, hashvalue2);
    }
}
