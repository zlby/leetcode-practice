class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> numsStr = new ArrayList<>();
        for (int num : nums) {
            numsStr.add(String.valueOf(num));
        }
        Collections.sort(numsStr, (a,b) -> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for (String s : numsStr) {
            sb.append(s);
        }
            
        //remove leading 0
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }
}
