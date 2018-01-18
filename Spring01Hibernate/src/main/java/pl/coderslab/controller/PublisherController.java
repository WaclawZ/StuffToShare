package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    @RequestMapping("/save")
    public String form(Model m) {
        Publisher publisher = new Publisher();
        m.addAttribute("publisher",publisher);
        return "add_publisher_form";
    }

    @PostMapping("/save")
    public String saveToDb(@Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "add_publisher_form";
        }
        publisherDao.savePublisher(publisher);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model m, @PathVariable long id) {
        Publisher publisher = publisherDao.getPublisherById(id);
        m.addAttribute("publisher",publisher);
        return "edit_publisher_form";
    }

    @PostMapping("/edit")
    public String editToDB(@Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "edit_publisher_form";
        }
        publisherDao.updatePublisher(publisher);
        return "redirect:all";
    }

    @RequestMapping("/show/{id}")
    @ResponseBody
    public String showBook(@PathVariable long id) {
        Publisher publisher = new Publisher();
        if(publisherDao.getPublisherById(id) == null) {
            return "There is no such publisher with given id in database";
        }
        publisher = publisherDao.getPublisherById(id);
        return publisher.getName();
    }

    @GetMapping("/all")
    public String showAllAuthors(Model m){
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        m.addAttribute("publishers",publisherList);
        return "show_all_publishers";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        Publisher publisher = publisherDao.getPublisherById(id);
        publisherDao.deletePublisher(publisher);
        return "redirect:/publisher/all";
    }
}
