package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.RegularShoppingCart;
import edu.ncsu.csc216.checkout_simulator.items.SpecialHandlingCart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * Tests the functionality of the Store class.
 * @author Brian Morris
 *
 */
public class StoreTest {

    /**
     * Tests all Store class methods.
     */
    @Test
    public void storeTest() {
        // constructor
        CheckoutRegister[] registers = new CheckoutRegister[10];
        Log log = new Log();
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new CheckoutRegister(log);
        }
        Store test = new Store(1000, registers);
        // size()
        assertEquals(1000, test.size());
        // hasNext() true
        assertTrue(test.hasNext());
        // full queue departTimeNext()
        assertTrue(test.departTimeNext() >= 0);
        // Process all 1000 carts.
        for (int i = 0; i < 1000; i++) {
            Cart c = test.processNext();
            assertTrue(c.isWaitingInRegisterLine());
            assertTrue(c.getRegisterIndex() != -1);
            // Ensure that a SpecialHandlingCart enters an appropriate line.
            if (c instanceof SpecialHandlingCart) {
                assertTrue(c.getRegisterIndex() >= 7);
            }
            // Ensure that a RegularShoppingCart enters an appropriate line.
            if (c instanceof RegularShoppingCart) {
                assertTrue(c.getRegisterIndex() != 0);
            }
        }
        // hasNext() false
        assertFalse(test.hasNext());
        // empty queue departTimeNext()
        assertEquals(Integer.MAX_VALUE, test.departTimeNext());
    }

}
