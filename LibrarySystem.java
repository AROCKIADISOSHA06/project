import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Available Books");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    // Search Book
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book book = library.searchByTitle(searchTitle);
                    System.out.println(book != null ? book : "Book not found.");
                    break;
                case 3:
                    // Issue Book
                    System.out.print("Enter title to issue: ");
                    String issueTitle = scanner.nextLine();
                    boolean issued = library.issueBook(issueTitle);
                    System.out.println(issued ? "Book issued." : "Book not available or already issued.");
                    break;
                case 4:
                    // Return Book
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    boolean returned = library.returnBook(returnTitle);
                    System.out.println(returned ? "Book returned." : "Book not found or not issued.");
                    break;
                case 5:
                    // List Available Books
                    System.out.println("Available books:");
                    library.listAvailableBooks();
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

