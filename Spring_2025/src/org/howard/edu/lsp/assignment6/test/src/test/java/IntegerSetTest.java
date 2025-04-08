package org.howard.edu.lsp.assignment6.test.src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.assignment6.test.src.main.java.IntegerSet;

/**
 * JUnit test class for IntegerSet.
 */
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty(), "Set should be empty after clear.");
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, set1.length(), "Set length should be 0 when empty.");
        set1.add(1);
        assertEquals(1, set1.length(), "Set length should be 1 after adding an element.");
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2), "Sets should be equal with the same elements in any order.");

        set2.remove(1);
        assertFalse(set1.equals(set2), "Sets should not be equal after removing an element.");
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        set1.add(1);
        assertTrue(set1.contains(1), "Set should contain the value 1.");
        assertFalse(set1.contains(2), "Set should not contain the value 2.");
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() {
        set1.add(1);
        set1.add(3);
        set1.add(2);
        assertEquals(3, set1.largest(), "Largest element should be 3.");

        set1.clear();
        assertThrows(IllegalStateException.class, () -> set1.largest(), "Should throw exception when set is empty.");
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() {
        set1.add(1);
        set1.add(3);
        set1.add(2);
        assertEquals(1, set1.smallest(), "Smallest element should be 1.");

        set1.clear();
        assertThrows(IllegalStateException.class, () -> set1.smallest(), "Should throw exception when set is empty.");
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        set1.add(1);
        set1.add(1);  // Should not add duplicate
        assertEquals(1, set1.length(), "Set should contain only one element after adding a duplicate.");
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set1.add(1);
        set1.remove(1);
        assertFalse(set1.contains(1), "Set should not contain 1 after removal.");

        set1.remove(5);  // Element 5 is not in set1
        assertEquals(0, set1.length(), "Removing a non-existent element should do nothing.");
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        set1.add(1);
        set2.add(2);
        set1.union(set2);
        assertTrue(set1.contains(1), "Union should add elements from both sets.");
        assertTrue(set1.contains(2), "Union should add elements from both sets.");

        set1.clear();
        set2.clear();
        set1.union(set2);
        assertTrue(set1.isEmpty(), "Union of two empty sets should remain empty.");
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertTrue(set1.contains(2), "Intersection should contain only common elements.");
        assertFalse(set1.contains(1), "Intersection should not contain 1.");
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set1.diff(set2);
        assertTrue(set1.contains(1), "Difference should retain elements only in set1.");
        assertFalse(set1.contains(2), "Difference should remove elements from set2.");
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertTrue(set1.contains(3), "Complement should add elements not in set1.");
        assertFalse(set1.contains(1), "Complement should remove elements in set1.");
        assertFalse(set1.contains(2), "Complement should remove elements in set2.");
        assertEquals(1, set1.length(), "Set1 should only contain 3 after complement.");
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "Set should be empty initially.");
        set1.add(1);
        assertFalse(set1.isEmpty(), "Set should not be empty after adding an element.");
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString(), "toString should return the correct string representation.");
    }

    @Test
    @DisplayName("Test case for largest exception")
    public void testLargestException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            set1.largest();
        });
        assertEquals("Set is empty", exception.getMessage(), "Should throw exception with the correct message.");
    }

    @Test
    @DisplayName("Test case for smallest exception")
    public void testSmallestException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            set1.smallest();
        });
        assertEquals("Set is empty", exception.getMessage(), "Should throw exception with the correct message.");
    }
}
