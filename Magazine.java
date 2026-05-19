public class Magazine extends Item {
  private String edition;
  private String mainArticleTitle;

  public Magazine(String id, String name, String description, String edition, String mainArticleTitle) {
      super(id, name, description);
      this.edition = requireText(edition, "edition");
      this.mainArticleTitle = requireText(mainArticleTitle, "mainArticleTitle");
  }

  public String getItemType() {
    return "MAGAZINE";
  }

  protected String getSpecificDetails() {
    return "Edition: " + edition + "\nMain Article: " + mainArticleTitle;
  }
}
