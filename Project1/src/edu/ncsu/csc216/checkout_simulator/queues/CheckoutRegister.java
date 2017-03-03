package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.simulation.Log;

/**
 * The CheckOutRegister class maintains information about a checkout register
 * located in a Store. This includes its line, a Log to record processing information,
 * and the time when all carts in line will finish processing.
 * @author Brian Morris
 */
public class CheckoutRegister implements LineOfItems {

    /** The ShoppingCartQueue of carts waiting for or being processed at this register */
    private ShoppingCartQueue line;
    /** When a cart finishes checkout at this CheckoutRegister, its information is recorded here. */
    private Log log;
    /** The next time when this CheckoutRegister will be clear of all carts in seconds */
    private int timeWhenAvailable;

    /**
     * The CheckoutRegister constructor initializes a CheckoutRegister
     * with values for all fields.
     * @param log the log that keeps track of cart processing times
     */
    public CheckoutRegister(Log log) {
        this.line = new ShoppingCartQueue();
        this.log = log;
        this.timeWhenAvailable = 0;
    }

    /**
     * Returns the number of carts still in line.
     * @return the number of carts still in line
     */
    @Override
    public int size() {
        return line.size();
    }

    /**
     * Removes the front cart from the line, logging its information in the process.
     * The removed cart is returned.
     * @return the removed cart
     */
    @Override
    public Cart processNext() {
        Cart c = line.remove();
        c.removeFromWaitingLine();
        log.logCart(c);
        return c;
    }

    /**
     * Returns true if the line is not empty.
     * @return true if the line is not empty
     */
    @Override
    public boolean hasNext() {
        return !line.isEmpty();
    }

    /**
     * Returns when the cart at the front of the line will finish processing
     * and leave the simulation. If the line is empty, return Integer.MAX_VALUE.
     * @return the time that the cart at the front of the line will finish processing,
     *         or Integer.MAX_VALUE if the line is empty
     */
    @Override
    public int departTimeNext() {
        if (line.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        Cart c = line.front();
        return (c.getArrivalTime() + c.getWaitTime() + c.getProcessTime());
    }

    /**
     * Adds a cart to the end of the line, updating the cart's wait time as well as
     * the time when the line will be clear of all carts currently in line.
     * @param cart the cart to be added to the end of the line
     */
    public void addCartToLine(Cart cart) {
        if(line.isEmpty()) {
            cart.setWaitTime(0);
        } else {
            cart.setWaitTime(this.timeWhenAvailable - cart.getArrivalTime());
        }
        timeWhenAvailable = cart.getArrivalTime() + cart.getWaitTime() + cart.getProcessTime();
        line.add(cart);
    }

}
