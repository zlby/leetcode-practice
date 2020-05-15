class Solution {
    /*
    calculate left total product and right total product
    output[i] = left[i-1] * right[i+1]
    then we can use res to store left, and use a single integer to store right
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < res.length-1; i++) {
            res[i] = res[i-1] * nums[i];
        }
        int right = 1;
        for (int i = res.length-1; i > 0; i--) {
            res[i] = right * res[i-1];
            right *= nums[i];
        }
        res[0] = right;
        return res;
    }
}
