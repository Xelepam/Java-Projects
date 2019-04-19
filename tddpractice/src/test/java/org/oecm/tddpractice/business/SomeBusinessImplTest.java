package org.oecm.tddpractice.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessImplTest {

    @Test
    public void calculateSumReturnsSummedUpValuesFromArray() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumReturnsZeroForEmptyArray() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{ });
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}
