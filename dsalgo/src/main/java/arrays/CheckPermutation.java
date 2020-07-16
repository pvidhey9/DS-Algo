package arrays;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckPermutation {

    /*Given two strings, check if one is a permutation of the other */

    /* Possible solutions that come to my mind
       1. Get all permutations of first string into a list/hashset and check if second string is present in it.
          For this problem unnecessarily take too much unintended time
       2. Sort both the strings - O(N*logN)
       3. Create a countMap of both the strings and check if they are the same  - Most efficient
       4. Can do step 3 with only a single countMap
    */

    /* O(N*logN) */
    private static boolean checkPermutationWithSort(String input1, String input2){

        char[] firstCharArray = input1.toLowerCase().toCharArray();
        Arrays.sort(firstCharArray);
        String sortedInput1 = new String(firstCharArray);

        char[] secondCharArray = input2.toLowerCase().toCharArray();
        Arrays.sort(secondCharArray);
        String sortedInput2 = new String(secondCharArray);

        return sortedInput1.equals(sortedInput2);

    }


    /* O(N) using countValue - Two count maps*/
    private static boolean checkPermutationWithCount(String input1, String input2){

        /* Assuming string has only alphabets a-z */
        int[] countMap1 = new int[26];
        int[] countMap2 = new int[26];

        for(char c : input1.toLowerCase().toCharArray()){
            int charIndex = c - 'a';
            countMap1[charIndex]++;
        }

        for(char c : input2.toLowerCase().toCharArray()){
            int charIndex = c - 'a';
            countMap2[charIndex]++;
        }

        for(int i = 0; i < countMap1.length; i++){
            if(countMap1[i] != countMap2[i]){
                return  false;
            }
        }

        return true;

    }


    /* O(N) using countValue - single count map */
    private static boolean checkPermutationWithSingleCount(String input1, String input2){

        /* Assuming string has only ASCII characters  (0-127) */
        int[] countMap = new int[128];

        /* Can add another base case */
        if(input1.length() != input2.length()){
            return false;
        }

        for(char c : input1.toCharArray()){
            int c_int = (int) c;
            countMap[c_int]++;
        }

        for(char c : input2.toCharArray()){
            int c_int = (int) c;
            countMap[c_int]--;
        }

        for (int charCount : countMap) {
            if (charCount != 0) {
                return false;
            }
        }

        return true;
    }


    /* Generating all permutation approach - RecursiveMadness
       Corner case with this particular implementation - works only with unique characters in input*/
    private static boolean checkPermutationUsingRecursion(String input1, String input2){

        HashSet<String> permutations = new HashSet<>();
        generatePermutation(input1.toLowerCase(), new StringBuilder(), permutations);

        return permutations.contains(input2.toLowerCase());
    }

    private static void generatePermutation(String input, StringBuilder sb, HashSet<String> permutations){

        if(sb.length() == input.length()){
            permutations.add(sb.toString());
        }

        for(int i = 0; i < input.length(); i++){
            if(sb.toString().indexOf(input.charAt(i)) != -1){
                continue;
            }
            sb.append(input.charAt(i));
            generatePermutation(input, sb, permutations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        String caseOneInputOne = "IsThisReal";
        String caseOneInputTwo = "TihssIaeRl";

        String caseTwoInputOne = "KuchBhiLikhDe";
        String caseTwoInputTwo = "LiterallyKuchBhi";

        assertTrue(checkPermutationWithSort(caseOneInputOne, caseOneInputTwo));
        assertFalse(checkPermutationWithSort(caseTwoInputOne, caseTwoInputTwo));

        assertTrue(checkPermutationWithCount(caseOneInputOne, caseOneInputTwo));
        assertFalse(checkPermutationWithCount(caseTwoInputOne, caseTwoInputTwo));

        assertTrue(checkPermutationWithSingleCount(caseOneInputOne, caseOneInputTwo));
        assertFalse(checkPermutationWithSingleCount(caseTwoInputOne, caseTwoInputTwo));

        assertTrue(checkPermutationUsingRecursion("1234", "4231"));
        assertFalse(checkPermutationUsingRecursion("315", "134"));

    }
}
