package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

/** The cart class maintains information about various aspects
 * of a shopping cart waiting in line such as its arrival time,
 * wait time, process time, the index of the register it will
 * wait in line at, and if it's waiting in line.
 * @author Brian Morris
 *
 */
public abstract class Cart {

    /** The initial index for a checkout register */
    public static final int INITIAL_REGISTER_IDX = 0;
    /** The arrival time of the shopping cart */
    private int arrivalTime;
    /** The wait time of the shopping cart */
    private int waitTime;
    /** The process time of the shopping cart */
    private int processTime;
    /** The index of the checkout register */
    private int registerIndex;
    /** Boolean that is true if the shopping cart is waiting in line */
    private boolean waitingProcessing;

    /**
     * The Cart constructor initializes a Cart object with values
     * for all fields.
     * @param arrivalTime the arrival time of the shopping cart
     * @param checkoutTime the checkout time of the shopping cart
     */
    public Cart(int arrivalTime, int checkoutTime) {

    }

    /**
     * Returns the arrival time of the shopping cart.
     * @return the arrival time of the shopping cart
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Returns the wait time of the shopping cart.
     * @return the wait time of the shopping cart
     */
    public int getWaitTime() {
        return waitTime;
    }

    /**
     * Sets the wait time of the shopping cart.
     * @param waitTime the wait time of the shopping cart
     */
    public void setWaitTime(int waitTime) {
    }

    /**
     * Returns the process time of the shopping cart.
     * @return the process time of the shopping cart
     */
    public int getProcessTime() {
        return processTime;
    }

    /**
     * Returns the index of the checkout register.
     * @return the index of the checkout register
     */
    public int getRegisterIndex() {
        return registerIndex;
    }

    /**
     * Returns true if the shopping cart is in line for checkout.
     * @return true if the shopping cart is in line for checkout
     */
    public boolean isWaitingInRegisterLine() {
        return waitingProcessing;
    }

    /**
     * Removes a cart from the waiting line.
     */
    public void removeFromWaitingLine() {

    }

    /**
     * Sets the index of the checkout register.
     * @param registerIndex the index of the checkout register
     */
    protected void setRegisterIndex(int registerIndex) {
        //this.registerIndex = registerIndex;
    }

    /**
     * Ensures that all subclasses implement a method that places
     * the shopping cart into a line for checkout.
     * @param registers an array of checkout registers in the store
     */
    public abstract void getInLine(CheckoutRegister[] registers);

    /**
     * Ensures that all subclasses implement a method that returns
     * the color of the shopping cart.
     * @return the color of the shopping cart
     */
    public abstract Color getColor();
}