package by.iba.schastny.model;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private int pageAmount;
    private String imageURL;

    public Book(String name, String author, int pageAmount, String imageURL) {
        this.name = name;
        this.author = author;
        this.pageAmount = pageAmount;
        this.imageURL = imageURL;
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
        if(this == null) return false;
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getPageAmount() == book.getPageAmount() &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getImageURL(), book.getImageURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getPageAmount(), getImageURL());
    }
}
