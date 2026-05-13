import java.time.LocalDate;
import java.util.Objects;

/**
 * Base class for every item that can be stored in the library inventory.
 */
public abstract class Item {
    private final String id;
    private String name;
    private String description;

    private String checkedOutBy;
    private LocalDate dueDate;

    protected Item(String id, String name, String description) {
        this.id = requireText(id, "id");
        this.name = requireText(name, "name");
        this.description = requireText(description, "description");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = requireText(name, "name");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = requireText(description, "description");
    }

    public boolean isCheckedOut() {
        return checkedOutBy != null;
    }

    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void checkOut(String personName, LocalDate dueDate) {
        if (isCheckedOut()) {
            throw new IllegalStateException("Item " + id + " is already checked out.");
        }

        this.checkedOutBy = requireText(personName, "personName");
        this.dueDate = Objects.requireNonNull(dueDate, "dueDate cannot be null.");
    }

    public void checkIn() {
        if (!isCheckedOut()) {
            throw new IllegalStateException("Item " + id + " is not checked out.");
        }

        checkedOutBy = null;
        dueDate = null;
    }

    public String getBasicDetails() {
        return "ID: " + id
                + "\nName: " + name
                + "\nDescription: " + description;
    }

    public String getCheckoutDetails() {
        if (!isCheckedOut()) {
            return "Status: Checked in";
        }

        return "Status: Checked out"
                + "\nChecked out by: " + checkedOutBy
                + "\nDue date: " + dueDate;
    }

    public abstract String getItemType();

    protected abstract String getSpecificDetails();

    @Override
    public String toString() {
        return getItemType()
                + "\n" + getBasicDetails()
                + "\n" + getSpecificDetails()
                + "\n" + getCheckoutDetails();
    }

    protected static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }

        return value.trim();
    }
}
