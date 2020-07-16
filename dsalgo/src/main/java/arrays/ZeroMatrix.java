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
            First traversal will be O(MxN). So even if you optimise later, its of no great use. But Can we do better?

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
    private static void makeZeroMatrix(int[][] inputMatrix){

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

    private static void printArray(int[][] input){

        for(int i= 0; i < input.length; i++){
            for(int j = 0 ; j < input[0].length; j++){
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] input = {{1, 2, 3, 4},
                         {0, 3, 1, 4},
                         {1, 0, 2, 3},
                         {1, 2, 3, 4},
                         {1, 0, 4, 5}};

        int[][] output = {{0, 0, 3, 4},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 3, 4},
                          {0, 0, 0, 0}};

        makeZeroMatrix(input);
        assertArrayEquals(output, input);
    }


}
