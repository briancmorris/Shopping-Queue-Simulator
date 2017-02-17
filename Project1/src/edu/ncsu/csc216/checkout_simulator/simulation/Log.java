package edu.ncsu.csc216.checkout_simulator.simulation;

import edu.ncsu.csc216.checkout_simulator.items.Cart;

/**
 * The Log class maintains information about the times required to process all
 * shopping carts in the simulation.
 * @author Brian Morris
 */
public class Log {

    /** The number of carts that have checked out and left the simulation */
    private int numCompleted;
    /** The sum of all wait times logged by carts that have checked out so far */
    private int totalWaitTime;
    /** The sume of all times that carts took to actually check out at registers. */
    private int totalProcessTime;
    
    /**
     * Constructs a log with values for all fields.
     */
    public Log() {
        
    }

    /**
     * Returns the number of carts that have checked out and left the simulation.
     * @return the number of carts that have checked out and left the simulation
     */
    public int getNumCompleted() {
        return 0;
    }

    /**
     * Updates the data members of log using the information from the provided
     * cart.
     * @param cart the cart used to update the log information
     */
    public void logCart(Cart cart) {
        
    }
    /**
     * Calculates and returns the average wait time of all shopping carts in
     * the simulation.
     * @return the average wait time of all shopping carts in the simulation
     */
    public double averageWaitTime() {
        return 0;
    }
    
    /**
     * Calculates and returns the average processing time of all shopping carts
     * in the simulation.
     * @return the average processing time of all shopping carts in the simulation
     */
    public double averageProcessTime() {
        return 0;
    }
}
