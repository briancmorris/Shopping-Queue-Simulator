package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * The CheckOutRegister class maintains information about a checkout register
 * located at a store.
 * @author Brian Morris
 *
 */
public class CheckoutRegister implements LineOfItems {

    /** The ShoppingCartQueue of carts waiting for or being processed at this register */
    private ShoppingCartQueue line;
    /** The cart at the front of the line logs its information here during its actual checkout */
    private Log log;
    /** The next time when this register is available */
    private int timeWhenAvailable;

    /**
     * The CheckoutRegister constructor initializes a CheckoutRegister
     * with values for all fields.
     * @param log the log that keeps track of cart processing times
     */
    public CheckoutRegister(Log log) {
    }

    /**
     * Adds a cart to the end of the line, updating the cart's waitTime as well as
     * the time when the line will be clear of all carts currently in line.
     * @param cart the cart to be added to the end of the line
     */
    public void addCartToLine(Cart cart) {
        
    }
    /**
     * Returns true if the shopping queue is not empty.
     * @return true if the shopping queue is not empty
     */
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Removes the front cart from the line, logging its information in the process.
     * The removed Cart is returned.
     * @return the removed Cart
     */
    @Override
    public Cart processNext() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns when the cart at the front of the line will finish processing
     * and leave the simulation. If the line is empty, return Integer.MAX_VALUE.
     * @return the time that the cart at the front of the line will finish processing
     */
    @Override
    public int departTimeNext() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Returns the number of carts still in line.
     * @return the number of carts still in line
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
