// rotate matrix
class Solution {
    public int[][] transpose(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] B = new int[N][M];
        for (int j = 0; j < N; j++)
            for (int i = 0; i < M; i++)
                B[j][i] = A[i][j];
        return B;
    }

    static void rotate90Clockwise(int a[][], int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    static void rotate90AntiClockwise(int a[][], int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = temp;
            }
        }
    }

    // Rotate a Matrix by 180 degree

}


class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0;i<matrix.length ;i++){
            for(int j = 0 ;j< i +1 ;j++){
                int temp = matrix[i][j] ;
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length / 2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] =  temp;
            }
        }
    }
}