public class Book extends Item {

    private String title;
    private String author;
    private String copyrightDate;

    public Book(String id,
                String name,
                String description,
                String title,
                String author,
                String copyrightDate) {

        super(id, name, description);

        this.title = requireText(title, "title");
        this.author = requireText(author, "author");
        this.copyrightDate =
                requireText(copyrightDate, "copyrightDate");
    }

    @Override
    public String getItemType() {
        return "BOOK";
    }

    @Override
    protected String getSpecificDetails() {
        return "Title: " + title
                + "\nAuthor: " + author
                + "\nCopyright Date: " + copyrightDate;
    }
}