package by.iba.schastny.model.book.impl;

import by.iba.schastny.model.book.Book;
import by.iba.schastny.model.book.BookDao;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BookDaoImpl implements BookDao {
    private final static AtomicInteger AUTO_ID = new AtomicInteger(0);
    private final static Map<Integer, Book> books = new HashMap<>();

    static {
        Book book = new Book(
                AUTO_ID.getAndIncrement(),
                " In Search of Lost Time",
                "Marcel Proust",
                785,
                "url1"
        );
        books.put(book.getId(), book);

        book = new Book(
                AUTO_ID.getAndIncrement(),
                "The Lord of the Rings",
                "JRR Tolkien",
                1178,
                "https://upload.wikimedia.org/wikipedia/en/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg"
        );
        books.put(book.getId(), book);

        book = new Book(
                AUTO_ID.getAndIncrement(),
                "Harry Potter and the Philosopher's Stone",
                "J. K. Rowling",
                223,
                "D:\\HarryPotter.jpg"
        );

        books.put(book.getId(), book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList(books.values());
    }

    @Override
    public void add(Book book) {
        books.put(AUTO_ID.getAndIncrement(), book);
    }

    @Override
    public void delete(Book book) {
        books.remove(book.getId());
    }

    @Override
    public void edit(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Book getById(int id) {
        return books.get(id);
    }
}
