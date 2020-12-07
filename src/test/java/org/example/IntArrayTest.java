package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class IntArrayTest
{
    private IntArray intArray;
    @BeforeEach
    void setup(){
        intArray = new IntArray();
    }

    @Test
    public void canInstantiateClass(){
        assertNotNull(intArray);
    }

    @Test
    public void TestGetAverageWithEmptyArray()
    {
        //testfall om arrayen är tom blir även average värdet 0 alltså ingenting
        int[] arr = {};
        assertThrows(IllegalArgumentException.class, () -> intArray.getAverage());
    }

    @Test
    public void TestGetAverageWithSameInt()
    {
        //testfall om arrayen består av samma int blir average densamma
        int[] arr1 = {3,3,3,3,3,3,3,3,3,3};
        IntArray intArray = new IntArray(arr1);
        assertEquals(3,intArray.getAverage());

    }
    @Test
    public void TestGetAverageWithPositiveIntegers()
    {
        //testfall om vi sätter olika positiva heltals värden så får vi fram average
        int[] arr3 = {1,2,3,4,5,6,7};
        assertEquals(4,new IntArray(arr3).getAverage());

    }
    @Test
    public void TestGetAverageWithNegativeValue()
    {
        //testfall om vi sätter olika negativa värden så får vi fram average
        int[] arr5 = {-9,-7};
        assertEquals(-8,new IntArray(arr5).getAverage());

    }
    @Test
    public void TestGetAverageWithOneElement()
    {
        //testfall om vi endast har ett element i arrayen så är de elementet average värdet
        int[] arr4 = {7};
        assertEquals(7,new IntArray(arr4).getAverage());

    }
    @Test
    public void TestGetAverageWithDecimal()
    {
        //om vi vill räkna ut något som har decimal som average så ska vi få med svaret med 2 decimaler
        int[] arr6 = {3, 4, 3};
        assertEquals(3.33,new IntArray(arr6).getAverage());
    }

    @Test
    public void TestFindPositionsWithSameNumbers()
    {
        //hitta positionen i flera tal
        int[] arr = {3, 4, 3};
        int[] expected3 = {0,2};
        assertArrayEquals(expected3,new IntArray(arr).findPositions(3));
    }

    @Test
    public void TestFindPositions()
    {
        //Hitta positionen i ett tal
        int[] arr = {3, 4, 3};
        int[] expected4 = {1};
        assertArrayEquals(expected4,new IntArray(arr).findPositions(4));
    }
    @Test
    public void TestFindPositionsReturnEmptyArray()
    {
        //skicka indexOutOfBounds om talet som sökes inte finns i arrayen
        int[] arr = {3, 4, 3};
        assertThrows(IllegalArgumentException.class,() -> new IntArray(arr).findPositions(5));
    }
    @Test
    public void TestAppendLastOnEmptyArray()
    {
        //testfall om arrayen är tom och jag vill lägga till en siffra i arrayen ska den läggas till på slutet
        int[] arr0 = {};
        IntArray intArray0 = new IntArray(arr0);
        intArray0.appendLast(7);

        int[] expected0 = {7};
        assertArrayEquals(expected0, intArray0.getAsArray());
}
    @Test
    public void TestAppendLast(){
        //om jag har flera element i arrayen ska den lägga till element på slutet
        int[] arr1 = {3, 4, 3};
        int[] expected = {3, 4, 3, 5};
        IntArray intArray = new IntArray(arr1);
        intArray.appendLast(5);
        assertArrayEquals(expected,intArray.getAsArray());
    }

    @Test
    public void TestInsertAt()
    {
        //om jag väljer att sätta ett element på position 1 ska de elementet sättas på den platsen
        int[] arr = {3, 4, 3};
        int[] expected = {3, 8, 4, 3};
        IntArray intArray = new IntArray(arr);
        intArray.insertAt(1,8);
        assertArrayEquals(expected,intArray.getAsArray());
    }

    @Test
    public void TestGetAt()
    {
        //testfall om jag har en array bestående av tre element och söker mig till en viss position ska jag hitta samma element i den önskade positionen
        int[] arr = {3, 4, 3};
        IntArray intArray = new IntArray(arr);
        intArray.getAt(1);
        int[] expected = {3, 4, 3};
        assertArrayEquals(expected,intArray.getAsArray());
    }
    @Test
    public void TestGetAtIndexOutOfBounds()
    {
        //testfall om jag har en array bestående av tre element och söker mig till en viss position ska jag hitta samma element i den önskade positionen
        int[] arr = {3, 4, 3};
        IntArray intArray = new IntArray(arr);
        assertThrows(IndexOutOfBoundsException.class,() -> intArray.getAt(10));
    }
    @Test
    public void TestSetAt()
    {
        //testfall om jag väljer att sätta nytt element på en viss position som redan innehåller ett element
        int[] arr = {3, 4, 3};
        int[] expected = {3, 3, 3};
        IntArray intArray = new IntArray(arr);
        intArray.setAt(1,3);
        assertArrayEquals(expected,intArray.getAsArray());
    }
    @Test
    public void TestSetAtIndexOutOfBounds()
    {
        //testfall om jag väljer att sätta nytt element på en viss position som redan innehåller ett element
        int[] arr = {3, 4, 3};
        IntArray intArray = new IntArray(arr);
        assertThrows(IndexOutOfBoundsException.class,() ->intArray.setAt(14,14));
    }

    @Test
    public void TestDeleteAt()
    {
        //testfall om jag har en array med 4 element ska det återstå 3 om jag raderar ett element
        int[] arr = {3, 8, 4, 3};
        int[] expected = {3, 4, 3};
        IntArray intArray = new IntArray(arr);
        intArray.deleteAt(1);
        assertArrayEquals(expected,intArray.getAsArray());
    }
    @Test
    public void TestDeleteAtIndexOutOfBounds()
    {
        //testfall om jag har en array med 4 element ska det återstå 3 om jag raderar ett element
        int[] arr = {3, 8, 4, 3};
        IntArray intArray = new IntArray(arr);
        assertThrows(IndexOutOfBoundsException.class,() -> intArray.deleteAt(9));
    }

    @Test
    public void TestGetAsArray()
    {
        //testfall visar om min array fyller på med element som jag matar in
        int[] array = {};
        assertArrayEquals(array, new IntArray(array).getAsArray());

        int[] array1 = {1,2,3};
        assertArrayEquals(array1, new IntArray(array1).getAsArray());
    }
}
