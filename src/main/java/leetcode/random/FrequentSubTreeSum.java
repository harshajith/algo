package leetcode.random;


import java.util.*;
import java.util.LinkedList;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class FrequentSubTreeSum {


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-3);

        n1.left = n2;
        n1.right = n3;

        FrequentSubTreeSum solution = new FrequentSubTreeSum();
        int[] frequentSums = solution.findFrequentTreeSum(n1);
        for(int i: frequentSums){
            System.out.println(i);
        }

    }
    static class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){ // O(n)
            TreeNode node = queue.poll();
            int subtreeSum = sum(node);
            if(map.get(subtreeSum) != null){
                map.put(subtreeSum, map.get(subtreeSum)+1);
            }else {
                map.put(subtreeSum, 1);
            }

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }


        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() { // nlog(n)
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        List<Integer> result = new ArrayList<>();

        int highestFrequency = -1;
        for(Map.Entry<Integer, Integer> entry: list){ // O(n)
            if(highestFrequency == -1){
                result.add(entry.getKey());
                highestFrequency = entry.getValue();
            }else {
                if(highestFrequency == entry.getValue()){
                    result.add(entry.getKey());
                }
            }
        }

        int[] arr = result.stream().mapToInt(i->i).toArray();
        return arr;

    }

    public int sum(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val; //if leaf node

        return root.val + sum(root.left) + sum(root.right);

    }

}
