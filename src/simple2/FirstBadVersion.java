// https://leetcode.com/problems/first-bad-version/description/?envType=problem-list-v2&envId=rabvlt31

package simple2;

public class FirstBadVersion {
    private int badVersion;

    // Constructor for setting the first bad version for testing
    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    // Mock API: returns true if version is bad
    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;  // mid might be the first bad version
            } else {
                left = mid + 1;  // look in the higher half
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 5;
        int bad = 4;
        FirstBadVersion solution = new FirstBadVersion(bad);

        int firstBad = solution.firstBadVersion(n);
        System.out.println("First bad version: " + firstBad);  // Output: 4
    }
}

