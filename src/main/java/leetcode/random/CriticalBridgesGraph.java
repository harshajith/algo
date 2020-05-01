package leetcode.random;


import java.util.*;
import java.util.LinkedList;

/**
 * 1192. Critical Connections in a Network
 * Hard
 *
 * 843
 *
 * 68
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
 */
public class CriticalBridgesGraph {

    int time = 0;
    LinkedList<Integer> graph[];

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> criticalConnections = new ArrayList<>();
        graph = new LinkedList[n]; // make the graph with adjacency list.
        for(int i=0; i<n; i++){
            graph[i] = new LinkedList<>();
        }

        for(List<Integer> connection: connections){
            int x = connection.get(0);
            int y = connection.get(1);

            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = -1;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                bridgeUtil(i, visited, disc, low, parent, criticalConnections);
            }
        }
        return criticalConnections;
    }

    public void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[], List<List<Integer>> criticalConnections){

        visited[u] = true;
        disc[u] = low[u] = ++time;
        Iterator<Integer> i = graph[u].iterator();
        while (i.hasNext()) {
            int v = i.next();  // v is current adjacent of u
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent, criticalConnections);

                low[u]  = Math.min(low[u], low[v]);
                if (low[v] > disc[u]){
                    criticalConnections.add(Arrays.asList(Math.min(u,v), Math.max(u,v)));
                }
            } else if (v != parent[u]) {
                low[u]  = Math.min(low[u], disc[v]);
            }
        }
    }
}
