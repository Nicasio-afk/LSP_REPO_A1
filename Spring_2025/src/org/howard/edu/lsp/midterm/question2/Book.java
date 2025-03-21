package org.howard.edu.lsp.midterm.question2;

//Represents a book in a library.

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    //Constructs a new Book with the specified title, author, ISBN, and year published.
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Returns the title of the book.
    public String getTitle() {
        return title;
    }

    //Sets the title of the book.
    public void setTitle(String title) {
        this.title = title;
    }

    //Returns the author of the book.
    public String getAuthor() {
        return author;
    }

    //Sets the author of the book.
    public void setAuthor(String author) {
        this.author = author;
    }

    //Returns the ISBN of the book.

    public String getISBN() {
        return ISBN;
    }

    //Sets the ISBN of the book.
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // Returns the year the book was published.
    public int getYearPublished() {
        return yearPublished;
    }

    //Sets the year the book was published.
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    //Compares this book to the specified object.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
    }

    //Returns a string representation of the book.
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}