package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a task with a duplicate name is added.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
