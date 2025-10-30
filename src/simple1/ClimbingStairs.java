// https://leetcode.com/problems/climbing-stairs/description/?envType=problem-list-v2&envId=rabvlt31
package simple1;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;  // Ways to climb 1 step
        int second = 2; // Ways to climb 2 steps

        for (int i = 3; i <= n; i++) {
            int current = first + second; // Ways to climb current step
            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        int n1 = 2;
        System.out.println("Number of ways to climb " + n1 + " steps: " + cs.climbStairs(n1)); // Output: 2

        int n2 = 5;
        System.out.println("Number of ways to climb " + n2 + " steps: " + cs.climbStairs(n2)); // Output: 8
    }
}
