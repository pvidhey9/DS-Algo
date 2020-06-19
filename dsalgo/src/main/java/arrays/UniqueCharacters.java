package arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharacters {

    /* Determine if a string has all unique characters. Also try case without using any additional data structures*/


    /* With HashSet implementation here
       With HashTable, can keep a count of each char in input string and check if all values equal 1
       Same can be done with an array*/
    private static boolean hasUniqueCharacters(String input){

        HashSet<Character> charSet = new HashSet<>();

        for(char c : input.toCharArray()){
            charSet.add(c);
        }

        return charSet.size() == input.length();
    }

    /* Method without using an additonal DS
       Some mental blocks : Trying to solve it only in O(N). Probably can think of higher time complexity since there is no restriction.
       Can I sort the array and check adjacent values, but higher time complexity O(N*logN)? */
    private static boolean hasUniqueCharsWithoutDS(String input){
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        for(int i = 0; i < charArray.length - 1; i++){
            if(charArray[i] == charArray[i+1]){
                return false;
            }
        }

        return true;
    }

    /* Using a bitSet  - Completely new to me*/
    private static boolean hasUniqueCharsWithBitSet(String input){

        BitSet bitSet = new BitSet(26);
        for(char c : input.toLowerCase().toCharArray()){

            int charIndex = c - 'a';
            if(bitSet.get(charIndex)){
                return false;
            } else {
                bitSet.set(charIndex);
            }
        }

        return true;
    }

    /* Not a very intuitive solution  - But good to ponder about and get used to Bit magic. Kinda similar to BitSet implementation*/
    private static boolean hasUniqueCharsWithoutDSEfficient(String input){

        int unique = 0;
        for(char c : input.toLowerCase().toCharArray()){

            int charIndex = c - 'a';
            if( (unique & (1 << charIndex)) > 0)
                return false;

            unique |= (1 << charIndex);
        }

        return true;
    }


    public static void main(String[] args) {

        String input1 = "Vidhey";
        String input2 = "HasRepeated";
        String input3 = "HashRepeateeeed";
        String input4 = "Yess";

        assertTrue(hasUniqueCharacters(input1));
        assertFalse(hasUniqueCharsWithBitSet(input2));
        assertFalse(hasUniqueCharsWithoutDS(input3));
        assertFalse(hasUniqueCharsWithoutDSEfficient(input4));
        assertTrue(hasUniqueCharsWithBitSet(input1));
        assertTrue(hasUniqueCharsWithoutDS(input1));
        assertTrue(hasUniqueCharsWithoutDSEfficient(input1));

    }
}
