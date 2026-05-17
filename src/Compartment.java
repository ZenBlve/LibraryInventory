// Ivan Dibrova - one compartment on a shelf (max 1 item)

public class Compartment {

    public static final int MAX_ON_SHELF = 15;

    private int shelfNum;
    private int compartmentNum;
    private Item item; // null if empty

    public Compartment(int shelfNum, int compartmentNum) {
        this.shelfNum = shelfNum;
        this.compartmentNum = compartmentNum;
    }

    public boolean isEmpty() {
        return item == null;
    }

    public Item getItem() {
        return item;
    }

    public void putItem(Item newItem) {
        if (newItem == null) {
            System.out.println("Error: item is null");
            return;
        }
        if (!isEmpty()) {
            throw new IllegalStateException("Compartment already has an item!");
        }
        item = newItem;
    }

    public void setItem(Item newItem) {
        item = newItem;
    }

    public void printLocation() {
        System.out.println("Shelf " + shelfNum + ", compartment " + compartmentNum);
    }
}
