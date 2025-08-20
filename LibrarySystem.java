import java.util.Scanner;  // we are importing Scanner class
//we are creating a book class
class Book {
    String id;
    String title;
    String author;
    boolean isIssued;

    Book(String id, String title, String author) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void issue() 
    { 
        isIssued = true; 
    }
    void returnBook() 
    { 
        isIssued = false; 
    }

    public String toString() {
        return id + " | " + title + " by " + author + " | " + (isIssued ? "Issued" : "Available");
    }
}
//we are creating a main class for this java file "LibrarySystem"

public class LibrarySystem {
    static Book[] books = new Book[100];
    static int bookCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) 
        {
            System.out.println("\n Library System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) 
            {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        books[bookCount++] = new Book(id, title, author);
        System.out.println("Book added.");
    }

    static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String id = sc.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].id.equals(id)) {
                if (books[i].isIssued) {
                    System.out.println("Book already issued.");
                } else {
                    books[i].issue();
                    System.out.println("Book issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String id = sc.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].id.equals(id)) {
                if (!books[i].isIssued) {
                    System.out.println("Book is not issued.");
                } else {
                    books[i].returnBook();
                    System.out.println("Book returned.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
