package edu.ncsu.csc216.checkout_simulator.items;

import java.awt.Color;

public class SpecialHandlingCart extends Cart {

    private static Color colour = Color.red;

    SpecialHandlingCart(int arrivalTime, int checkoutTime) {
        super(arrivalTime, checkoutTime);
    }

    @Override
    public void getInLine() {
        // TODO Auto-generated method stub

    }

    @Override
    public Color getColor() {
        return colour;
    }

}
