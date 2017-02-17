package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

/**
 * The Simulator class constructs the shopping cart simulation
 * environment for a store.
 * @author Brian Morris
 */
public class Simulator {

    /** The minimum number of checkout registers */
    private static final int MIN_NUM_REGISTERS = 3;
    /** The maximum number of checkout registers */
    private static final int MAX_NUM_REGISTERS = 12;
    /** The number of registers in the store */
    private int numRegisters;
    /** The number of carts in the store */
    private int numCarts;
    /** The number of event steps taken in the simulation */
    private int stepsTaken;

    /**
     * The Simulator constructor creates a Store with the given parameters
     * for the simulation and initializes all fields.
     * @param numCarts the number of carts in the simulation
     * @param numRegisters the number of checkout registers in the simulation
     */
    public Simulator(int numCarts, int numRegisters) {
        
    }

    /**
     * Returns the array of colors assigned to the different Cart types.
     * @return the array of colors assigned to the different Cart types
     */
    public static Color[] simulationColors() {
        return null;
    }

    /**
     * Returns the array of strings describing the different Cart types.
     * @return the array of strings describing the different Cart types
     */
    public static String[] simulationLabels() {
        return null;
    }

    /**
     * Handles the next event from the EventCalendar.
     */
    public void step() {
        
    }

    /**
     * Returns the number of steps taken so far.
     * @return the number of steps taken so far
     */
    public int getStepsTaken() {
        return 0;
    }

    /**
     * Returns the total number of steps taken in the simulation.
     * @return the total number of steps taken in the simulation
     */
    public int totalNumberOfSteps() {
        return 0;
    }

    /**
     * Returns true if the simulation has not yet finished, false
     * if it has.
     * @return true if the simulation has not yet finished, false
     *         if it has
     */
    public boolean moreSteps() {
        return false;
    }

    /**
     * Returns the index of the CheckoutRegister selected by the current Cart.
     * @return the index of the CheckoutRegister selected by the current Cart
     */
    public int getCurrentIndex() {
        return 0;
    }

    /**
     * Returns the color of currentCart or null if currentCart is null.
     * @return the color of currentCart or null if currentCart is null
     */
    public Color getCurrentCartColor() {
        return null;
    }

    /**
     * Returns true if the most recently handled cart completed checking out
     * and left the register line.
     * @return true if the most recently handled cart completed checking out
     *         and left the register line.
     */
    public boolean itemLeftSimulation() {
        return false;
    }

    /**
     * Returns the average number of seconds that carts had to wait in checkout
     * register lines prior to actual checkout.
     * @return the average number of seconds that carts had to wait in checkout
     */
    public double averageWaitTime() {
        return 0;
    }

    /**
     * Returns the average number of seconds that carts spent in checkout.
     * @return the average number of seconds that carts spent in checkout
     */
    public double averageProcessTime() {
        return 0;
    }
}
