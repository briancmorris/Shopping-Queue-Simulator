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

}
