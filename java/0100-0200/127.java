class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordDict = new HashSet<>();
        for (String s : wordList) {
            wordDict.add(s);
        }
        return BFS(beginWord, endWord, wordDict);
    }
    
    public int BFS(String beginWord, String endWord, HashSet<String> dict) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                ArrayList<String> neighbor = findNeighbor(curr, dict);
                
                for (String s : neighbor) {
                    if (s.equals(endWord)) {
                        return level;
                    }
                    if (!visited.contains(s)) {
                        visited.add(s);
                        queue.offer(s);
                    }
                }
            }
        }
        return 0;
    }
    
    public ArrayList<String> findNeighbor(String curr, HashSet<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < curr.length(); i++) {
            char[] arr = curr.toCharArray();
            for (int j = 0; j < 26; j++) {
                arr[i] = (char)('a' + j);
                String s = new String(arr);
                if (dict.contains(s))
                    res.add(s);
            }
        }
        return res;
    }
}
