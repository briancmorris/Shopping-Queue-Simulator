package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

public abstract class Cart {

    public static final int INITIAL_REGISTER_IDX = 0;
    private int arrivalTime;
    private int waitTime;
    private int processTime;
    private int registerIndex;
    private boolean waitingProcessing;

    public Cart(int arrivalTime, int checkoutTime) {

    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getProcessTime() {
        return processTime;
    }

    public int getRegisterIndex() {
        return registerIndex;
    }

    public boolean isWaitingInRegisterLine() {
        return waitingProcessing;
    }

    public void removeFromWaitingLine() {

    }

    protected void setRegisterIndex(int registerIndex) {
        this.registerIndex = registerIndex;
    }
    /**
     * 
     * @param registers
     */
    public abstract void getInLine(CheckoutRegister[] registers);

    public abstract Color getColor();
}