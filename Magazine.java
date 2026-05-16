public class Magazine extends Item {

    private int edition;
    private String mainArticleTitle;

    public Magazine(String id,
                    String name,
                    String description,
                    int edition,
                    String mainArticleTitle) {

        super(id, name, description);

        if (edition <= 0) {
            throw new IllegalArgumentException(
                    "edition must be positive.");
        }

        this.edition = edition;

        this.mainArticleTitle =
                requireText(mainArticleTitle,
                        "mainArticleTitle");
    }

    @Override
    public String getItemType() {
        return "MAGAZINE";
    }

    @Override
    protected String getSpecificDetails() {

        return "Edition: " + edition
                + "\nMain Article: "
                + mainArticleTitle;
    }
}