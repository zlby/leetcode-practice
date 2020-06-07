class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = findFirst(nums, 0, nums.length-1, target);
        res[1] = findLast(nums, 0, nums.length-1, target);
        return res;
    }

    /**
     * If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
     * If A[mid] > target, it means the range must begins on the left of mid (j = mid-1)
     * If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
     */
    public int findFirst(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            right = mid;
        }
        return findFirst(nums, left, right, target);
    }

    /**
     * If A[mid] > target, then the range must begins on the left of mid (j = mid-1)
     * If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
     * If A[mid] = target, then the range must begins on the right of or at mid (i= mid)
     */
    public int findLast(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }
        if (left > right) {
            return -1;
        }
        int mid = (left + right + 1) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid;
        }
        return findLast(nums, left, right, target);
    }
}
