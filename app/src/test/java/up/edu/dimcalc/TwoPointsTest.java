package up.edu.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }


    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    /** Initializes both points to (-50, -50). The randomization function should bound them from 0-20 and then -10,
     * meaning the min value is -10. If the points are within this x,y range of -50, -50, then they are not randomized
     * properly.
     */
    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        int origX = -50;
        int origY = -50;
        Point origPoint = new Point(origX, origY);
        testPoints.setPoint(0, origX, origY);
        testPoints.setPoint(1, origX, origY);

        testPoints.randomValue(0);
        testPoints.randomValue(1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertNotEquals(origX, p1.x);
        assertNotEquals(origY, p1.y);
        assertNotEquals(origX, p2.x);
        assertNotEquals(origY, p2.y);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, 10, 4);

        testPoints.copy(0, 1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(5, p2.x);
        assertEquals(-3, p2.y);
    }

    @Test
    public void distance() {
        double calcDiff = (int)Math.sqrt(((5-3)*(5-3))+((7-1)*(7-1)));
        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0, 3, 1);
        testPoints.setPoint(1, 5, 7);

        double thisDiff = testPoints.distance();

        assertEquals(calcDiff, thisDiff, 0);
    }

    @Test
    public void slope() {
        double expectedSlope = 1f;

        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0, 1, 1);
        testPoints.setPoint(1, 2, 2);

        double resultSlope = testPoints.slope();
        assertEquals(expectedSlope, resultSlope, 0);

        testPoints.setPoint(1, 1, 1);

        resultSlope = testPoints.slope();
        assertEquals(0, resultSlope, 0);
    }
}