package org.howard.edu.lsp.assignment6.test.src.main.java
;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of integers with various set operations.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    // Default Constructor
    public IntegerSet() {
    }

    // Constructor if you want to pass in already initialized
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise.
     * Two sets are equal if they contain all of the same values in ANY order.
     * @param o the object to compare with
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet otherSet = (IntegerSet) o;
        return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
    }

    /**
     * Returns true if the set contains the value, otherwise false.
     * @param value the value to check
     * @return true if the set contains the value, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * @return the largest item
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return set.stream().max(Integer::compareTo).orElseThrow();
    }

    /**
     * Returns the smallest item in the set.
     * @return the smallest item
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return set.stream().min(Integer::compareTo).orElseThrow();
    }

    /**
     * Adds an item to the set or does nothing if it is already there.
     * @param item the item to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not there.
     * @param item the item to remove
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Set union.
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
    }

    /**
     * Set intersection, all elements in both sets.
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Set difference, i.e., this set minus intSetb.
     * @param intSetb the set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Set complement, all elements not in this set.
     * @param intSetb the set to complement with
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(set);
        set = complementSet;
    }

    /**
     * Returns true if the set is empty, false otherwise.
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Return String representation of your set.
     * @return String representation of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}