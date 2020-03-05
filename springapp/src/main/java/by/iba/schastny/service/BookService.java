package by.iba.schastny.service;

import by.iba.schastny.model.book.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void add(Book book);
    void delete(Book book);
    void edit(Book book);
    Book getById(int id);
}
