package edu.ncsu.csc216.checkout_simulator.simulation;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Test;

/**
 * Tests the functionality of the Simulator class.
 * 
 * @author Brian Morris
 */
public class SimulatorTest {

    /**
     * Tests the constructor of Simulator.
     */
    @Test
    public void testSimulator() {
        Simulator test = new Simulator(5, 100);
        assertEquals(200, test.totalNumberOfSteps());
    }

    /**
     * Tests creating invalid instances of a Simulator.
     */
    public void testInvalid() {
        Simulator test = null;
        try {
            test = new Simulator(2, 500);
            fail("Simulator did not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Number of registers must be between 3 and 12 inclusive.", e.getMessage());
            assertTrue(test == null);
        }
        try {
            test = new Simulator(13, 500);
            fail("Simulator did not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Number of registers must be between 3 and 12 inclusive.", e.getMessage());
            assertTrue(test == null);
        }
        try {
            test = new Simulator(5, 0);
            fail("Simulator did not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("There must be at least one shopping cart in the simulation.",
                    e.getMessage());
            assertTrue(test == null);
        }
        assertTrue(test == null);
    }

    /**
     * Tests that Simulator returns the correct array of simulation colors.
     */
    @Test
    public void testSimulationColors() {
        Color[] colors = { Color.GREEN, Color.BLUE, Color.RED };
        assertTrue(Arrays.equals(colors, Simulator.simulationColors()));
    }

    /**
     * Tests that Simulator returns the correct array of simulation labels.
     */
    @Test
    public void testSimulationLabels() {
        String[] labels = { "ExpressCart", "RegularShoppingCart", "SpecialHandlingCart" };
        assertTrue(Arrays.equals(labels, Simulator.simulationLabels()));
    }

    /**
     * Tests the step(), totalNumberOfSteps(), and moreSteps() methods in
     * Simulator.
     */
    @Test
    public void testStepMethods() {
        Simulator test = new Simulator(5, 100);
        assertEquals(200, test.totalNumberOfSteps());
        for (int i = 1; i <= 200; i++) {
            test.step();
            assertEquals(i, test.getStepsTaken());
            if (i < 200) {
                assertTrue(test.moreSteps());
            } else {
                assertFalse(test.moreSteps());
            }
//            else {
//                 assertFalse(test.moreSteps());
//            }
        }
        assertTrue(test.averageProcessTime() != 0);
        assertTrue(test.averageWaitTime() != 0);
    }

    /**
     * Tests the getCurrentCartColor(), getCurrentIndex(), and
     * itemLeftSimulation() methods in Simulator.
     */
    @Test
    public void testCartMethods() {
        Simulator test = new Simulator(5, 100);
        assertEquals(200, test.totalNumberOfSteps());
        // Test null currentCart
        assertEquals(-1, test.getCurrentIndex());
        assertFalse(test.itemLeftSimulation());
        assertTrue(test.getCurrentCartColor() == null);
        // Step through simulation and check cart methods.
        for (int i = 1; i <= 200; i++) {
            test.step();
            if (!test.itemLeftSimulation()) {
                assertTrue(test.getCurrentIndex() != -1);
                assertTrue(test.getCurrentCartColor().equals(Color.GREEN)
                           || test.getCurrentCartColor().equals(Color.BLUE)
                           || test.getCurrentCartColor().equals(Color.RED));
            } else {
                assertTrue(test.getCurrentIndex() != -1);
            }
        }
    }
}
