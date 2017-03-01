package edu.ncsu.csc216.checkout_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.checkout_simulator.items.Cart;
import edu.ncsu.csc216.checkout_simulator.queues.CheckoutRegister;
import edu.ncsu.csc216.checkout_simulator.queues.Store;

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
    /** The total number of steps required in the simulation */
    private int totalNumberOfSteps;
    /** The Cart being handled currently by the simulator */
    private Cart currentCart;
    /** The Log that maintains all information about the simulation */
    private Log myLog;
    /** The Store that is constructed for the simulation */
    private Store theStore;
    /** The Event Calendar of the simulation */
    private EventCalendar theCalendar;

    /**
     * The Simulator constructor creates a Store with the given parameters
     * for the simulation and initializes all fields.
     * @param numberOfCarts the number of carts in the simulation
     * @param numberOfRegisters the number of checkout registers in the simulation
     * @throws IllegalArgumentException if numRegisters < 1 or numRegisters
     *         is < MIN_NUM_REGISTERS or > MAX_NUM_REGISTERS
     */
    public Simulator(int numberOfCarts, int numberOfRegisters) {
        if (numberOfCarts < 1) {
            throw new IllegalArgumentException("There must be at least one shopping cart in the simulation.");
        }
        if (numberOfRegisters < MIN_NUM_REGISTERS || numberOfRegisters > MAX_NUM_REGISTERS) {
            throw new IllegalArgumentException("Number of registers must be between 3 and 12 inclusive.");
        }
        this.numCarts = numberOfCarts;
        this.numRegisters = numberOfRegisters;
        this.myLog = new Log();
        CheckoutRegister[] registers = new CheckoutRegister[numRegisters];
        for (int i = 0; i < numRegisters; i++) {
            registers[i] = new CheckoutRegister(myLog);
        }
        this.theStore = new Store(numCarts, registers);
        this.theCalendar = new EventCalendar(registers, theStore);
        this.currentCart = null;
        this.totalNumberOfSteps = 2 * numCarts;
    }

    /**
     * Returns the array of colors assigned to the different Cart types.
     * @return the array of colors assigned to the different Cart types
     */
    public static Color[] simulationColors() {
        Color[] simulationColors = {Color.GREEN, Color.BLUE, Color.GREEN};
        return simulationColors;
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
        currentCart = null;
        if(theCalendar.nextToBeProcessed() instanceof Store) {
            Store nextStore = (Store) theCalendar.nextToBeProcessed();
            currentCart = nextStore.processNext();
            stepsTaken++;
        } else {
            CheckoutRegister nextRegister = (CheckoutRegister) theCalendar.nextToBeProcessed();
            currentCart = nextRegister.processNext();
            stepsTaken++;
        }
        
    }

    /**
     * Returns the number of steps taken so far.
     * @return the number of steps taken so far
     */
    public int getStepsTaken() {
        return stepsTaken;
    }

    /**
     * Returns the total number of steps taken in the simulation.
     * @return the total number of steps taken in the simulation
     */
    public int totalNumberOfSteps() {
        return totalNumberOfSteps;
    }

    /**
     * Returns true if the simulation has not yet finished, false
     * if it has.
     * @return true if the simulation has not yet finished, false if it has
     */
    public boolean moreSteps() {
        return (stepsTaken < totalNumberOfSteps);
    }

    /**
     * Returns the index of the CheckoutRegister selected by the current Cart.
     * @return the index of the CheckoutRegister selected by the current Cart
     */
    public int getCurrentIndex() {
        return currentCart.getRegisterIndex();
    }

    /**
     * Returns the color of currentCart or null if currentCart is null.
     * @return the color of currentCart or null if currentCart is null
     */
    public Color getCurrentCartColor() {
        return currentCart.getColor();
    }

    /**
     * Returns true if the most recently handled cart completed checking out
     * and left the register line.
     * @return true if the most recently handled cart completed checking out
     *         and left the register line.
     */
    public boolean itemLeftSimulation() {
        return !currentCart.isWaitingInRegisterLine();
    }

    /**
     * Returns the average number of seconds that carts had to wait in line
     * prior to actual checkout.
     * @return the average number of seconds that carts had to wait in line
     */
    public double averageWaitTime() {
        return myLog.averageWaitTime();
    }

    /**
     * Returns the average number of seconds that carts spent in checkout.
     * @return the average number of seconds that carts spent in checkout
     */
    public double averageProcessTime() {
        return myLog.averageProcessTime();
    }

}
