package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * The RegularShoppingCart class is a Cart that is constructed with
 * elements unique to a RegularShoppingCart such as: its color,
 * arrival time, and checkout time.
 * @author Brian Morris
 */
public class RegularShoppingCart extends Cart {

    /** The color of a RegularShoppingCart */
    private static Color colour = Color.blue;

    /**
     * The RegularShoppingCart constructor creates a
     * RegularShoppingCart with values for all fields.
     * @param arrivalTime the arrival time of the RegularShoppingCart
     * @param checkoutTime the checkout time of the RegularShoppingCart
     */
    RegularShoppingCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }

    /**
     * The getInLine() method adds a RegularShoppingCart to the back of the line for their chosen
     * CheckoutRegister.
     * @param registers an array of the checkout registers in a store
     */
    @Override
    public void getInLine(CheckoutRegister[] registers) {
        // TODO Auto-generated method stub

    }

    /**
     * The getColor method returns the color of the RegularShoppingCart.
     * @return colour color of the RegularShoppingCart
     */
    @Override
    public Color getColor() {
        return null;
    }

}
