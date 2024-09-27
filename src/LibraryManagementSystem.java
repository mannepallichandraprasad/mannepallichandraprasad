import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Adding some sample books to the library
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));

        // Menu-driven system
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add new member");
            System.out.println("5. Display member details");
            System.out.println("6. Add a new book to the library");
            System.out.println("7. Search by book title");
            System.out.println("8. Search by author");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Display all books
                    library.displayBooks();
                    break;
                case 2:
                    // Borrow a book
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 3:
                    // Return a book
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    // Add a new member
                    addNewMember(scanner);
                    break;
                case 5:
                    // Display member details
                    displayMemberDetails(scanner);
                    break;
                case 6:
                    // Add a new book to the library
                    addNewBook(library, scanner);
                    break;
                case 7:
                    // Search by book title
                    System.out.print("Enter the book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 8:
                    // Search by author
                    System.out.print("Enter the author's name to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 9:
                    // Exit
                    System.out.println("Exiting the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }

        } while (choice != 9);

        scanner.close();
    }

    // Method to add a new member
    private static void addNewMember(Scanner scanner) {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Member newMember = new Member(name, memberId, email, phoneNumber);
        members.add(newMember);

        System.out.println("New member \"" + name + "\" added successfully.");
    }

    // Method to display member details
    private static void displayMemberDetails(Scanner scanner) {
        System.out.print("Enter member ID to view details: ");
        String memberId = scanner.nextLine();

        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                member.displayMemberInfo();
                return;
            }
        }
        System.out.println("Member with ID \"" + memberId + "\" not found.");
    }

    // Method to add a new book to the library
    private static void addNewBook(Library library, Scanner scanner) {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        library.addBook(newBook);

        System.out.println("New book \"" + title + "\" by " + author + " added to the library.");
    }
}
