package arrays;

import java.util.List;

public class RotateMatrixBy90 {

    /* Given a NxN matrix [Square matrix], write a method to rotate the image by 90 degrees. Do it in-place.

      Input Matrix:
        [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]

      Output Matrix - Rotate By 90
        [7, 4, 1]
        [8, 5, 2]
        [9, 6, 3]

      Possible Solutions:
       LTC = LBC
       TM = LM
       RTC = RLC

     */


    private static void rotateBy90(int[][] inputMatrix){

        for(int layer = 0; layer < inputMatrix.length / 2 ; layer++){

            int start = layer;
            int end = inputMatrix.length - layer - 1;

            for(int i = start; i < end; i++){
                //distance from start. Tough to wrap your head around this initially.
                int offset = i - start;

                //Reference to Top
                int top = inputMatrix[start][i];

                //Top  -> Left
                inputMatrix[start][i] = inputMatrix[end - offset][start];

                //Left -> Bottom
                inputMatrix[end - offset][start] = inputMatrix[end][end - offset];

                //Bottom -> Right
                inputMatrix[end][end - offset] = inputMatrix[i][end];

                //Right -> top
                inputMatrix[i][end] = top;

            }
        }
    }


}
