package arrays;

import java.util.HashMap;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromePermutation {

    /* Given a string, check if it is a permutation of a palindrome

        input - Tact Coa
        Output - True because it has permutations which form palindromes
        Eg., "tacocat", "atcocta"

        Possible sol at the moment:
        1. Need to check if the string has suitable number of letters to form a palindrome
        2. If input has even number of characters, then each character should be a multiple of two
        3. If input has odd number of characters, then there should one character with odd number count

    */


    private static boolean checkPalindromePermutation(String input){

        HashMap<Character, Integer> countMap = new HashMap<>();

        for(char c : input.toCharArray()){
            int count = countMap.getOrDefault(c, 0);
            countMap.put(c, count+1);
        }

        if(input.length() % 2 == 0){
            for(int value : countMap.values()){
                if(value % 2 != 0){
                    return false;
                }
            }
        } else {
            int oddCount = 0;
            for(int value : countMap.values()){
                if(value % 2 != 0){
                    oddCount++;
                }
            }
            return oddCount <= 1 && oddCount != 0;
        }

        return true;
    }

    /* Can reduce the space further by using BitSet vector */

    public static void main(String[] args) {

        String input = "tactcoa";
        assertTrue(checkPalindromePermutation(input));
        assertFalse(checkPalindromePermutation("cosmicbros"));
    }
}
