package edu.ncsu.csc216.checkout_simulator.queues;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
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
        CheckoutRegister[] registers = new CheckoutRegister[5];
        Log log = new Log();
        registers[0] = new CheckoutRegister(log);
        registers[1] = new CheckoutRegister(log);
        registers[2] = new CheckoutRegister(log);
        registers[3] = new CheckoutRegister(log);
        registers[4] = new CheckoutRegister(log);
        Store test = new Store(500, registers);
        // size()
        assertEquals(500, test.size());
        // hasNext() true
        assertTrue(test.hasNext());
        // full queue departTimeNext()
        assertTrue(test.departTimeNext() >= 0);
        // Process all 500 carts.
        for (int i = 0; i < 500; i++) {
            Cart c = test.processNext();
            assertTrue(c.isWaitingInRegisterLine());
            assertTrue(c.getRegisterIndex() != -1);
        }
        // hasNext() false
        assertFalse(test.hasNext());
        // empty queue departTimeNext()
        assertEquals(Integer.MAX_VALUE, test.departTimeNext());
    }

}
