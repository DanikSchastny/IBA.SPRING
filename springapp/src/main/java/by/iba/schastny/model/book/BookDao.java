package by.iba.schastny.model.book;

import by.iba.schastny.model.book.Book;

import java.util.List;

public interface BookDao{
    List<Book> getAllBooks();
    boolean add(Book book);
    boolean delete(Book book);
    boolean edit(Book book);
    Book getById(int id);
}
