package by.iba.schastny.model.book;

import by.iba.schastny.model.book.Book;

import java.util.List;

public interface BookDao{
    List<Book> getAllBooks();
    void add(Book book);
    void delete(Book book);
    void edit(Book book);
    Book getById(int id);
}
