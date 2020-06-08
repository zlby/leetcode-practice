/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[] refund = new int[2*n];
        int total = 0;
        // fly all people to A
        for (int i = 0; i < 2 * n; i++) {
            refund[i] =  costs[i][1] - costs[i][0];
            total += costs[i][0];
        }
        // sort refund
        Arrays.sort(refund);
        // fly those n people to B with most refund
        for (int i = 0; i < n; i++) {
            total += refund[i];
        }
        return total;
    }
}
// @lc code=end


