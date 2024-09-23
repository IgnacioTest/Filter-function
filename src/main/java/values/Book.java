package values;

public class Book {
    private int id;
    private String title;
    private Long publicationTimestamp;
    private String summary;
    private Author author;

    public Book() {
    }

    public Book(int id, String title, Long publicationTimestamp, String summary, Author author) {
        this.id = id;
        this.title = title;
        this.publicationTimestamp = publicationTimestamp;
        this.summary = summary;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublicationTimestamp() {
        return publicationTimestamp;
    }

    public void setPublicationTimestamp(Long publicationTimestamp) {
        this.publicationTimestamp = publicationTimestamp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tittle='" + title + '\'' +
                ", publicationTimestamp=" + publicationTimestamp +
                ", sumariy='" + summary + '\'' +
                ", author=" + author +
                '}';
    }
}
