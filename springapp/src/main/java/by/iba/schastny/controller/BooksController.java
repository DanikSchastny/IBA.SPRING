package by.iba.schastny.controller;

import by.iba.schastny.model.Message;
import by.iba.schastny.model.book.Book;
import by.iba.schastny.service.BookService;
import by.iba.schastny.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class BooksController {
    private BookService bookService = new BookServiceImpl();


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        modelAndView.addObject("booksList",books);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("book", bookService.getById(id));
        return modelAndView;
    }


    private List<Book> list;

    private List<Book> getBookList(){
        Book[] books = new Book[]{
                new Book("The Lord of the Rings","JRR Tolkien", 1178,"https://upload.wikimedia.org/wikipedia/en/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg" ),
                new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 223, "D:\\HarryPotter.jpg")
        };

        return Arrays.asList(books);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public String handler(Model model){
        list = getBookList();
        model.addAttribute("books", list);
        return "books";
    }



}
