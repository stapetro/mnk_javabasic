package com.mnknowledge;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Stanislav Petrov
 */
public class MySortingTest {
    private MySorting mySorting;
    private int[] shuffledArr;

    @Before
    public void setUp() throws Exception {
        shuffledArr = new int[]{8, 5, 7, 1, 9, 3};
        mySorting = new MySorting(shuffledArr);
    }

    @After
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
        Assertions.assertThat(actualArr).isEqualTo(shuffledArr);
    }

}