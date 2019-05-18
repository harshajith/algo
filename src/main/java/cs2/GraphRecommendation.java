package cs2;

import java.util.*;

/**
 * Created by Harsha on 2/10/16.
 */
public class GraphRecommendation {

    private static Map<String, List<String>> customerCarts = new HashMap<>();


    static int[] determineRecommendation(String itemId, String[] purchases) {

        int[] result = new int[2];
        if(purchases == null || purchases.length <1){
            return result;
            //throw new NullPointerException("purchases are empty, no recommendation is possible");
        }


        Set<String> uniqueItems = new HashSet(); // get unique item list
        for(int i=0; i<purchases.length; i++){ // populate unique item List and customerCarts

            if(purchases[i] != null && !purchases[i].isEmpty()){
                String[] mapping = purchases[i].split(":");
                uniqueItems.add(mapping[1]);

                List<String> itemList = customerCarts.get(mapping[0]); // check if customer cart is present
                if(itemList == null){
                    itemList = new ArrayList<>();
                    customerCarts.put(mapping[0],itemList);
                }
                itemList.add(mapping[1]);
            }


        }

        Map<String, List<String>> adjacentMap = new HashMap<>(); // for each item, store the adjacent list

        for(String s : uniqueItems){
            adjacentMap.put(s, new ArrayList<String>());
            for(String x : uniqueItems){
                if(!s.equals(x)){
                    boolean connected = checkIfConnected(s, x);
                    if(connected){
                        adjacentMap.get(s).add(x); //populate adjacent lists to each element.
                    }
                }
            }
        }

        //check Strong connections
        List<String> adjacentList = adjacentMap.get(itemId); // original AdjList
        List<String> weakConnections = new ArrayList<String>();

        if(adjacentList != null && !adjacentList.isEmpty()){
            for(String x : adjacentList){ // traverse through each adj element to figure out weak connections.
                List<String> adjToAdjList = adjacentMap.get(x);
                for(String newAdj: adjToAdjList){
                    if(!newAdj.equals(itemId) && !newAdj.equals(x) && !adjacentList.contains(newAdj) && !weakConnections.contains(newAdj)){
                        weakConnections.add(newAdj);
                    }
                }
            }
        }


        int strongCons = adjacentList != null ? adjacentList.size() : 0;
        int weakCons = weakConnections.size();
        result[0] = strongCons;
        result[1] = weakCons;
        return result;

    }


    public static boolean checkIfConnected(String a, String b){

        if(!customerCarts.isEmpty()){
            for(String key : customerCarts.keySet()){ // loop through the customer base to figure out if given two items are connected

                List<String> purchaseItems = customerCarts.get(key);
                if(purchaseItems.contains(a) && purchaseItems.contains(b)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args){

        String[] purchases = {"first:ABC", "first:HIJ", "sec:HIJ", "sec:KLM", "third:NOP","fourth:ABC", "fourth:QRS","first:DEF", "fifth:KLM", "fifth:TUV"};
        int[] result = determineRecommendation("ABC", purchases);
        System.out.println("result :" + result[0] + " : " + result[1]);
    }

}
