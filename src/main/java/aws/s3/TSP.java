package aws.s3;

import org.openjdk.jmh.util.IntervalMap;

import java.util.*;
import java.util.LinkedList;

public class TSP {

    Map<Integer, TreeSet<Node>> graph;

    static class Node{
        int id;
        int weight;

        Node(int id, int weight){
            this.id = id;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight - o2.weight;
        }
    };

    private List<Integer> findPathWithMinimalCost(){

        List<Integer> path = new ArrayList<>();
        path.add(0);
        TreeSet<Node> adjNodes = graph.get(0);

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(adjNodes.first()); // lowest value

        while(!queue.isEmpty()){
            Node node = queue.poll(); // give the shortest node, greedily
            if(!path.contains(node.id)){
                path.add(node.id);

                TreeSet<Node> neighbours = graph.get(node.id);

                for(Integer i: path){ // remove the current node link from neighbours adjacent nodes, as we already put it in path.
                    if(i != node.id){
                        neighbours.remove(new Node(i, getWeight(node.id, i)));
                    }
                }

                if(!neighbours.isEmpty() && path.size() != graph.size()){
                    queue.add(neighbours.first());
                }
            }
        }
        return path;
    }

    private int getWeight(int src, Integer dest) {
        TreeSet<Node> adj = graph.get(src);
        int weight = 0;
        for(Node node: adj){
            if(Integer.valueOf(node.id).equals(dest)){
                weight = node.weight;
            }
        }
        return weight;
    }

    private void addEdge(int src, int dest, int weight){
        TreeSet<Node> adj = graph.get(src); // neighbours
        Node adjNode = new Node(dest, weight);
        if(adj != null){
            adj.add(adjNode);
        }else {
            adj = new TreeSet<>(comparator);
            adj.add(adjNode);
            graph.put(src, adj);
        }
    }

    private void createGraph(){
        graph = new HashMap<>();

        addEdge(0, 1, 20);
        addEdge(1, 0, 20);

        addEdge(0, 2, 34);
        addEdge(2, 0, 34);

        addEdge(1, 2, 10);
        addEdge(2, 1, 10);

        addEdge(1, 3, 40);
        addEdge(3, 1, 40);

        addEdge(2, 3, 35);
        addEdge(3, 2, 35);

        addEdge(3, 7, 30);
        addEdge(7, 3, 30);

        addEdge(3, 6, 50);
        addEdge(6, 3, 50);

        addEdge(6, 7, 40);
        addEdge(7, 6, 40);
    }

    public static void main(String[] args){
        TSP tsp = new TSP();
        tsp.createGraph();

        List<Integer> shortestPath = tsp.findPathWithMinimalCost();
        System.out.println(shortestPath.toString());

    }



}
