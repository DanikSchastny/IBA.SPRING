package by.iba.schastny.model.book;

import javax.persistence.*;
import java.util.Objects;

import static by.iba.schastny.constants.ApplicationStringConstants.TABLE_NAME;
import static by.iba.schastny.constants.ApplicationStringConstants.COLUMN_AMOUNT_OF_PAGES;
import static by.iba.schastny.constants.ApplicationStringConstants.COLUMN_AUTHOR;
import static by.iba.schastny.constants.ApplicationStringConstants.COLUMN_NAME;
import static by.iba.schastny.constants.ApplicationStringConstants.COLUMN_IMAGE_URL;
import static by.iba.schastny.constants.ApplicationStringConstants.COLUMN_ID;

@Entity
@Table(name = TABLE_NAME)
public class Book {
    @Id
    @Column(name = COLUMN_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = COLUMN_NAME)
    private String name;

    @Column(name = COLUMN_AUTHOR)
    private String author;

    @Column(name = COLUMN_AMOUNT_OF_PAGES)
    private int pageAmount;

    @Column(name = COLUMN_IMAGE_URL)
    private String imageURL;

    public Book(String name, String author, int pageAmount, String imageURL) {
        this.name = name;
        this.author = author;
        this.pageAmount = pageAmount;
        this.imageURL = imageURL;
    }

    public Book(int id, String name, String author, int pageAmount, String imageURL) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pageAmount = pageAmount;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() &&
                getPageAmount() == book.getPageAmount() &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getImageURL(), book.getImageURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getPageAmount(), getImageURL());
    }
}
