package edu.ncsu.csc216.checkout_simulator.queues;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.items.CartFactory;

/**
 * The Store class maintains information about a Store object
 * including the number of carts found in the simulation and the
 * registers found in the Store.
 * @author Brian Morris
 *
 */
public class Store implements LineOfItems {

    /** The queue of carts still shopping */
    private ShoppingCartQueue shopping;
    /** An array of CheckoutRegisters found in the Store */
    private CheckoutRegister[] register;
    
    /**
     * Constructs a Store with values for all fields.
     * @param numberOfCarts the number of carts in the simulation
     * @param registers an array of all the checkout registers in the Store
     */
    public Store(int numberOfCarts, CheckoutRegister[] registers) {
        for (int i = 0; i < numberOfCarts; i++) {
            shopping.add(CartFactory.createCart());
        }
        this.register = registers;
    }

    /**
     * Returns the number of carts still in the shopping queue.
     * @return the number of carts still in the shopping queue
     */
    public int size() {
        return shopping.size();
    }

    /**
     * Returns true if the shopping queue is not empty.
     * @return true if the shopping queue is not empty
     */
    public boolean hasNext() {
        return !shopping.isEmpty();
    }

    /**
     * Removes the front cart from the shopping queue and sends it a getInLine message.
     * Returns the removed cart.
     * @return the removed cart
     */
    public Cart processNext() {
        Cart c = shopping.remove();
        c.getInLine(register);
        return c;
    }

    /**
     * Returns when the cart at the front of the shopping queue will depart that queue.
     * If the shopping queue is empty, it returns Integer.MAX_VALUE.
     * @return the time when the cart at the front of the shopping queue will depart that queue
     */
    public int departTimeNext() {
        if (shopping.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return shopping.front().getArrivalTime();
    }
}
