package arrays;

import java.util.HashSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneAway {

    /* Given there are three types of edits possible namely
       1. Inserting a character
       2. Replacing a character
       3. Deleting a character

       And given a two input strings, determine if they are one edit away from each other (could 1, 2 or 3, not AND)

       psyched --> psyche (delete)
       damn --> darn (replace)
       bak --> bake (insert)
    */

    /* Possible Solutions
       1. Get countMap for both the strings and get a difference? Will that work? I see a lot of corner cases
       2. Insert each character into a list, set and delete if the same character is seen in again?
    */


    /* With a HashSet, Time complexity - O(N)*/
    private static boolean isOneAwayEdit(String input, String editedString){

        if(Math.abs(input.length() - editedString.length()) > 1){
            return false;
        }
        HashSet<Character> charSet = new HashSet<>();

        for(char c : input.toCharArray()){
            charSet.add(c);
        }

        for(char editC : editedString.toCharArray()){
            if(charSet.contains(editC)){
                charSet.remove(editC);
            } else {
                charSet.add(editC);
            }
        }

        return charSet.size() <= 2;
    }

    /* Can we do better? Less space? Faster time? Faster time isnt possible because technically you need to
       visiting the entire string atleast once to know which characters are there.
       So intuitively, the best case algorithm BCA should be O(N), and we cannot drop below that*/

    /* Can do without an additional DS. How?*/
    private static boolean isOneEditAwayWithoutSpace(String input1, String input2){

        if(input1.length() == input2.length()){
            return isOneEditReplace(input1, input2);
        } else if( input1.length() + 1== input2.length()){
            //Insertion Case
            return isOneEditInsert(input1, input2);
        } else if(input1.length() - 1 == input2.length()){
            //Removal case
            return isOneEditInsert(input2, input1);
        }

        return false;

    }

    /* Assumption: Character inserted in input1 to get input2. So, The arguments can be reversed in the case of removal. */
    private static boolean isOneEditInsert(String input1, String input2) {
        int index1 = 0;
        int index2 = 0;

        while(index1 < input1.length() && index2 < input2.length()){
            if(input1.charAt(index1) != input2.charAt(index2)){
                /* Ideally every other character should be same other than the position of insert.
                   So for the first time there is a difference in char, the index2 will get incremented
                   And if chars are not same next time at the corresponding indexes, the one edit condition fails*/
                if(index1 != index2){
                    return false;
                }
                index2++;

            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private static boolean isOneEditReplace(String input1, String input2) {

        boolean replaced = false;

        for(int i = 0; i < input1.length(); i++){
            if(input1.charAt(i) != input2.charAt(i)){
                if(replaced){
                    return false;
                }
                replaced = true;
            }
        }

        return replaced;
    }

    public static void main(String[] args) {

        assertTrue(isOneAwayEdit("psyched", "psyche"));
        assertFalse(isOneAwayEdit("pale", "bake"));
        assertFalse(isOneEditAwayWithoutSpace("kuchbhibro", "tooLazyToType"));
        assertTrue(isOneEditAwayWithoutSpace("pale", "bale"));

    }


}
