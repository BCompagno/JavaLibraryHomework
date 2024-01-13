package libraryLabHomework;

import java.util.ArrayList;
import java.util.List;

public class Library {

	String address;
	static String hours = "9AM to 5PM";
	
	List<Book> bookList = new ArrayList<>();
	
	public Library(String address) {
		this.address=address;
	}
	
	public void addBook( Book book ) {
		this.bookList.add(book);
	}
	
	public static void printOpeningHours() {
		System.out.println(hours);
	}
	
	public void printAddress() {
		System.out.println(address);
	}
	
	public void borrowBook( String title) {
		
		bookList.forEach( book -> {
			if(book.title.equals(title)) {
				if(book.isBorrowed() ) {
					System.out.println("Sorry, this book is already borrowed\n");
					return;
				}
				else {
					System.out.printf("You successfully borrowed %s\n", title);
					book.borrowed();
					return;
				}
			}
		});
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	public void printAvailableBooks() {
		if(bookList.isEmpty()) {
			System.out.println("No book in catalog");
		}
		else {
			bookList.forEach(book ->{
				System.out.println(book.title);
			});
		}
	}
	
	public void returnBook(String title) {
		bookList.forEach(book -> {
			if(book.title == title) {
				System.out.printf("Returning %s", title);
				book.returned();
			}
		});
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
