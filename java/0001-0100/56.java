class Solution {
    /*
    (s1, e1) (s2, e2) if e1 >= s2 merge them
    
    merge() {
        return s1, max(e1, e2)
    }
    
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        ArrayList<int[]> res = new ArrayList<>();
        
        int i = 0;
        int currEnd = -1;
        while (i < intervals.length) {
            if (currEnd >= intervals[i][0]) {
                merge(res, intervals[i]);
            } else {
                res.add(intervals[i]);
            }
            currEnd = res.get(res.size()-1)[1];
            i++;
        }
        
        int[][] result = new int[res.size()][2];
        
        for (int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }
    
    public void merge(ArrayList<int[]> res, int[] interval) {
        int[] des = res.remove(res.size()-1);
        des[1] = Math.max(des[1], interval[1]);
        res.add(des);
    }
}
