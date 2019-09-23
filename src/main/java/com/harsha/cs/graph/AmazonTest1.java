package com.harsha.cs.graph;

import com.harsha.cs.treechallenge.TreeNode;

import java.util.*;


/**
 * Find the first two deliveries based on minimum cost of the distance
 * input: {1,2}, {3,4}, {1,-1},{5,6}, {1,1}
 * output:
 */
public class AmazonTest1 {

    static Map<Node, List<Node>> graph = new HashMap<>();
    static List<List<Integer>> orderedLocations = new ArrayList<>();

    private static class Node{
        int id;
        List<Integer> location;
        public Node(int i, List<Integer> location){
            this.id = i;
            this.location = location;
        }
    }

    public static void main(String[] args){
        List<Node> nodeList = new ArrayList<>();
        List<List<Integer>> allLocations = new ArrayList<>();

        List<Integer> l1 = Arrays.asList(1,2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(1,-1);
        List<Integer> l4 = Arrays.asList(5,6);
        List<Integer> l5 = Arrays.asList(1,1);

        allLocations.add(l1);
        allLocations.add(l2);
        allLocations.add(l3);
        allLocations.add(l4);
        allLocations.add(l5);

        for(int i=1; i<= allLocations.size();i++){
                    Node newNode = new Node(i, allLocations.get(i-1));
                    nodeList.add(newNode);
        }
        List<Integer> truckStartLocation = Arrays.asList(0,0);
        Node truckStart = new Node(0, truckStartLocation);
        nodeList.add(truckStart);

        int destinations = 4;
        int deliveries = 2;

        //build the graph
        for(Node node: nodeList){
            int id = node.id;
            graph.put(node, getAdjacentNodes(node, nodeList));
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        dfs(truckStart, visited);

        for(int k=0; k<deliveries; k++){
            System.out.println(Arrays.toString(orderedLocations.get(k).toArray()));
        }

    }



    private static void dfs(Node root, Map<Integer, Boolean> visited){
        orderedLocations.add(root.location);
        visited.put(root.id, true);
        Iterator<Node> i = graph.get(root).listIterator();

        while(i.hasNext()){
            Node n = i.next();
            if(visited.get(n.id) == null || visited.get(n.id) == false){
                dfs(n, visited);
            }
        }
    }


    /**
     * Get adjacent nodes to the given node
     * @param node
     * @param nodeList
     * @return
     */
    private static List<Node> getAdjacentNodes(Node node, List<Node> nodeList) {
        TreeMap<Double, Node> sortedMap = new TreeMap<>();

        for(Node nextNode: nodeList){
            if(nextNode.id != node.id){ // if not the same node
                sortedMap.put(getDistance(node, nextNode), nextNode);
            }
        }
        List<Node> adj = new ArrayList<>(sortedMap.values());
        return adj;
    }


    public static double getDistance(Node start, Node end){
        List<Integer> s = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        if(!start.equals(end)){
            s = start.location;
            e = end.location;
        }
        int x = s.get(1) - e.get(1);
        int y = s.get(0) - e.get(0);
        return Math.sqrt(x*x + y*y);
    }
}
