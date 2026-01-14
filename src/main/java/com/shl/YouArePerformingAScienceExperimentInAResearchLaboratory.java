package com.shl;

import java.util.Scanner;

/**
 * Description :
 * <p>
 * You are performing a science experiment in a research laboratory.You are attempting to form a new compound.
 * A compound is made up of molecules and the mass of the compound is the sum of the masses of the molecules that compose the compound,
 * For this experiment, you have identified four types of molecules: A, B, C and D
 * From these four molecules A and B.aremontomic but C and D are diatomic mass of a diatoric molecule is twice its atomic mass while the mass of a monotonic molecule is equal to its atomic mass.
 * You have to form a compound Xof mass Q using the maximum number of molecules,
 * <p>
 * Input
 * The first line of the input consists of an integer-atomicMassA representing the atomic mass of atom A.
 * The second line consists of an integer -atomicMassB, representing the atomic mass of atom B.
 * The third ine consists of an integer- atomicMassC, representing the atomic mass of atom C.
 * The fourth line consists of an integer - atomicMassD, representing the atomic mass of atom D.
 * The last line consists of an integer -atomicMassx representing the atomic mass of compound X
 * <p>
 * Output
 * Print an integer representing the maximum number of molecules that can be used to form compound X
 * <p>
 * Example
 * Input
 * 5
 * 8
 * 5
 * 3
 * 23
 * Output
 * 4
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:58
 */
public class YouArePerformingAScienceExperimentInAResearchLaboratory
{
    public static int numMolecules(int atomicMassA, int atomicMassB, int atomicMassC, int atomicMassD, int atomicMassX)
    {
        int[] masses = {
                atomicMassA,
                atomicMassB,
                atomicMassC * 2,
                atomicMassD * 2
        };

        // dp[i] = 组成质量 i 的最大分子数，-1 表示不能组成
        int[] dp = new int[atomicMassX + 1];
        for (int i = 1; i <= atomicMassX; i++)
        {
            dp[i] = -1; // 初始化为不可达
        }
        dp[0] = 0; // 质量为0时，分子数量是0

        for (int i = 0; i <= atomicMassX; i++)
        {
            if (dp[i] != -1)
            { // 如果当前质量可达
                for (int mass : masses)
                {
                    if (i + mass <= atomicMassX)
                    {
                        dp[i + mass] = Math.max(dp[i + mass], dp[i] + 1);
                    }
                }
            }
        }
        return dp[atomicMassX] == -1 ? 0 : dp[atomicMassX];
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int atomicMassA = in.nextInt();
        int atomicMassB = in.nextInt();
        int atomicMassC = in.nextInt();
        int atomicMassD = in.nextInt();
        int atomicMassX = in.nextInt();

        int result = numMolecules(atomicMassA, atomicMassB, atomicMassC, atomicMassD, atomicMassX);
        System.out.print(result);
    }
}
