package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

    @RequestMapping("/save")
    public String form(Model m) {
        Author author = new Author();
        m.addAttribute("author",author);
        return "add_author_form";
    }

    @PostMapping("/save")
    public String saveToDb(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "add_author_form";
        }
        authorDao.saveAuthor(author);
        return "redirect:all";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(Model m, @PathVariable long id) {
        Author author = authorDao.getAuthorById(id);
        m.addAttribute("author",author);
        return "edit_author_form";
    }

    @PostMapping("/edit")
    public String editToDB(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "edit_author_form";
        }
        authorDao.updateAuthor(author);
        return "redirect:all";
    }

    @RequestMapping("/show/{id}")
    @ResponseBody
    public String showBook(@PathVariable long id) {
        Author author = new Author();
        if(authorDao.getAuthorById(id) == null) {
            return "There is no such author with given id in database";
        }
        author = authorDao.getAuthorById(id);
        return author.toString();
    }

    @GetMapping("/all")
    public String showAllAuthors(Model m){
        List<Author> authorList = authorDao.getAllAuthors();
        m.addAttribute("authors",authorList);
        return "show_all_authors";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        Author author = authorDao.getAuthorById(id);
        authorDao.deleteAuthor(author);
        return "redirect:/author/all";
    }
}
