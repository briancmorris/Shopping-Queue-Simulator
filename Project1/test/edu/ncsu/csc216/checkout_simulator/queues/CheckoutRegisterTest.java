package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.ExpressCart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Tests the functionality of CheckoutRegister.
 * @author Brian Morris
 */
public class CheckoutRegisterTest {

    /**
     * Tests the CheckoutRegister constructor.
     */
    @Test
    public void testCheckoutRegister() {
        Log log = new Log();
        CheckoutRegister test = new CheckoutRegister(log);
        assertEquals(Integer.MAX_VALUE, test.departTimeNext());
    }
    
    /**
     * Tests methods associated with adding and removing a Cart
     * from a CheckoutRegister line.
     */
    @Test
    public void testAddAndRemoveCartToLine() {
        Log log = new Log();
        CheckoutRegister test = new CheckoutRegister(log);
        ExpressCart cart1 = new ExpressCart(10, 10);
        // Test adding.
        test.addCartToLine(cart1);
        assertEquals(1, test.size());
        ExpressCart cart2 = new ExpressCart(15, 15);
        test.addCartToLine(cart2);
        // Test size.
        assertEquals(2, test.size());
        // Test departTimeNext()
        assertEquals(20, test.departTimeNext());
        assertEquals(5, cart2.getWaitTime());
        // Test hasNext() true
        assertTrue(test.hasNext());
        // Test processNext().
        ExpressCart removed = (ExpressCart) test.processNext();
        assertFalse(removed.isWaitingInRegisterLine());
        assertEquals(1, test.size());
        test.processNext();
        assertEquals(0, test.size());
        // Test hasNext() false
        assertFalse(test.hasNext());
        
        //Test that log updated appropriately.
        assertEquals(2.5, log.averageWaitTime(), 0);
        assertEquals(12.5, log.averageProcessTime(), 0);
        
    }

}
