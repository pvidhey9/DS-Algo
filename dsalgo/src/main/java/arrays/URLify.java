package arrays;
import static org.junit.Assert.*;

public class URLify {

    /* Write method to replace all spaces in a string with %20. Input string has sufficient space to hold the
       additional characters

       input  - "Psy Trance  "
       output - "Psy%20Trance"

       Possible solutions can think at this point
       1. Simple search and replace - need to shift characters ahead
       2. How about using regex?
       */

    private static String replaceEmptySpaces(String input){

        char[] outputCharArray = new char[input.length()];
        String blankChar = "%20";

        int index = 0;
        for(char c : input.toCharArray()){
            if(c == ' '){
                /* This feels like repeated traversals. Can we improve on this?*/
                for(char b : blankChar.toCharArray()){
                    outputCharArray[index++] = b;
                }
            } else {
                outputCharArray[index++] = c;
            }

            if(index == input.length()){
                break;
            }
        }

        return new String(outputCharArray);
    }

    /* How can we do this in place without an additional charArray? */
    private static void replaceEmptyCharsInPlace(char[] input, int lengthOfActualString){

        /* First find number of spaces*/
        int nrOfSpaces = 0;
        for(int j = 0; j < lengthOfActualString; j++){
            if(input[j] == ' '){
                nrOfSpaces++;
            }
        }

        int positionWithSpace = lengthOfActualString + (nrOfSpaces * 2);

        /* Go from back to front. Start from length of actual string, as we dont want to consider end spaces*/
        for(int i = lengthOfActualString - 1; i >= 0; i--){
            if(input[i] == ' '){
                input[positionWithSpace - 1] = '0';
                input[positionWithSpace - 2] = '2';
                input[positionWithSpace - 3] = '%';
                positionWithSpace -= 3;
            } else {
                input[positionWithSpace - 1] = input[i];
                positionWithSpace--;
            }

        }

    }
    public static void main(String[] args) {

        String input = "Psy Trance  ";
        String output = "Psy%20Trance";

        assertEquals(output, replaceEmptySpaces(input));

        char[] inputArray = input.toCharArray();
        replaceEmptyCharsInPlace(inputArray, 10);
        String outputFromArray = new String(inputArray);
        assertEquals(outputFromArray, output);

    }
}
