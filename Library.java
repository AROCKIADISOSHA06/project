
    import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Search for a book by title
    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Issue a book
    public boolean issueBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            return true;
        }
        return false;
    }

    // List all available books
    public void listAvailableBooks() {
        for (Book book : books) {
            if (!book.isIssued()) {
                System.out.println(book);
            }
        }
    }
}

