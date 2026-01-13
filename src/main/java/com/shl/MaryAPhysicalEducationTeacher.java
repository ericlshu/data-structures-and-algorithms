package com.shl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2026-01-13 17:39
 */
public class MaryAPhysicalEducationTeacher
{
    // Mary,a physical education teacher, divides her students into different groups and assigns an ID to each group,
    // For the group 1D, she asks the students to stand in a queue, Each student in the class has a performance factor (PFR).
    // She assigns scores to the students in an unusual way based on their PFR. She gives a score of S to a student behind whom Is standing at least one student with a higher PFR,
    // behind whom is standing at least one student with a smaller PFR.lext, she gives a score of 10 to a student behind whom is standing a student with a higher PFR,
    // behind whom no student with smaller PFR is standing,
    // Finally, she gives a score of 15 to a student behind whom is standing no student with a higher PFR.
    // The group 1D is the sum of scores of the students in the group
    // Write an algorithm to find the group ID of a group of students
    //
    // Input
    // The first line of the input consists of an integer num,representing the number of students in a group,
    // The second line consists of N space separated integers -listPFR[0], listPFR[1], ....... listPFR[n-1] representing the PFR of the students in the order in which they are standing in the queue,

    // Output
    // Print an integer representing the group ID of the group of students

    // Example
    // Input:
    // 6
    // 1 4 5 2 7 8
    // Output
    // 55

    // Explanation:
    // The student with a PFR 1 has a student with a PFR 4 next to him/her, and a student with a PFR 2 is standing behind the a higher PFR student,
    // So, Mary gives a score of 5 to the first student,Similarly, a score of 5 has been granted to the student with the pFR 4.
    // The student with a PFR S has a student with a PFR 7 standing behind him/her and there is np student with a smalled
    // PFR standing behind that higher PFR student,
    // So, Mary gives a score of 10 to the student with PFR 5.
    // Similarly,she gives a score of 10 to the students with the PFR 2 and 7,
    // The student with a PFR 8 does not have any higher PFR student behind him/ner, So, Mary assigns this student, a score of 15.
    // Thus,the group 1D =55(5+5+10+10+10+15).
    // So,the output is 55.So,the output is 55.

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int listPFR_size = in.nextInt();
        int[] listPFR = new int[listPFR_size];
        for (int idx = 0; idx < listPFR_size; idx++)
        {
            listPFR[idx] = in.nextInt();
        }
        int result = findGroupID(listPFR);
        System.out.print(result);
    }

    public static int findGroupID(int[] listPFR)
    {
        int n = listPFR.length;
        int answer = 0;

        // Step 1: Next Greater Element to the right
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && listPFR[stack.peek()] <= listPFR[i])
            {
                stack.pop();
            }
            if (!stack.isEmpty())
            {
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }

        // Step 2: Suffix minimum
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = listPFR[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            suffixMin[i] = Math.min(suffixMin[i + 1], listPFR[i]);
        }

        // Step 3: Calculate score
        for (int i = 0; i < n; i++)
        {
            int j = nextGreater[i];

            // No higher PFR behind
            if (j == -1)
            {
                answer += 15;
            }
            else
            {
                // Check if there is a smaller PFR behind j
                if (j + 1 < n && suffixMin[j + 1] < listPFR[j])
                {
                    answer += 5;
                }
                else
                {
                    answer += 10;
                }
            }
        }
        return answer;
    }
}
