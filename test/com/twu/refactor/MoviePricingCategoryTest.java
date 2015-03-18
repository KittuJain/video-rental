package com.twu.refactor;

import junit.framework.TestCase;
import org.junit.Test;

public class MoviePricingCategoryTest extends TestCase {
    @Test
    public void testKidsCategoryGivesCorrectCostFor4DaysRented() {
        double actualCost = MoviePricingCategory.KIDS.getCostFor(4);
        assertEquals(3,actualCost,0.0);
    }
    @Test
    public void testKidsCategoryGivesCorrectCostFor1DaysRented() {
        double actualCostFor1Day = MoviePricingCategory.KIDS.getCostFor(1);
        double actualCostFor2Days = MoviePricingCategory.KIDS.getCostFor(2);
        assertEquals(1.5,actualCostFor1Day,0.0);
        assertEquals(1.5,actualCostFor2Days,0.0);
    }
    @Test
    public void testNewReleaseCategoryGivesCorrectCostForMoreThan3DaysRented() {
        double actualCost = MoviePricingCategory.NEW_RELEASE.getCostFor(6);
        assertEquals(18,actualCost,0.0);
    }
    @Test
    public void testRegularCategoryGivesCorrectCostForMoreThan3DaysRented() {
        double actualCost = MoviePricingCategory.REGULAR.getCostFor(4);
        assertEquals(5,actualCost,0.0);
    }
}