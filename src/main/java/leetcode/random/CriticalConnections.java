package leetcode.random;


import java.util.*;

/**
 * 1192. Critical Connections in a Network
 * Hard
 *
 * 835
 *
 * 67
 *
 * Add to List
 *
 * Share
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 */
public class CriticalConnections {

    List<List<Integer>> list;
    Map<Integer, Boolean> visited;

    /**
     * This is a brute-force solution and will not be optimum.
     * It checks if you can traverse to all the nodes if it is removed.
     * @param n
     * @param connections
     * @return
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(List<Integer> connection : connections){ // create the graph.
            int u = connection.get(0);
            int v = connection.get(1);
            if(adj.get(u) == null){
                adj.put(u,new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if(adj.get(v) == null){
                adj.put(v,new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }

        list = new ArrayList<>();
        for(int i =0;i<n;i++){
            visited = new HashMap<>();
            List<Integer> p = connections.get(i);
            int x = p.get(0);
            int y = p.get(1);
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj,1);
            if(visited.size()!=n){
                if(p.get(0) > p.get(1))
                    list.add(Arrays.asList(p.get(1), p.get(0)));
                else
                    list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }



    public void DFS(Map<Integer, HashSet<Integer>> adj, int u){
        visited.put(u, true);
        if(adj.get(u).size()!=0){
            for(int v : adj.get(u)){
                if(visited.getOrDefault(v, false)== false){
                    DFS(adj,v);
                }
            }
        }
    }
}
