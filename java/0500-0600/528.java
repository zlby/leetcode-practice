import java.util.Random;

/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    Random random;
    int[] wSum;

    public Solution(int[] w) {
        random = new Random();
        wSum = new int[w.length];
        wSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            wSum[i] = w[i] + wSum[i-1];
        }
    }
    
    public int pickIndex() {
        int ind = random.nextInt(wSum[wSum.length-1])+1;
        int left = 0;
        int right = wSum.length-1;
        // binary search
        while (left < right) {
            int mid = (left + right) / 2;
            if (wSum[mid] == ind) {
                return mid;
            } else if (wSum[mid] < ind) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end


