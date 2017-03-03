package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * The ExpressCart class is a Cart that is constructed with
 * elements unique to an ExpressCart such as: its color,
 * arrival time, and checkout time. An ExpressCart always chooses
 * the shortest line.
 * @author Brian Morris
 */
public class ExpressCart extends Cart {
    /** The color of an ExpressCart */
    private static Color colour = Color.GREEN;

    /**
     * The ExpressCart constructor creates an ExpressCart
     * with values for all fields.
     * @param arrivalTime the arrival time of the ExpressCart in seconds
     * @param checkoutTime the checkout time of the ExpressCart in seconds
     */
    public ExpressCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }

    /**
     * The getInLine() method adds an ExpressCart to the back of the shortest line.
     * @param registers an array of the checkout registers in the Store
     */
    @Override
    public void getInLine(CheckoutRegister[] registers) {
        int minCarts = registers[0].size();
        int idx = 0;
        for (int i = 0; i < registers.length; i++) {
            if (registers[i].size() < minCarts) {
                minCarts = registers[i].size();
                idx = i;
            }
        }
        this.setRegisterIndex(idx);
        registers[idx].addCartToLine(this);
    }

    /**
     * Returns the color of the ExpressCart.
     * @return the color of the ExpressCart
     */
    @Override
    public Color getColor() {
        return colour;
    }

}
