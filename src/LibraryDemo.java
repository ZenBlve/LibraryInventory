import java.time.LocalDate;
import java.util.List;

public class LibraryDemo {

    public static void main(String[] args) {

        LibraryStorage libraryInventory = new LibraryStorage(5);

        Item book = new Book(
                "B001",
                "Novel",
                "Historical Fiction",
                "War and Peace",
                "Leo Tolstoy",
                "1869"
        );

        Item movie = new Movie(
                "M001",
                "Horror Movie",
                "Psychological Thriller",
                "Psycho",
                "Alfred Hitchcock",
                List.of("Anthony Perkins", "Janet Leigh")
        );

        Item mag = new Magazine(
                "Z001",
                "Retail Catalogue",
                "Department Store Magazine",
                "Spring 1992",
                "Home Appliances and Furniture"
        );

        System.out.println("=== ADD ITEMS ===");
        libraryInventory.addItem(book, 0, 0);
        libraryInventory.addItem(movie, 0, 1);
        libraryInventory.addItem(mag, 2, 4);

        // access like libraryInventory[2][4] -> get(2).get(4)
        System.out.println("Item on shelf 2 compartment 4: "
                + libraryInventory.get(2).get(4).getName());

        libraryInventory.printItemsInStorage();

        System.out.println("\n=== CHECK OUT ===");
        libraryInventory.checkOut(0, 0, "Anna", LocalDate.now().plusDays(14));
        libraryInventory.printCheckedOutItems();
        libraryInventory.printItemsInStorage();

        System.out.println("\n=== CHECK IN ===");
        libraryInventory.checkIn(0, 0);
        libraryInventory.printItemsInStorage();

        System.out.println("\n=== SWAP ===");
        libraryInventory.swapItems(0, 0, 0, 1);
        System.out.println("Now in 0,0: " + libraryInventory.get(0).get(0).getName());
        System.out.println("Now in 0,1: " + libraryInventory.get(0).get(1).getName());

        System.out.println("\n=== ERRORS (should fail) ===");

        try {
            libraryInventory.checkOut(1, 3, "Bob", LocalDate.now());
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        try {
            libraryInventory.swapItems(0, 0, 1, 3);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        try {
            libraryInventory.get(99);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        try {
            libraryInventory.addItem(book, 0, 0);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
