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
    private static Color colour = Color.RED;

    /**
     * The SpecialHandlingCart constructor creates a
     * SpecialHandlingCart with values for all fields.
     * @param arrivalTime the arrival time of the SpecialHandlingCart
     * @param checkoutTime the checkout time of the SpecialHandlingCart
     */
    public SpecialHandlingCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }

    /**
     * The getInLine() method adds a SpecialHandlingCart to the back of the line for their chosen
     * CheckoutRegister.
     * @param registers an array of the checkout registers in a store
     */
    @Override
    public void getInLine(CheckoutRegister[] registers) {
        int numSpecialRegisters = (int) Math.ceil(registers.length * 0.25);
        int specialRegisterIDX = registers.length - numSpecialRegisters;
        int minCarts = registers[specialRegisterIDX].size();
        int idx = specialRegisterIDX;
        for (int i = specialRegisterIDX; i < registers.length; i++) {
            if (registers[i].size() < minCarts) {
                minCarts = registers[i].size();
                idx = i;
            }
        }
        this.setRegisterIndex(idx);
        registers[idx].addCartToLine(this);
    }

    /**
     * The getColor method returns the color of the SpecialHandlingCart.
     * @return the color of the SpecialHandlingCart
     */
    @Override
    public Color getColor() {
        return colour;
    }

}
