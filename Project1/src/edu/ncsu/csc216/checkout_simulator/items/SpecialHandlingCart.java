package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * The SpecialHandlingCart class is a Cart that is constructed with
 * elements unique to a SpecialHandlingCart such as: its color,
 * arrival time, and checkout time.
 * @author Brian Morris
 */
public class SpecialHandlingCart extends Cart {

    /** The color of the SpecialHandlingCart */
    private static Color colour = Color.red;

    /**
     * The SpecialHandlingCart constructor creates a
     * SpecialHandlingCart with values for all fields.
     * @param arrivalTime the arrival time of the SpecialHandlingCart
     * @param checkoutTime the checkout time of the SpecialHandlingCart
     */
    SpecialHandlingCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }

    /**
     * The getInLine() method adds a SpecialHandlingCart to the back of the line for their chosen
     * CheckoutRegister.
     * @param registers an array of the checkout registers in a store
     */
    @Override
    public void getInLine(CheckoutRegister[] registers) {
        // TODO Auto-generated method stub

    }

    /**
     * The getColor method returns the color of the SpecialHandlingCart.
     * @return colour color of the SpecialHandlingCart
     */
    @Override
    public Color getColor() {
        return null;
    }

}
