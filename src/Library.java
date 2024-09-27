import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor to initialize the library
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("\"" + book.getTitle() + "\" by " + book.getAuthor() + " has been added to the library.");
    }

    // Method to display all books
    public void displayBooks() {
        System.out.println("\nList of Books in the Library:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + (book.isBorrowed() ? " [Borrowed]" : ""));
        }
    }

    // Method to borrow a book by title
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Sorry, the book \"" + title + "\" is not available in the library.");
    }

    // Method to return a book by title
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("The book \"" + title + "\" is not in the library's catalog.");
    }

    // Method to search for books by title
    public void searchByTitle(String title) {
        System.out.println("\nSearching for books with title: " + title);
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + (book.isBorrowed() ? " [Borrowed]" : ""));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the title \"" + title + "\".");
        }
    }

    // Method to search for books by author
    public void searchByAuthor(String author) {
        System.out.println("\nSearching for books by author: " + author);
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + (book.isBorrowed() ? " [Borrowed]" : ""));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author \"" + author + "\".");
        }
    }
}
