package com.mnknowledge;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

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

    @Test
    public void sort() {
        Arrays.sort(shuffledArr);
        System.out.println("Expected shuffled sort " + Arrays.toString(shuffledArr));
        System.out.println("Before sort " + mySorting.toString());

        mySorting.sort();
        System.out.println("After sort " + mySorting.toString());
        final int[] actualArr = mySorting.getArr();

        Assertions.assertThat(actualArr).isEqualTo(shuffledArr);
    }

}