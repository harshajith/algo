package aws.s3;


import java.util.*;

/**
 * There are N cities numbered from 1 to N.
 *
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 *
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 */
public class ConnectCities {

    int N = 0; // number of nodes
    Map<Node, List<Node>> graph = new HashMap<>();


    public static void main(String[] args){
        int[][] connections = new int[][]{
                {1,2,5},
                {1,3,6},
                {2,3,1}
        };
        ConnectCities cities = new ConnectCities();
        cities.minimumCost(3, connections);
    }

    public int minimumCost(int N, int[][] connections) {
        this.N = N;
        for(int i=0; i<connections.length; i++){
            int city1 = connections[i][0];
            int city2 = connections[i][1];
            int cost = connections[i][2];
            addEdge(city1, city2, cost);
        }

        mst();
        return 0;
    }

    static class Node{
        int id;
        int weight;


        Node(int id, int weight){
            this.id = id;
            this.weight = weight;
        }
    }



    private void addEdge(int fromId, int toId, int weight){
        Node from = new Node(fromId, weight);
        Node to = new Node(toId, weight);

        List<Node> adjList = graph.get(from); // add to fromList
        if(adjList == null){
            adjList = new ArrayList<>();
            adjList.add(to);
        }else {
            if(!adjList.contains(to)){
                adjList.add(to);
            }
        }
        graph.put(from, adjList);
        List<Node> adjList1 = graph.get(to); // add to to List
        if(adjList1 == null){
            adjList1 = new ArrayList<>();
            adjList1.add(from);
        }else {
            if(!adjList1.contains(from)){
                adjList1.add(from);
            }
        }
        graph.put(to, adjList1);
    }

    static class SortableNode{
        int id;
        int key;
        SortableNode(int id){
            this.id = id;
            key = Integer.MAX_VALUE;
        }
    }

    Comparator<SortableNode> comparator = new Comparator<SortableNode>() {
        @Override
        public int compare(SortableNode o1, SortableNode o2) {
            return o1.key - o2.key;
        }
    };


    private void mst(){
        SortableNode[] nodes = new SortableNode[N+1];
        Boolean[] inMst = new Boolean[N+1];

        int[] parent = new int[N+1];

        for(Node n: graph.keySet()){
            SortableNode sn = new SortableNode(n.id);
            nodes[n.id] = sn;
        }

        SortableNode sn = nodes[0];
        sn.key = 0;

        TreeSet<SortableNode> treeSet = new TreeSet<>(comparator);
        for(SortableNode s: nodes){
            treeSet.add(s);
        }

        while(!treeSet.isEmpty()){
            SortableNode node = treeSet.pollFirst();
            inMst[node.id] = true;
            List<Node> adjList = graph.get(node.id);
            for(Node adjNode: adjList){
                if(inMst[adjNode.id] == false && nodes[adjNode.id].key > adjNode.weight){
                    treeSet.remove(nodes[adjNode.id]);
                    nodes[adjNode.id].key = adjNode.weight;
                    treeSet.add(nodes[adjNode.id]);
                    parent[adjNode.id] = node.id;
                }
            }
        }

        for(int i=1; i< parent.length; i++){
            System.out.println(i + "-" + parent[i]);
        }
    }


}
