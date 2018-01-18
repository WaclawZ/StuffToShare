package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.validator.Proposition;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    @Autowired
    Validator validator;

    @Autowired
    BookDao bookDao;

    List<String> list = new ArrayList<>();

    @RequestMapping("/add")
    public String add(Model m) {
        Book book = new Book();
        List<String> list = new ArrayList<>();
        Set<ConstraintViolation<Book>> violations = validator.validate(book, Proposition.class);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                list.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
            }
            m.addAttribute("list",list);
            return "validate_message";
        } else {
            m.addAttribute("book",book);
            return "add_book_form";
        }
    }

    @PostMapping("/save")
    public String save(@Valid Book book, BindingResult result){
        if(result.hasErrors()) {
            return "add_book_form";
        }
        bookDao.saveBook(book);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model m, @PathVariable Long id){
        Book book = bookDao.getBookById(id);
        m.addAttribute("book",book);
        return "edit_book_form";
    }
}
