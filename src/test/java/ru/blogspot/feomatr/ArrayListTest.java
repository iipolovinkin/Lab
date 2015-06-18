package ru.blogspot.feomatr;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author feo
 * @since 17.06.2015
 */
public class ArrayListTest {
    private ArrayList arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList();
    }

    @Test
    public void testRemoveObjectFromEmptyArrayList() {
        boolean actual = arrayList.remove(new Object());

        assertFalse(actual);
    }

    @Test
    public void testRemoveExistObjectFromArrayList_Valid() throws Exception {
        String one = "one";
        String two = "two";
        String three = "three";

        arrayList.add(one);
        arrayList.add(two);
        arrayList.add(three);

        boolean actual = arrayList.remove(two);

        assertTrue(actual);
        assertFalse(arrayList.contains(two));
//        System.out.println(arrayList);
//        assertThat(arrayList, hasItem(three));
//        assertThat(Arrays.asList(three, one), hasItem(three));

//        int actualSize = arrayList.size();
//        int expectedSize = 2;
//
//        assertThat("three", equalTo(arrayList.get(1)));
//        assertThat(arrayList, is(not(hasItem("one"))));
    }

}