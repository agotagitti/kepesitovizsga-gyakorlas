package arrays.range;

import org.junit.jupiter.api.Test;

import java.awt.font.NumericShaper;

import static org.junit.jupiter.api.Assertions.*;

class RangeFinderTest {

    @Test
    public void rangeTest(){
        assertEquals(7,RangeFinder.range(new int[]{8,3,5,7,2,4}));
        assertEquals(24,RangeFinder.range(new int[]{15,22,8,19,31}));
    }

    @Test
    public void rangeTestWithNegative(){
        assertEquals(10000030,RangeFinder.range(new int[]{3,10000000,5,-29,4}));
        assertEquals(61,RangeFinder.range(new int[]{-25,-50,10}));
    }
    @Test
    public void rangeTestWithFew(){
        assertEquals(96,RangeFinder.range(new int[]{100,5}));
        assertEquals(1,RangeFinder.range(new int[]{32}));
    }

}