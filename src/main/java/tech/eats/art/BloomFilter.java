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

    public void add(int x){
        set.set(hash1(x));
        set.set(hash2(x));
    }

    public BitSet getSet() {
        return set;
    }

    public boolean isMember(int x){
        if(set.get(hash1(x)) && set.get(hash2(x))){
            return true;
        }
        return false;
    }


    public int hash1(int x){
        String binString = Integer.toBinaryString(x);
        String oddBits = "";

        //Take odd-numbered bits from the right in the binary representation of x
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
