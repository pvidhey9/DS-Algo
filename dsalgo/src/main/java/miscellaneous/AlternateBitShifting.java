package miscellaneous;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlternateBitShifting {

    /*
    input - 1100010
    Find min number of positions that need to shifted/repainted to obtain an output such that no two adjacent numbers are same
    output can be either - 1010101 (or) 0101010

    Minimum number of shifts here is 2 (output here should be 0101010)

    Takeaway from problem : To find number of mismatches between two binary values using XOR operation

      1100010
    ^ 0101010
    = 1001000

    Here, you see in the XOR result, 2 positions that are 1. So that can be understood as shifting 2 positions in input to obtain the output
    (or) the mismatch
     */

    /* Removing unnecessary space and variable which can be avoided to form a very compressed code*/
    private static int findBitShiftsRequired(int[] input){

        /*Keeping a count of 1's in one alternating version of length of input array
          Eg., 1010101 */
        int minCount1 = 0;

        /*Keeping a count of 1's in second alternating version
          Eg., 0101010 */
        int minCount2 = 0;

        for(int i = 0; i < input.length; i++){
            /* i%2 == 0 is to alternate between 0 and 1
               If odd, choose 0. If even choose 1 for minCount1. Choose opposite for minCount2 */
            minCount1 += i%2 == 0 ? input[i] : input[i] ^ 1;
            minCount2 += i%2 == 0 ? input[i] ^ 1 : input[i];
        }

        /*Return the minimum of shifts comparing both the cases*/
        return Math.min(minCount1, minCount2);
    }


    /* Try to arrive at the detailed version and first and then compress it as you have a better understanding of the
     code you have written */
    private static int findBitShiftsRequiredDetailedVersion(int[] input){

        int minCount1 = 0;
        int minCount2 = 0;

        int[] arr1 = new int[input.length];
        int[] arr2 = new int[input.length];

        for(int i = 0; i < input.length; i++){

            if(i%2 == 0){
                arr1[i] = 0;
                arr2[i] = 1;
            } else {
                arr1[i] = 1;
                arr2[i] = 0;
            }

            arr1[i] ^= input[i];
            arr2[i] ^= input[i];

            if(arr1[i] == 1)
                minCount1++;
            if(arr2[i] == 1)
                minCount2++;

        }

        return Math.min(minCount1, minCount2);
    }

    public static void main(String[] args) {

        int[] input1 = {1,1,1,1,1,1};
        assertEquals(findBitShiftsRequired(input1), 3);
        assertEquals(findBitShiftsRequiredDetailedVersion(input1), 3);

        int[] input2 = {1,1,0,0,0,1,0};
        assertEquals(findBitShiftsRequired(input2), 2);
        assertEquals(findBitShiftsRequiredDetailedVersion(input2), 2);

        int[] input3 = {1,1,1,0,1,0};
        assertEquals(findBitShiftsRequired(input3), 1);
        assertEquals(findBitShiftsRequiredDetailedVersion(input3), 1);

    }
}
