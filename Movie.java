import java.util.ArrayList;
import java.util.List;

public class Movie extends Item {

    private String title;
    private String director;
    private List<String> mainActors;

    public Movie(String id,
                 String name,
                 String description,
                 String title,
                 String director,
                 List<String> mainActors) {

        super(id, name, description);

        this.title = requireText(title, "title");
        this.director = requireText(director, "director");

        if (mainActors == null || mainActors.isEmpty()) {
            throw new IllegalArgumentException(
                    "mainActors cannot be empty.");
        }

        this.mainActors = new ArrayList<>(mainActors);
    }

    @Override
    public String getItemType() {
        return "MOVIE";
    }

    @Override
    protected String getSpecificDetails() {

        return "Title: " + title
                + "\nDirector: " + director
                + "\nMain Actors: " + mainActors;
    }
}