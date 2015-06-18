package ru.blogspot.feomatr;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;


/**
 * Test for ArrayLists's method
 * <tt>public boolean remove(Object o)</tt>
 *
 * @author polovinkin.igor 17.06.2015
 */
public class ArrayListTest {

    private ArrayList arrayList;
    private ArrayList expectedArrayList;

    private String one = "one";
    private String two = "two";
    private Object three = "three";

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList();
        expectedArrayList = new ArrayList();
    }

    @Test
    public void testRemoveObjectFromEmptyArrayList() {
        Object someObject = new Object();
        boolean actual = arrayList.remove(someObject);

        assertThat(arrayList, empty());
    }

    @Test
    public void testRemoveNullFromArrayList() {
        arrayList.addAll(Arrays.asList(one, two, three));

        arrayList.remove(null);

        assertThat(arrayList, hasSize(3));
    }

    @Test
    public void testRemoveObjectFromArrayListWhichDoesNotContainElement() {
        arrayList.addAll(Arrays.asList(one, two, three));
        expectedArrayList.addAll(arrayList);
        Object someObject = new Object();

        arrayList.remove(someObject);

        assertThat(arrayList, is(expectedArrayList));
    }

    @Test
    public void testRemoveObjectFromArrayListWhichHasElement() throws Exception {
        arrayList.addAll(Arrays.asList(one, two, three));

        arrayList.remove(two);

        assertThat(arrayList, is(Arrays.asList(one, three)));
    }

    @Test
    public void testRemoveObjectFromArrayListWhichHasElementAtFirstPosition() throws Exception {
        arrayList.addAll(Arrays.asList(one, two, three));

        arrayList.remove(one);

        assertThat(arrayList, is(Arrays.asList(two, three)));
    }

    @Test
    public void testRemoveObjectFromArrayListWhichHasElementAtLastPosition() throws Exception {
        arrayList.addAll(Arrays.asList(one, two, three));

        arrayList.remove(three);

        assertThat(arrayList, is(Arrays.asList(one, two)));
    }


    @Test
    public void testRemoveObjectFromArrayListWHichHasOnlyOneElement() throws Exception {
        arrayList.add("xxx");

        arrayList.remove("xxx");

        assertThat(arrayList, empty());
    }


    @Test
    public void testRemoveObjectFromArrayListWhichHasFourSuchElements() throws Exception {
        arrayList.addAll(Arrays.asList(one, two, three, one, one, one));
        expectedArrayList.addAll(Arrays.asList(two, three, one, one, one));

        arrayList.remove(one);

        assertThat(arrayList, is(expectedArrayList));
    }

    @Test
    public void testRemoveObjectFromArrayListIfSuccessReturnTrue() throws Exception {
        arrayList.addAll(Arrays.asList(one, two, three));

        boolean actual = arrayList.remove(three);

        assertTrue(actual);
    }

    @Test
    public void testRemoveObjectFromArrayListIfUnsuccessReturnFalse() throws Exception {
        arrayList.addAll(Arrays.asList(one, two, three));

        boolean actual = arrayList.remove("four");

        assertFalse(actual);
    }

}