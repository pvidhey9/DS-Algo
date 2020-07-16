package arrays;

import java.time.Duration;
import java.time.Instant;
import static org.junit.Assert.assertTrue;

public class StringRotation {

    /* Assume you have a method isSubstring which returns if one word is a substring of another.
       Given two strings s1 and s2, check if s2 is rotation of s1 only using isSubstring method.

       Eg.,  s1 - greenwood
             s2 - nwoodgree
     */


    /* But contains is costly operation to check for every substring - O(M*N*N). Can we do better?*/
    private static boolean isRotatedString(String input1, String input2){

        if(input1.length() != input2.length()){
            return false;
        }

        for(int i = 0; i < input2.length(); i++){

            if(!input1.contains(input2.substring(0, i))){
                if(input1.contains(input2.substring(i))){
                    return true;
                }
            }
        }

        return false;

    }

    private static boolean isRotatedStringEfficient(String input1, String input2){

        String concat_inputs = input1 + input2;
        return concat_inputs.contains(input1);
    }


    public static void main(String[] args) {

        String sampleInput1 = "greenwoodjanlanwfpoqjwpoqjpowjoqfkqnfwiqfnpiqwjfqpijwfpqf";
        String sampleInput2 = "owjoqfkqnfwiqfnpiqwjfqpijwfpqfgreenwoodjanlanwfpoqjwpoqjp";

        Instant start = Instant.now();
        assertTrue(isRotatedString(sampleInput1, sampleInput2));

        System.out.println("Elapsed Time : " + Duration.between(start, Instant.now()).toMillis() + "ms");

        start = Instant.now();
        assertTrue(isRotatedStringEfficient(sampleInput1, sampleInput2));

        System.out.println("Elapsed Time : " + Duration.between(start, Instant.now()).toMillis() + "ms");


    }
}
