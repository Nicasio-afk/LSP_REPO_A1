package org.howard.edu.lspfinal.question3;

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