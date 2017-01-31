package tech.eats.art;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jhunter on 1/30/17.
 */
public class BloomFilter {
    //Array of 0 initialized bits. Several times larger than the amount of items we want to store
    //A number of hash functions
    //
    private BitSet set;


    public BloomFilter(int size) {
        set = new BitSet(size);
    }

    private int hash1(int x){
        String binString = Integer.toBinaryString(x);
        //Take odd-numbered bits from the right in the binary representatino of x

        //Treat the odd-numbered bits as an integer i

        //Result is i modulo 11
    }

    private int hash2(int x){
        String binString = Integer.toBinaryString(x);
        //Same as hash1, but take even numbered bits
    }
}
