import java.time.LocalDate;

// Ivan Dibrova - testing my part of the project (storage)

public class LibraryDemo {

    public static void main(String[] args) {

        LibraryStorage libraryInventory = new LibraryStorage(5);

        // TODO: replace with Book, Movie, Magazine from teammates when they add them
        Item book = new TestBook();
        Item movie = new TestMovie();
        Item mag = new TestMagazine();

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

    // simple test items - just so main() works before team merges all files
    static class TestBook extends Item {
        TestBook() {
            super("B001", "Programming", "textbook");
        }

        public String getItemType() {
            return "BOOK";
        }

        protected String getSpecificDetails() {
            return "Title: Java Basics\nAuthor: Ivan Dibrova";
        }
    }

    static class TestMovie extends Item {
        TestMovie() {
            super("M001", "Movie DVD", "film");
        }

        public String getItemType() {
            return "MOVIE";
        }

        protected String getSpecificDetails() {
            return "Title: Interstellar\nDirector: Nolan";
        }
    }

    static class TestMagazine extends Item {
        TestMagazine() {
            super("Z001", "Tech Mag", "magazine");
        }

        public String getItemType() {
            return "MAGAZINE";
        }

        protected String getSpecificDetails() {
            return "Edition: 5\nMain article: AI";
        }
    }
}
