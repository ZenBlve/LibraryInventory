// Ivan Dibrova - shelf with 15 compartments

public class Shelf {

    private int shelfNum;
    private Compartment[] compartments;

    public Shelf(int shelfNum) {
        this.shelfNum = shelfNum;
        compartments = new Compartment[Compartment.MAX_ON_SHELF];

        for (int i = 0; i < compartments.length; i++) {
            compartments[i] = new Compartment(shelfNum, i);
        }
    }

    // like shelf[4] in the assignment - we use get(4) in Java
    public Item get(int compartmentNum) {
        if (compartmentNum < 0 || compartmentNum >= compartments.length) {
            throw new IndexOutOfBoundsException("Bad compartment number: " + compartmentNum);
        }
        return compartments[compartmentNum].getItem();
    }

    public Compartment getCompartment(int compartmentNum) {
        if (compartmentNum < 0 || compartmentNum >= compartments.length) {
            throw new IndexOutOfBoundsException("Bad compartment number: " + compartmentNum);
        }
        return compartments[compartmentNum];
    }
}
