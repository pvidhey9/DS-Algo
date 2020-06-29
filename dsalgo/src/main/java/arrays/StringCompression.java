package arrays;

import java.util.HashMap;

import static org.junit.Assert.*;

public class StringCompression {

    /* Perform basic string compression using the counts of repeated characters. If compressed string is
       not less than original string in length, return original string

       input - dddaarrrkkk  - 11 chars
       output - d3a2r3k3    - 8 chars

       input - dark  - 4 chars  -- return this
       output - d1a1r1k1  - 8 chars

        Possible solutions:
        1. Store count in one traversal. In next traversal create compressed string
     */


    private static String compressString(String input){

        char previousChar = input.charAt(0);
        int count = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(previousChar);
        for(int i = 1; i < input.length(); i++){
            if(previousChar != input.charAt(i)){
                sb.append(count);
                sb.append(input.charAt(i));
                previousChar = input.charAt(i);
                count = 1;
            } else {
                count += 1;
            }

            if(i == input.length() - 1){
                sb.append(count);
            }
        }

        return sb.toString().length() > input.length() ? input : sb.toString();


    }

    /* One way of improving this further is by checking well in advance if the original string is most
       compressed version before applying additional string compression. This might include another additinal for loop,
       but we save some space by defining the size of StingBuilder well in advance, so that it doesnt have to double
       its size in between dynamically. */

    public static void main(String[] args) {

        String input = "dddaarrrkkk";
        assertEquals("d3a2r3k3", compressString(input));
        assertEquals("dark", compressString("dark"));
        assertEquals("a2b1c5a3", compressString("aabcccccaaa"));
    }


}
