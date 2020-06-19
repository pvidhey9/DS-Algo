package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DualReplace {

    /*
        Replace the characters in string as defined the subLists

        input - coder
        subFirst -  ['c']
        subSecond - ['o']

        output - ocder
        Replace 'c' in input with 'o', and 'o' with 'c'

        input - kajak
        subFirst  - ['k','j','a']
        subSecond - ['a','z','k']

        output - kazak

    */

    /* Use a StringBuilder for concatenating strings rather than concatenating individual Strings directly

       Eg.,
       String sentence = "";
       for(String word : words){
            sentence += word;
       }

       For every concatenation, a new copy of the string is created and then the both the words are added char by char.
       Intuitively itself it looks like an inefficient operation.
       First concat  - x characeters in word
       Second concat - 2x chacracters for both words
       and so on.. for n words
       Time Consumed - O(x + 2x + 3x .... nx) --> O((x(n^2))

       StringBuilder just creates a resizable array, so theres no copying for every concatenation

    /* Time Complexity - o(N^2)
       Traversing through the input string repeatedly - This is the repeated work which can be optimised. But how? Using HashMaps?*/
    private static String dualReplaceNotEfficient(String input, List<Character> subFirst, List<Character> subSecond){

        String resultString = input;

        for(int i = 0; i < subFirst.size(); i++){
            Character firstChar = subFirst.get(i);
            Character secondChar = subSecond.get(i);
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < resultString.length(); j++ ){
                Character charInInput = resultString.charAt(j);
                if( charInInput == firstChar){
                    sb.append(secondChar);
                } else if(charInInput == secondChar){
                    sb.append(firstChar);
                } else {
                    sb.append(charInInput);
                }
            }

            resultString = sb.toString();
        }

        return resultString;

    }

    /* Time Complexity - 0(N)
       Store the mapping both ways in hash map
       Traverse through input string, check if the key mapping exists, and then append the value of key into the stringbuilder
       Else just append the character in the input string*/
    private static String dualReplaceEfficient(String input, List<Character> subFirst, List<Character> subSecond){

        HashMap<Character, Character> charMapFromSubLists = new HashMap<>();

        for(int i = 0; i < subFirst.size(); i++){
            if(!charMapFromSubLists.containsKey(subFirst.get(i))) {
                charMapFromSubLists.put(subFirst.get(i), subSecond.get(i));
            } else {
                charMapFromSubLists.remove(subFirst.get(i));
            }

            if(!charMapFromSubLists.containsKey(subSecond.get(i))) {
                charMapFromSubLists.put(subSecond.get(i), subFirst.get(i));
            } else {
                charMapFromSubLists.remove(subSecond.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()){
            if(charMapFromSubLists.containsKey(c)){
                sb.append(charMapFromSubLists.get(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        List<Character> subFirst1 = new ArrayList<>();
        subFirst1.add('k');
        subFirst1.add('j');
        subFirst1.add('a');

        List<Character> subSecond1 = new ArrayList<>();
        subSecond1.add('a');
        subSecond1.add('z');
        subSecond1.add('k');

        String input1 = "kajak";

        assertEquals("kazak", dualReplaceNotEfficient(input1, subFirst1, subSecond1));
        assertEquals("kazak", dualReplaceEfficient(input1, subFirst1, subSecond1));

        List<Character> subFirst2 = new ArrayList<>();
        subFirst2.add('c');
        List<Character> subSecond2 = new ArrayList<>();
        subSecond2.add('o');

        String input2 = "coder";

        assertEquals("ocder", dualReplaceNotEfficient(input2, subFirst2, subSecond2));
        assertEquals("ocder", dualReplaceEfficient(input2, subFirst2, subSecond2));
    }
}
