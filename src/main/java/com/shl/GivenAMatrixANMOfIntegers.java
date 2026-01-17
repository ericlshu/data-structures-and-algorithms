package com.shl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description :
 * Given a matrix A(1..NI[1..Mj of integers, the product of a submatrix of A is the product of all the elements of the submatrix.
 * <p>
 * Write an algorithm to find the number of non-empty submatrices that contain the top left element of matrix A(l.e. submatrices B[l.XI[1.Y) for 1 XN,1 sY s M) with a product s K
 * <p>
 * Input
 * The first ine of the input consists of two space-separated integers-rows and columns, representing the number of rows in the matrix (N) and the number of columns in the matrix (M),respectively.
 * The next N Lines consist of M space-separated integers representing the elements of the matrix A.The last line consists of an integer - max,representing the maximum permissible product of the elements of a submatrix (K),
 * <p>
 * Output
 * Print an integer representing the number of submatrices that contain the top left element of the given matrix with a product less than or equal to K
 * <p>
 * Example
 * Input:
 * 2 3
 * 1 2 3
 * 1 2 3
 * 3
 * <p>
 * Output:
 * 3
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:47
 */
public class GivenAMatrixANMOfIntegers
{
    public static int prodSubMat(int[][] matA, int maxK) {
        int rows = matA.length;
        int cols = matA[0].length;
        int answer = 0;

        // colProduct[j] = 从 (0,0) 到当前行 i 的第 j 列乘积
        long[] colProduct = new long[cols];
        Arrays.fill(colProduct, 1);

        for (int i = 0; i < rows; i++) {
            // 更新列乘积
            for (int j = 0; j < cols; j++) {
                colProduct[j] *= matA[i][j];
            }

            // 从左往右扩展子矩阵
            long product = 1;
            for (int j = 0; j < cols; j++) {
                product *= colProduct[j];
                if (product <= maxK) {
                    answer++;
                } else {
                    break; // 超过 maxK，后面只会更大
                }
            }
        }

        return answer;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // input for matA
        int matA_row = in.nextInt();
        int matA_col = in.nextInt();
        int[][] matA = new int[matA_row][matA_col];

        for (int idx = 0; idx < matA_row; idx++)
        {
            for (int jdx = 0; jdx < matA_col; jdx++)
            {
                matA[idx][jdx] = in.nextInt();
            }
        }

        // input for maxK
        int maxK = in.nextInt();

        // Call the function to calculate the number of valid submatrices
        int result = prodSubMat(matA, maxK);

        // Output the result
        System.out.println(result);
    }
}
