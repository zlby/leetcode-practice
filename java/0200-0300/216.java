class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<Integer>(), 1, k, n);  
        return res;
    }
    
    public void backtracking(List<List<Integer>> res, List<Integer> chosen, int start, int k, int remain) {
        if (remain == 0 && k == 0) {
            res.add(new ArrayList<Integer>(chosen));
            return;
        }
        if (remain == 0) {
            return;
        }
        if (k == 0) {
            return;
        }
        
        
        for (int i = start; i <= Math.min(9, remain); i++) {
            // choose one possible item
            chosen.add(i);
            
            // explore
            backtracking(res, chosen, i+1, k-1, remain-i);
        
            // unchoose it
            chosen.remove(chosen.size()-1);
        }
    }
}
