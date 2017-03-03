package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;

/**
 * Tests the functionality of the Log class.
 * @author Brian Morris
 */
public class LogTest {

    /**
     * Tests the constructor of Log.
     */
    @Test
    public void testLog() {
        Log test = new Log();
        assertEquals(0, test.getNumCompleted());
    }

    /**
     * Tests the logCart() method.
     */
    @Test
    public void testLogCart() {
        Log test = new Log();
        ExpressCart cart = new ExpressCart(10, 10);
        assertEquals(0, test.getNumCompleted());
        test.logCart(cart);
        assertEquals(1, test.getNumCompleted());
    }

    /**
     * Tests the averageWaitTime() method.
     */
    @Test
    public void testAverageWaitTime() {
        Log test = new Log();
        assertEquals(0, test.getNumCompleted());
        assertEquals(0, test.averageWaitTime(), 0);
        ExpressCart cart1 = new ExpressCart(10, 10);
        cart1.setWaitTime(10);
        test.logCart(cart1);
        assertEquals(10, test.averageWaitTime(), 0);
        ExpressCart cart2 = new ExpressCart(20, 20);
        cart2.setWaitTime(20);
        test.logCart(cart2);
        assertEquals(15, test.averageWaitTime(), 0);
    }
    
    /**
     * Tests the averageProcessTime() method.
     */
    @Test
    public void testAverageProcessTime() {
        Log test = new Log();
        assertEquals(0, test.getNumCompleted());
        assertEquals(0, test.averageProcessTime(), 0);
        ExpressCart cart1 = new ExpressCart(10, 10);
        cart1.setWaitTime(10);
        test.logCart(cart1);
        assertEquals(10, test.averageProcessTime(), 0);
        ExpressCart cart2 = new ExpressCart(20, 20);
        cart2.setWaitTime(20);
        test.logCart(cart2);
        assertEquals(15, test.averageProcessTime(), 0);
    }
}
