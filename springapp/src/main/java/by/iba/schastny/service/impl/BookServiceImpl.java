package by.iba.schastny.service.impl;

import by.iba.schastny.model.book.Book;
import by.iba.schastny.model.book.BookDao;
import by.iba.schastny.model.book.impl.BookDaoImpl;
import by.iba.schastny.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    public void edit(Book book) {
        bookDao.edit(book);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }
}
