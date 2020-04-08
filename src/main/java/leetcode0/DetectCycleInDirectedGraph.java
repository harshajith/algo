package leetcode0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class DetectCycleInDirectedGraph {

    // Driver code
    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }

    static class Graph{
        int V; // number of nodes in graph
        List<List<Integer>> adj;

        Graph(int v){
            this.V = v;
            adj = new ArrayList<>(V);
            for(int i=0; i<V; i++){ // each node contains adjacent list
                adj.add(new LinkedList<>());
            }
        }

        /**
         * Directed graph will have edges only in one direction
         * @param source
         * @param dest
         */
        private void addEdge(int source, int dest){
            adj.get(source).add(dest);
        }

        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){


            if(recStack[i]) return true;
            if(visited[i]) return false;

            visited[i] = true;
            recStack[i] = true;

            List<Integer> children = adj.get(i);
            for(Integer ch: children){
                if(isCyclicUtil(ch, visited, recStack)){
                    return true;
                }
            }
            recStack[i] = false;
            return false;
        }

        private boolean isCyclic(){

            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            for(int i=0; i<V; i++){
                if(isCyclicUtil(i, visited, recStack)){
                    return true;
                }
            }
            return false;
        }


    }
}
