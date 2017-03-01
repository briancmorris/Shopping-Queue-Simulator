package edu.ncsu.csc216.checkout_simulator.items;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * Tests the functionality of ExpressCart.
 * @author Brian Morris
 */
public class ExpressCartTest {

    /**
     * Tests the getColor() method.
     */
    @Test
    public void testgetColor() {
        ExpressCart test = new ExpressCart(10, 10);
        assertTrue(test.getColor().equals(Color.GREEN));
    }

    /**
     * Tests the getArrivalTime() method.
     */
    @Test
    public void testGetArrivalTime() {
        ExpressCart test = new ExpressCart(10, 10);
        assertEquals(10, test.getArrivalTime());
    }

    /**
     * Tests the getProcessTime() method.
     */
    @Test
    public void testGetProcessTime() {
        ExpressCart test = new ExpressCart(10, 10);
        assertEquals(10, test.getProcessTime());
    }

    /**
     * Tests the setWaitTime() and getWaitTime() method.
     */
    @Test
    public void testWaitTime() {
        ExpressCart test = new ExpressCart(10, 10);
        test.setWaitTime(5);
        assertEquals(5, test.getWaitTime());
    }
    
    /**
     * Tests setRegisterIndex() and getRegisterIndex().
     */
    @Test
    public void testRegisterIndex() {
        ExpressCart test = new ExpressCart(10, 10);
        test.setRegisterIndex(3);
        assertEquals(3, test.getRegisterIndex());
        assertTrue(test.isWaitingInRegisterLine());
        test.setRegisterIndex(-1);
        assertFalse(test.isWaitingInRegisterLine());
    }

    /**
     * Tests removeFromWaitingLine() method.
     */
    @Test
    public void removeFromWaitingLine() {
        ExpressCart test = new ExpressCart(10, 10);
        test.removeFromWaitingLine();
        assertFalse(test.isWaitingInRegisterLine());
    }

    /**
     * Tests an invalid Cart.
     */
    @Test
    public void testInvalid() {
        ExpressCart test = null;
        try {
            test = new ExpressCart(-1, 5);
            fail("Did not throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(test == null);
        }
        try {
            test = new ExpressCart(5, -1);
            fail("Did not throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(test == null);
        }
    }
}
