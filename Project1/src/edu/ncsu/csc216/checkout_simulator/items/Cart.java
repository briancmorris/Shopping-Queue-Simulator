package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;

/**
 * The Cart class maintains information about a shopping cart that is being
 * processed by the simulation. This includes its arrival time,
 * wait time, process time, the index of the line it chooses, and if it's waiting
 * in line.
 * @author Brian Morris
 */
public abstract class Cart {

    /** The initial index for a checkout register */
    public static final int INITIAL_REGISTER_IDX = -1;
    /** The time when the cart leaves the shopping area and enters the line in seconds */
    private int arrivalTime;
    /** The number of seconds the cart waits in line before processing */
    private int waitTime;
    /** The number of seconds required to check out at the register */
    private int processTime;
    /** The index of the register that the cart has selected */
    private int registerIndex;
    /** Boolean that is true if the shopping cart is waiting in line at a register */
    private boolean waitingProcessing;

    /**
     * The Cart constructor initializes a Cart object with values
     * for all fields. Throws an IllegalArgumentException if
     * arrivalTime or processTime are less than 0.
     * @param arrivalTime the arrival time of the shopping cart in seconds
     * @param processTime the checkout time of the shopping cart in seconds
     * @throws IllegalArgumentException if arrivalTime or processTime are less than 0
     */
    public Cart(int arrivalTime, int processTime) {
        if(arrivalTime < 0 || processTime < 0) {
            throw new IllegalArgumentException();
        }
        this.arrivalTime = arrivalTime;
        this.processTime = processTime;
        this.registerIndex = INITIAL_REGISTER_IDX;
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
        this.waitTime = waitTime;
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
     * Removes a cart from the waiting line and completes its processing.
     */
    public void removeFromWaitingLine() {
        this.waitingProcessing = false;
    }

    /**
     * Sets the index of the checkout register.
     * @param registerIndex the index of the checkout register
     */
    protected void setRegisterIndex(int registerIndex) {
        this.registerIndex = registerIndex;
        this.waitingProcessing = true;
    }

    /**
     * Ensures that all subclasses implement a method that places
     * the shopping cart into the appropriate line.
     * @param registers an array of checkout registers in the Store
     */
    public abstract void getInLine(CheckoutRegister[] registers);

    /**
     * Ensures that all subclasses implement a method that returns
     * the color of the shopping cart.
     * @return the color of the shopping cart
     */
    public abstract Color getColor();

}