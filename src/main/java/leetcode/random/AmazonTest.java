package leetcode.random;

import java.util.*;

public class AmazonTest {


    public static void main(String[] args){

        List<List<Integer>> input1 = new ArrayList<>();
        List<List<Integer>> input2 = new ArrayList<>();

        Integer[] a = new Integer[]{1,3};
        Integer[] b = new Integer[]{2,5};
        Integer[] c = new Integer[]{3,7};
        Integer[] x = new Integer[]{4,10};


        Integer[] d = new Integer[]{1,2};
        Integer[] e = new Integer[]{2,3};
        Integer[] f = new Integer[]{3,4};
        Integer[] f1 = new Integer[]{4,5};

        input1.add(Arrays.asList(a));
        input1.add(Arrays.asList(b));
        input1.add(Arrays.asList(c));
        input1.add(Arrays.asList(x));

        input2.add(Arrays.asList(d));
        input2.add(Arrays.asList(e));
        input2.add(Arrays.asList(f));
        input2.add(Arrays.asList(f1));
        AmazonTest test = new AmazonTest();

        List<List<Integer>>  res = test.optimalUtilization(10, input1, input2);

        System.out.println(res);

    }

    Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if(o1.get(1) >= o2.get(1)){
                return 1;
            }else {
                return -1;
            }
        }
    };

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        // WRITE YOUR CODE HERE

        List<List<Integer>> result = new ArrayList<>();

        Collections.sort(foregroundAppList, comparator);
        Collections.sort(backgroundAppList, comparator);


        if(foregroundAppList.get(0).get(1) + backgroundAppList.get(0).get(1) > deviceCapacity) return result;

        int currentTotal = 0;

        List<List<Integer>> tmpResult = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int m = 0;
        int n = 0;
        boolean exactMatchFound = false;

        for(int i=0; i<foregroundAppList.size(); i++){
            for(int j=0; j<backgroundAppList.size(); j++){

                int sum = foregroundAppList.get(i).get(1) + backgroundAppList.get(j).get(1);
                if(sum <= deviceCapacity){
                    if(sum == currentTotal){
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(foregroundAppList.get(i).get(0));
                        tmpList.add(backgroundAppList.get(j).get(0));
                        tmpResult.add(tmpList);
                    }else if(sum > currentTotal){
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(foregroundAppList.get(i).get(0));
                        tmpList.add(backgroundAppList.get(j).get(0));
                        tmpResult = new ArrayList<>();
                        tmpResult.add(tmpList);
                        currentTotal = sum;
                    }
                }
            }
        }

        return tmpResult;
    }
}
