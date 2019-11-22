package aws.s3;


import java.util.*;

/**
 *An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 *
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 *
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * Example 2:
 *
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 *
 *
 * Note:
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
public class ShortestPathToVisitAllNodes {

        public static void main(String[] args){
            ShortestPathToVisitAllNodes solution = new ShortestPathToVisitAllNodes();

            int[][] graph = new int[][]{
                    {1},
                    {0,2,4},
                    {1,3,4},
                    {2},
                    {1,2}
            };
            int shortestPathLength = solution.shortestPathLength(graph);
            System.out.println(shortestPathLength);
        }

        int N;
        int[][] graph;

        public int shortestPathLength(int[][] graph) {

            if(graph == null || graph.length == 0) return 0;
            List<Integer> paths = new ArrayList<>();
            this.N = graph.length; // number of nodes
            this.graph = graph;
            for(int i=0; i<N; i++){
                int startNode = i;
                paths.add(dfs(i));
            }

            Collections.sort(paths);
            return paths.get(0);

        }
        // return the length to visit all the nodes
        private int dfs(int startNode){
            List<Integer> path = new ArrayList<>();
            Queue<Integer> queue = new java.util.LinkedList<Integer>();
            queue.add(startNode);
            boolean[] visited = new boolean[N];
            int[] parent = new int[N];
            parent[startNode] = -1;

            while(!queue.isEmpty()){
                int nodeId = queue.poll();
                path.add(nodeId);
                visited[nodeId] = true;

                int[] adjList = graph[nodeId];
                if(adjList != null && adjList.length != 0){
                    for(int adjId: adjList){
                        if(visited[adjId] == false){
                            queue.add(adjId);
                            visited[adjId] = true;
                        }
                    }
                }
            }
            for(int i: path){
                System.out.println(i);
            }
            System.out.println("=================");
            return path.size();
        }


}
