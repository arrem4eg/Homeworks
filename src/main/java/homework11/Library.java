package homework11;

public abstract class Library {

    private String title;
    private String author;
    private String type;


    public Library(String title, String author, String type) {
        this.title = title;
        this.author = author;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String printItemInfo() {
        return "-------------\n" +
                "Type: " + type +
                "\nTitle: " + title +
                "\nAuthor: " + author +
                "\n----------------";
    }
}
