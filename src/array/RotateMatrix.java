package array;

public class RotateMatrix {
    public static void main(String[] args) {
        int [][] matrix = new int[3][3];
        int number = 1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j] = number;
                number++;
            }
        }
        System.out.println("The given matrix is: ");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        rotateNinetyDegree(matrix);
        System.out.println("The Final matrix is: ");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotateNinetyDegree(int[][] matrix){
        //transpose the matrix
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){ // we transpose only upper triangle , if j = 0 then we swap twice
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reversing row individually
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
