import static org.junit.Assert.*;
import org.junit.Test;

public class SalesDataUtilityTest {

    private double[][] sample = {
        {100.0, 200.0, 300.0},
        {50.0, 75.0},
        {400.0}
    };

    @Test
    public void testGetTotal() {
        double total = SalesDataUtility.getTotal(sample);
        assertEquals(1125.0, total, 0.001);
    }

    @Test
    public void testGetAverage() {
        double avg = SalesDataUtility.getAverage(sample);
        // 6 values total: (100+200+300+50+75+400)/6 = 187.5
        assertEquals(187.5, avg, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(600.0, SalesDataUtility.getRowTotal(sample, 0), 0.001);
        assertEquals(125.0, SalesDataUtility.getRowTotal(sample, 1), 0.001);
        assertEquals(400.0, SalesDataUtility.getRowTotal(sample, 2), 0.001);
    }

    @Test
    public void testGetColumnTotalRagged() {
        assertEquals(550.0, SalesDataUtility.getColumnTotal(sample, 0), 0.001); // 100 + 50 + 400
        assertEquals(275.0, SalesDataUtility.getColumnTotal(sample, 1), 0.001); // 200 + 75
        assertEquals(300.0, SalesDataUtility.getColumnTotal(sample, 2), 0.001); // 300 only
    }

    @Test
    public void testHighestLowestArray() {
        assertEquals(400.0, SalesDataUtility.getHighestInArray(sample), 0.001);
        assertEquals(50.0, SalesDataUtility.getLowestInArray(sample), 0.001);
    }
}
