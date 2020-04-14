package com.harsha.cs.mnj;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * BFS with all paths to destination
 */
public class BFSWithAllPathsToDestination {

    public ArrayList<ArrayList<Integer>> findAllPaths(ArrayList<ArrayList<Integer> > graph, int src, int dest){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<ArrayList<Integer>> queue = new LinkedList<>();

        ArrayList<Integer> first = new ArrayList<>();
        first.add(src);
        queue.add(first);

        while(!queue.isEmpty()){
            ArrayList<Integer> path = queue.poll();
            Integer node = path.get(path.size()-1); // get the last node from the list
            if(node == dest){
                result.add(path);
            }else {
                ArrayList<Integer> adjList = graph.get(node);
                for(Integer adj: adjList){
                    if(!path.contains(adj)){
                        ArrayList<Integer> newPath = new ArrayList<>();
                        newPath.addAll(path);
                        newPath.add(adj);
                        queue.add(newPath);
                    }
                }
            }
        }
        return result;
    }


    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer> > adj  = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        BFSWithAllPathsToDestination BFSWithAllPathsToDestination = new BFSWithAllPathsToDestination();
        ArrayList<ArrayList<Integer>> result = BFSWithAllPathsToDestination.findAllPaths(adj, 1, 3);

        for(ArrayList<Integer> path: result){
            StringBuilder sb = new StringBuilder();
            for(Integer node: path){
                sb.append(node);
                sb.append("->");
            }
            sb.delete(sb.length()-2, sb.length());
            System.out.println(sb.toString());
        }
    }

}
