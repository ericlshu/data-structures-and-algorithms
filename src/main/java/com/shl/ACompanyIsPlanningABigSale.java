package com.shl;

import java.util.Scanner;

/**
 * Description :
 * A company is planning a big sale at which they will give their customers a special promotional discount,
 * Each customer that purchases a product from the company has a unique customer id numbered from O to N-1.
 * Andy, the marketing head of the company, has selected bill amounts of the N customers for the promotional scheme.
 * The discount will be given to the customers whose bill amounts are perfect squares,
 * The customers may use this discount on a future purchase.
 * <p>
 * Write an algorithm to help Andy find the number of customers that will be given discounts,
 * <p>
 * Input
 * The first line of the input consists of an integer numOfCust, representing the number of customers whose bills are selected for the promotional discount (N).
 * The second line consists of N space-separated integers-billa bill..., blly, representing the bill amounts of the N customers selected for the promotional discount,
 * <p>
 * Output
 * Print an integer representing the number of customers that will be given discounts,
 * <p>
 * Example
 * Input:
 * 6
 * 25 77 54 81 48 34
 * <p>
 * Output
 * 2
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:43
 */
public class ACompanyIsPlanningABigSale
{
    public static int countCustomers(int[] bill)
    {
        int answer = 0;
        for (int b : bill) {
            int root = (int) Math.sqrt(b);
            if (root * root == b) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // input for bill
        int bill_size = in.nextInt();
        int bill[] = new int[bill_size];
        for (int idx = 0; idx < bill_size; idx++)
        {
            bill[idx] = in.nextInt();
        }

        int result = countCustomers(bill);
        System.out.print(result);
    }
}
