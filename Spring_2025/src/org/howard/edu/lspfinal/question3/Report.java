package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class representing a report.
 */
public abstract class Report {
    // Template method defining the workflow
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}