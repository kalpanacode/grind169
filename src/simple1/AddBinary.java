// https://leetcode.com/problems/add-binary/description/?envType=problem-list-v2&envId=rabvlt31
package simple1;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            carry = sum > 1 ? 1 : 0;
            result.append(sum % 2);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();

        String a1 = "11", b1 = "1";
        System.out.println("Input: a = " + a1 + ", b = " + b1);
        System.out.println("Output: " + solution.addBinary(a1, b1)); // Expected: 100

        String a2 = "1010", b2 = "1011";
        System.out.println("Input: a = " + a2 + ", b = " + b2);
        System.out.println("Output: " + solution.addBinary(a2, b2)); // Expected: 10101
    }
}

