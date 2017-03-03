package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * The RegularShoppingCart class is a Cart that is constructed with
 * elements unique to a RegularShoppingCart such as: its color,
 * arrival time, and checkout time. A RegularShoppingCart always chooses
 * the shortest line, so long as it's not an ExpressCart line.
 * @author Brian Morris
 */
public class RegularShoppingCart extends Cart {

    /** The color of a RegularShoppingCart */
    private static Color colour = Color.BLUE;

    /**
     * The RegularShoppingCart constructor creates a
     * RegularShoppingCart with values for all fields.
     * @param arrivalTime the arrival time of the RegularShoppingCart in seconds
     * @param checkoutTime the checkout time of the RegularShoppingCart in seconds
     */
    public RegularShoppingCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }

    /**
     * The getInLine() method adds a RegularShoppingCart to the back of the shortest line,
     * as long as it isn't an ExpressCart line.
     * @param registers an array of the checkout registers in a store
     */
    @Override
    public void getInLine(CheckoutRegister[] registers) {
        int minCarts = registers[1].size();
        int idx = 1;
        for (int i = 1; i < registers.length; i++) {
            if (registers[i].size() < minCarts) {
                minCarts = registers[i].size();
                idx = i;
            }
        }
        this.setRegisterIndex(idx);
        registers[idx].addCartToLine(this);
    }

    /**
     * Returns the color of the RegularShoppingCart.
     * @return the color of the RegularShoppingCart
     */
    @Override
    public Color getColor() {
        return colour;
    }

}
