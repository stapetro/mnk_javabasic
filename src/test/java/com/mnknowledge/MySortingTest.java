package com.mnknowledge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Stanislav Petrov
 */
public class MySortingTest {
    private MySorting mySorting;
    private int[] shuffledArr;

    @BeforeEach
    public void setUp() {
        shuffledArr = new int[]{8, 5, 7, 1, 9, 3};
        mySorting = new MySorting(shuffledArr);
    }

    @AfterEach
    public void tearDown() {
        shuffledArr = null;
    }

    @Test
    public void sort() {
        //arrange data
        Arrays.sort(shuffledArr);
        System.out.println("Expected sorted array" + Arrays.toString(shuffledArr));
        System.out.println("Before sort " + mySorting.toString());

        mySorting.sort(); //act block
        System.out.println("After sort " + mySorting.toString());
        final int[] actualArr = mySorting.getArr();

        //assert
        Assertions.assertArrayEquals(actualArr, shuffledArr);
    }

}
