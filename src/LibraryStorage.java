import java.time.LocalDate;

// Ivan Dibrova - library storage (shelves + operations)

public class LibraryStorage {

    private Shelf[] shelves;

    public LibraryStorage(int numberOfShelves) {
        shelves = new Shelf[numberOfShelves];
        for (int i = 0; i < numberOfShelves; i++) {
            shelves[i] = new Shelf(i);
        }
    }

    // like libraryInventory[2] - third shelf
    public Shelf get(int shelfNum) {
        if (shelfNum < 0 || shelfNum >= shelves.length) {
            throw new IndexOutOfBoundsException("Shelf " + shelfNum + " does not exist");
        }
        return shelves[shelfNum];
    }

    public void addItem(Item item, int shelfNum, int compartmentNum) {
        Compartment c = get(shelfNum).getCompartment(compartmentNum);

        if (!c.isEmpty()) {
            throw new IllegalStateException("This compartment is not empty!");
        }

        c.putItem(item);
    }

    public void checkOut(int shelfNum, int compartmentNum, String personName, LocalDate dueDate) {
        Compartment c = get(shelfNum).getCompartment(compartmentNum);

        if (c.isEmpty()) {
            throw new IllegalStateException("Nothing to check out - compartment is empty");
        }

        Item item = c.getItem();
        item.checkOut(personName, dueDate);
    }

    public void checkIn(int shelfNum, int compartmentNum) {
        Compartment c = get(shelfNum).getCompartment(compartmentNum);

        if (c.isEmpty()) {
            throw new IllegalStateException("Nothing to check in - compartment is empty");
        }

        Item item = c.getItem();
        item.checkIn();
    }

    public void swapItems(int shelf1, int comp1, int shelf2, int comp2) {
        Compartment c1 = get(shelf1).getCompartment(comp1);
        Compartment c2 = get(shelf2).getCompartment(comp2);

        if (c1.isEmpty() || c2.isEmpty()) {
            throw new IllegalStateException("Both compartments must have items to swap!");
        }

        Item temp = c1.getItem();
        c1.setItem(c2.getItem());
        c2.setItem(temp);
    }

    public void printItemsInStorage() {
        System.out.println("\n--- Items in storage ---");

        int count = 0;
        for (int s = 0; s < shelves.length; s++) {
            for (int c = 0; c < Compartment.MAX_ON_SHELF; c++) {
                Item item = shelves[s].get(c);

                if (item != null && !item.isCheckedOut()) {
                    count++;
                    shelves[s].getCompartment(c).printLocation();
                    System.out.println(item);
                    System.out.println();
                }
            }
        }

        if (count == 0) {
            System.out.println("No items in storage.");
        }
    }

    public void printCheckedOutItems() {
        System.out.println("\n--- Checked out items ---");

        int count = 0;
        for (int s = 0; s < shelves.length; s++) {
            for (int c = 0; c < Compartment.MAX_ON_SHELF; c++) {
                Item item = shelves[s].get(c);

                if (item != null && item.isCheckedOut()) {
                    count++;
                    shelves[s].getCompartment(c).printLocation();
                    System.out.println(item);
                    System.out.println();
                }
            }
        }

        if (count == 0) {
            System.out.println("No checked out items.");
        }
    }
}
