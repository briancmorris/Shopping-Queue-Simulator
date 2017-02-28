package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * The ExpressCart class is a Cart that is constructed with
 * elements unique to an ExpressCart such as: its color,
 * arrival time, and checkout time.
 * @author Brian Morris
 */
public class ExpressCart extends Cart {
    /** The color of an ExpressCart */
    private static Color colour = Color.green;

    /**
     * The ExpressCart constructor creates an ExpressCart
     * with values for all fields.
     * @param arrivalTime the arrival time of the ExpressCart
     * @param checkoutTime the checkout time of the ExpressCart
     */
    public ExpressCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }


    /**
     * The getInLine() method adds an ExpressCart to the back of the line for their chosen
     * CheckoutRegister.
     * @param registers an array of the checkout registers in a store
     */
    @Override
    public void getInLine(CheckoutRegister[] registers) {
        // TODO Auto-generated method stub
//        for (int i = 0; i < registers.length; i++) {
//            if (registers[i].timeWhenAvailable > 0) {
//                
//            }
//        }
    }

    /**
     * The getColor method returns the color of the ExpressCart.
     * @return colour color of the ExpressCart
     */
    @Override
    public Color getColor() {
        return colour;
    }

}
