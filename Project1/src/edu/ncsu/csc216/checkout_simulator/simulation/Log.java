package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * The Log class maintains information about the times required to process all
 * shopping carts in the simulation.
 * @author Brian Morris
 */
public class Log {

    /** The number of carts that have checked out */
    private int numCompleted;
    /** The sum of the wait times of all carts */
    private int totalWaitTime;
    /** The sum of the processing times of all carts */
    private int totalProcessTime;

    /**
     * Constructs a Log with values for all fields.
     */
    public Log() {
        this.numCompleted = 0;
        this.totalWaitTime = 0;
        this.totalProcessTime = 0;
    }

    /**
     * Returns the number of carts that have checked out.
     * @return the number of carts that have checked out
     */
    public int getNumCompleted() {
        return numCompleted;
    }

    /**
     * Updates totalWaitTime and totalProcessTime with the wait time and process time
     * of the provided cart.
     * @param cart the cart used to update the Log
     */
    public void logCart(Cart cart) {
        totalWaitTime += cart.getWaitTime();
        totalProcessTime += cart.getProcessTime();
        numCompleted++;
    }

    /**
     * Calculates and returns the average wait time of all shopping carts in
     * the simulation.
     * @return the average wait time of all shopping carts in the simulation
     */
    public double averageWaitTime() {
        return (1.0 * totalWaitTime) / numCompleted;
    }

    /**
     * Calculates and returns the average processing time of all shopping carts
     * in the simulation.
     * @return the average processing time of all shopping carts in the simulation
     */
    public double averageProcessTime() {
        return (1.0 * totalProcessTime) / numCompleted;
    }
}
