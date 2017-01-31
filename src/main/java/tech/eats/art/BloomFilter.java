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
    private int size;


    public BloomFilter(int size) {
        set = new BitSet(size);
        this.size = size;
    }

    public int hash1(int x){
        String binString = Integer.toBinaryString(x);
        String oddBits = "";

        //Take odd-numbered bits from the right in the binary representatino of x
        for(int i = binString.length() - 1; i >= 0; i -= 2){
            oddBits = binString.charAt(i) + oddBits;
        }

        //Treat the odd-numbered bits as an integer i
        int oddInt = Integer.parseInt(oddBits, 2);
        //Result is i modulo size of ste
        return oddInt % size;



    }

    public int hash2(int x){
        //Same as hash1, but take even numbered bits
        String binString = Integer.toBinaryString(x);
        String evenBits = "";

        for(int i = binString.length() - 2; i >= 0; i-= 2){
            evenBits = binString.charAt(i) + evenBits;
        }

        int evenInt = Integer.parseInt(evenBits, 2);
        return evenInt % size;
    }
}
