package org.howard.edu.lspfinal.question3;

//All code was done with the aid of Codesignal Learn AI.https://codesignal.com/learn/course-paths/8 

/**
 * Driver class to demonstrate the reporting system.
 */
public class Driver {
    public static void main(String[] args) {
        // Create and generate a sales report
        Report salesReport = new SalesReport();
        salesReport.generateReport();
        System.out.println();

        // Create and generate an inventory report
        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
