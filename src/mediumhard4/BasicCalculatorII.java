// https://leetcode.com/problems/basic-calculator-ii/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.Stack;

public class BasicCalculatorII {
	//BasicCalculatorII
	public int calculate(String s) {
        int len = s.length();
        int cur = 0, prev = 0, res = 0;
        char curOperation = '+';
        
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            
            if (Character.isDigit(curChar)) {
                cur = cur * 10 + (curChar - '0');
            }
            
            if (!Character.isDigit(curChar) && curChar != ' ' || i == len - 1) {
                if (curOperation == '+') {
                    res += cur;
                    prev = cur;
                } else if (curOperation == '-') {
                    res -= cur;
                    prev = -cur;
                } else if (curOperation == '*') {
                    res -= prev;
                    prev *= cur;
                    res += prev;
                } else if (curOperation == '/') {
                    res -= prev;
                    prev /= cur;
                    res += prev;
                }
                
                curOperation = curChar;
                cur = 0;
            }
        }
        
        return res;
    }

    // Test code to run in Eclipse IDE
    public static void main(String[] args) {
        BasicCalculatorII calculator = new BasicCalculatorII();

        System.out.println(calculator.calculate("3+2*2"));  // Output: 7
        System.out.println(calculator.calculate(" 3/2 "));  // Output: 1
        System.out.println(calculator.calculate(" 3+5 / 2 ")); // Output: 5
    }
}
