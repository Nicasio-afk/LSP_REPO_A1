package org.howard.edu.lsp.assignment5;

/**
 * A driver class to test the IntegerSet class functionality.
 */
public class Driver {
    public static void main(String[] args) {
        // Test add and toString
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 is: " + set1.toString());

        // Test smallest and largest
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());

        // Test clear and isEmpty
        set1.clear();
        System.out.println("Set1 cleared. Is empty? " + set1.isEmpty());

        // Test add, remove, and contains
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 after adding elements: " + set1.toString());
        set1.remove(2);
        System.out.println("Value of Set1 after removing 2: " + set1.toString());
        System.out.println("Set1 contains 3? " + set1.contains(3));

        // Test length
        System.out.println("Length of Set1: " + set1.length());

        // Test equals
        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(3);
        System.out.println("Set1 equals Set2? " + set1.equals(set2));

        // Test union
        set2.add(4);
        set2.add(5);
        System.out.println("Union of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Value of Set2 is: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        // Test intersection
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Intersection of Set1 and Set2");
        set1.intersect(set2);
        System.out.println("Result of intersection of Set1 and Set2: " + set1.toString());

        // Test difference
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.clear();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Difference of Set1 and Set2");
        set1.diff(set2);
        System.out.println("Result of difference of Set1 and Set2: " + set1.toString());

        // Test complement
        set1.clear();
        set1.add(1);
        set1.add(2);
        set2.clear();
        set2.add(2);
        set2.add(3);
        System.out.println("Complement of Set1 in Set2");
        set1.complement(set2);
        System.out.println("Result of complement of Set1 in Set2: " + set1.toString());
    }
}