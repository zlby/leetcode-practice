class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = buildGraph(flights, n);
        return findPath(graph, src, dst, K);
    }
    
    public int[][] buildGraph(int[][] flights, int n) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int des = flights[i][1];
            int weight = flights[i][2];
            graph[src][des] = weight;
        }
        return graph;
    }
    
    public int findPath(int[][] graph, int src, int des, int k) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ArrayList<Node> neighbors = findNeighbor(graph, src, 0, 0);
        for (Node neighbor : neighbors) {
            pq.offer(neighbor);
        }
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.des == des) {
                return curr.val;
            }
            if (curr.stop >= k+1) {
                continue;
            }
            neighbors = findNeighbor(graph, curr.des, curr.stop, curr.val);
            for (Node neighbor : neighbors) {
                pq.offer(neighbor);
            }
        }
        return -1;
    }
    
    public ArrayList<Node> findNeighbor(int[][] graph, int src, int stop, int val) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[src][i] > 0) {
                neighbors.add(new Node(src, i, graph[src][i] + val, stop+1));
            }
        }
        return neighbors;
    }
    
    class Node{
        int src;
        int des;
        int val;
        int stop;
        Node(int src, int des, int val, int stop) {
            this.src = src;
            this.des = des;
            this.val = val;
            this.stop = stop;
        }
    }
}


