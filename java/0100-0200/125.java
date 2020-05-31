class Solution {
    public boolean isPalindrome(String s) {

        if (s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
           
            while (i < j && !checkchar(Character.toLowerCase(s.charAt(i)))) i++;
            while (j > i && !checkchar(Character.toLowerCase(s.charAt(j)))) j--;
            
            //char a = Character.toLowerCase(s.charAt(i));
            
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean checkchar(char c) {
        // letter
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        
        // numeric
        if (c >= '0' && c <= '9') {
            return true;
        }
        
        return false;
    }
}
