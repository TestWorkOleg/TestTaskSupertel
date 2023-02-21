import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;


public class PortTest {
    @Test
    public void testParseIndexes() {
        Port port = new Port(new String[]{"1,3-5", "2", "3-4"});
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 3, 4, 5),
                Arrays.asList(2),
                Arrays.asList(3, 4)
        );
        assertEquals(expected, port.parseIndexes());
    }

    @Test
    public void testGetOrderedPairs() {String[] indexes = {"1-2", "5", "7-8"};
        Port port = new Port(indexes);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 5, 7));
        expected.add(Arrays.asList(1, 5, 8));
        expected.add(Arrays.asList(2, 5, 7));
        expected.add(Arrays.asList(2, 5, 8));
        List<List<Integer>> actual = port.getOrderedPairs();
        assertEquals(expected, actual);
    }
}