package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;


public class ZeroMatrix {
    /* Write an algorithm to set the entire row and column to 0, if an element is found to be 0 in MxN matrix

       Eg.,
       Input :  [[1, 2, 3, 4]
                 [0, 3, 1, 4]
                 [1, 0, 2, 3]
                 [1, 2, 3, 4]
                 [1, 2, 0, 5]]

       Output : [[0, 0, 3, 4]
                 [0, 0, 0, 0]
                 [0, 0, 0, 0]
                 [0, 0, 3, 4]
                 [0, 0, 0, 0]]

       Possible Solutions:
         1. Get the positions of zero while traversing through the matrix first time ito a list probably
            Traverse through the list and set all the rows and columns for that particular position to 0.
            First traversal will be O(MxN). So even if you optimise later, its of no great use.
            But Can we do better in terms of space complexity?

     */

    static class Pair{

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        /* Although not needed here*/
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return row == pair.row &&
                    col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    /* Algorithm performed in in-place. Avoid creating another matrix of same size. */
    private static void makeZeroMatrixWithPairs(int[][] inputMatrix){

        int nrRows = inputMatrix.length;
        int nrCols = inputMatrix[0].length;

        int totalPositions = nrRows * nrCols;

        List<Pair> pairList = new ArrayList<>();

        for(int row = 0 ; row < nrRows; row++){
            for(int col = 0; col < nrCols; col++){
                if(inputMatrix[row][col] == 0){
                    pairList.add(new Pair(row, col));
                }
            }
        }

        /* Avoid editing the input matrix if everything is zero. Improves run time complexity.*/
        if(pairList.size() == totalPositions){
            return;
        }

        /* This can be improved essentially.*/
        for(Pair pair : pairList){
            int row = pair.row;
            int col = pair.col;

            for(int i = 0; i < nrCols; i++){
                inputMatrix[row][i] = 0;
            }

            for(int j = 0; j < nrRows; j++){
                inputMatrix[j][col] = 0;
            }
        }

    }

    private static void makeZeroMatrix(int[][] inputMatrix){

        int nrRows = inputMatrix.length;
        int nrCols = inputMatrix[0].length;

        boolean[] rowMap = new boolean[inputMatrix.length];
        boolean[] colMap = new boolean[inputMatrix[0].length];

        for(int row = 0 ; row < nrRows; row++){
            for(int col = 0; col < nrCols; col++){
                if(inputMatrix[row][col] == 0){
                    rowMap[row] = true;
                    colMap[col] = true;
                }
            }
        }

        for(int i = 0; i < rowMap.length ; i++){
            if(rowMap[i]) {
                makeRowZero(inputMatrix, i);
            }
        }

        for(int i = 0; i < colMap.length ; i++){
            if(colMap[i]) {
                makeColZero(inputMatrix, i);
            }
        }

    }

    /* Not a very evident solution, a bit twisted the first time. Space complexity - O(1)*/
    private static void makeZeroMatrixWithConstantSpace(int[][] inputMatrix){

        boolean rowHasZero = false;
        boolean colHasZero = false;

        for(int i = 0; i < inputMatrix.length; i++){
            if(inputMatrix[i][0] == 0){
                colHasZero = true;
            }
        }

        for(int i = 0; i < inputMatrix[0].length; i++){
            if(inputMatrix[0][i] == 0){
                rowHasZero = true;
            }
        }

        for(int i = 1; i < inputMatrix.length; i++){
            for(int j = 1; j < inputMatrix[0].length; j++){
                if(inputMatrix[i][j] == 0){
                    inputMatrix[i][0] = 0;
                    inputMatrix[0][j] = 0;
                }
            }
        }


        for(int i = 1; i < inputMatrix.length; i++){
            if(inputMatrix[i][0] == 0){
                makeRowZero(inputMatrix, i);
            }
        }

        for(int j = 1; j < inputMatrix[0].length; j++){
            if(inputMatrix[0][j] == 0){
                makeColZero(inputMatrix, j);
            }
        }

        if(rowHasZero){
            makeRowZero(inputMatrix, 0);
        }

        if(colHasZero){
            makeColZero(inputMatrix, 0);
        }
    }

    private static void makeRowZero(int[][] input, int fixedRow){
        for(int i = 0; i < input[0].length; i++){
            input[fixedRow][i] = 0;
        }
    }

    private static void makeColZero(int[][] input, int fixedCol){
        for(int row = 0; row < input.length; row++){
            input[row][fixedCol] = 0;
        }
    }

    private static void printArray(int[][] input){

        for(int i= 0; i < input.length; i++){
            for(int j = 0 ; j < input[0].length; j++){
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] input1 = {{1, 2, 3, 4},
                         {0, 3, 1, 4},
                         {1, 0, 2, 3},
                         {1, 2, 3, 4},
                         {1, 0, 4, 5}};

        int[][] input2 = {{1, 2, 3, 4},
                {0, 3, 1, 4},
                {1, 0, 2, 3},
                {1, 2, 3, 4},
                {1, 0, 4, 5}};

        int[][] input3 = {{1, 2, 3, 4},
                {0, 3, 1, 4},
                {1, 0, 2, 3},
                {1, 2, 3, 4},
                {1, 0, 4, 5}};

        int[][] output = {{0, 0, 3, 4},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 3, 4},
                          {0, 0, 0, 0}};

        makeZeroMatrixWithPairs(input1);
        makeZeroMatrix(input2);
        makeZeroMatrixWithConstantSpace(input3);
        assertArrayEquals(output, input1);
        assertArrayEquals(output, input2);
        assertArrayEquals(output, input3);
    }


}
