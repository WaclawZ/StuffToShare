package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/add")
    public String form(Model m) {
        Book book = new Book();
        m.addAttribute("book",book);
        return "add_book_form";
    }

    @PostMapping("/save")
    public String saveToDb(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "add_book_form";
        }
        bookDao.saveBook(book);
        return "redirect:all";
    }


    @RequestMapping("/edit/{id}")
    public String editBook(Model m, @PathVariable Long id) {
        Book book = bookDao.getBookById(id);
        m.addAttribute("book",book);
        return "edit_book_form";
    }

    @PostMapping("/edit")
    public String editToDB(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {

            return "edit_book_form";
        }
        bookDao.updateBook(book);
        return "redirect:all";
    }

    @RequestMapping("/show/{id}")
    public String showBook(Model m, @PathVariable long id) {
        Book book = new Book();
        if(bookDao.getBookById(id) == null) {
            return "error";
        }
        book = bookDao.getBookById(id);
        m.addAttribute("book",book);
        return "show_book";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(Model m, @PathVariable long id) {
        m.addAttribute("id",id);
        return "confirm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.getBookById(id);
        bookDao.deleteBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/all")
    public String allBooks(Model m){
        List<Book> books= bookDao.getAllBooks();
        m.addAttribute("books",books);
        return "show_all_books";
    }

    @GetMapping("/showall")
    public String showAllBooks(Model m){
        Author author = authorDao.getAuthorById(1);
        Publisher publisher = publisherDao.getPublisherById(3);
        List<Book> books= bookRepository.findFirstByPublisherOrderByTitle(publisher);
        m.addAttribute("books",books);
        return "show_all_books";
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.getAllAuthors();
    }

    @ModelAttribute("publisher")
    public List<Publisher> publishers(){
        return publisherDao.getAllPublishers();
    }
}
