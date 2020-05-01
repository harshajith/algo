import leetcode.random.CriticalBridgesGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalBridgesTest {

    CriticalBridgesGraph criticalBridges = new CriticalBridgesGraph();

    @Test
    public void test1(){

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        List<List<Integer>> criticalCons = criticalBridges.criticalConnections(4, connections);

        assert 1 == criticalCons.size();
    }
}
