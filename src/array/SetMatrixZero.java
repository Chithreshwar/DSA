package array;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

//        ArrayList<ArrayList<Integer>> ans = zeroMatrixBetterApproach(matrix, n, m);
        ArrayList<ArrayList<Integer>> ans = zeroMatrixOptimalApproach(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    /*
    [1 1 1]
    [1 0 1]
    [1 1 1]
     */
    public static ArrayList<ArrayList<Integer>> zeroMatrixOptimalApproach(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        //int row[] = new int[n] .. matrix[..][0]
        //int col[] = new int[m] .. matrix[0][..]
        int col0 = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    matrix.get(i).set(0,0);
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix.get(0).get(j)==0 || matrix.get(i).get(0) == 0){
                    matrix.get(i).set(j,0);
                }
            }
        }
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
    public static ArrayList<ArrayList<Integer>> zeroMatrixBetterApproach(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        int row[] = new int[n];
        int col[] = new int[m];
        for(int i=0;i<n;i++){ //iterating row
            for(int j=0;j<m;j++){ //iterating column
                if(matrix.get(i).get(j)==0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i] == -1 || col[j]== -1){
                    matrix.get(i).set(j,0);
                }
            }
        }
        return matrix;
    }

}
