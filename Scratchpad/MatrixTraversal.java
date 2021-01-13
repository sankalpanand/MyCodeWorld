package Scratchpad;

public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        int rows = mat.length; // 3 // Horizontal
        int cols = mat[0].length; // 4 // Vertical

        // Traversal starts here
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {

                System.out.print("\t" + mat[i][j]);
            }
            System.out.println();
        }
    }
}
