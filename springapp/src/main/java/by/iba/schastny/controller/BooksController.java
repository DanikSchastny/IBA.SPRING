package by.iba.schastny.controller;

import by.iba.schastny.model.Book;
import by.iba.schastny.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class BooksController {
    private List<Book> list;

    private List<Book> getBookList(){
        Book[] books = new Book[]{
                new Book("The Lord of the Rings","JRR Tolkien", 1178,"D:/LordOfTheRings.jpg" ),
                new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 223, "D:/HarryPotter.jpg")
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
