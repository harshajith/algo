package com.harsha.cs.sort;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.*;
import java.util.stream.*;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED


/**
 *
 */
class AmazonTest
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int n = states.length;
        boolean previous = false;
        boolean last = false;

        for(int d=0; d<days; d++) {
            boolean[] results = new boolean[n];
            for(int i=0; i< n; i++){
                if(i == 0){ // first index
                    results[i] = previous ^ convertToBoolean(states[i+1]);
                }else if(i == n - 1){ // last index
                    results[i] = convertToBoolean(states[i-1]) ^ last;
                } else {
                    results[i] = convertToBoolean(states[i-1]) ^ convertToBoolean(states[i+1]);
                }
            }
            updateState(states, results);
        }

        return Arrays.stream(states).boxed().collect(Collectors.toList());

    }

    public void updateState(int[] status, boolean[] results){
        for(int i=0; i< results.length; i++){
            status[i] = convertToInt(results[i]);
        }
    }


    // METHOD SIGNATURE ENDS

    public boolean convertToBoolean(int val){
        if(val == 0) return false;
        else if(val == 1) return true;
        else {
            throw new RuntimeException("invalid state found");
        }
    }

    public int convertToInt(boolean val){
        if(val) return 1;
        else return 0;
    }


}