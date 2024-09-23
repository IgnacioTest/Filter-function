package values;

import java.time.LocalDateTime;

public class BookDate extends Book{

    String date;

    public BookDate(String date) {
        this.date = date;
    }

    public BookDate(int id, String title, Long publicationTimestamp, String summary, Author author, String date) {
        super(id, title, publicationTimestamp, summary, author);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookDate{" +
                "date='" + date + '\'' +
                "} " + super.toString();
    }
}
