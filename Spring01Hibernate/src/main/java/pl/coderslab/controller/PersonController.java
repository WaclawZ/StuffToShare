package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dto.PersonDTO;
import pl.coderslab.entity.Person;

import java.util.HashMap;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonDao personDao;
    @Autowired
    PersonDTO personDTO;

    @GetMapping("/form")
    public String showForm(Model m){
        Person person = new Person();
        m.addAttribute("person",person);

        return "person_add_form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addPerson(@ModelAttribute Person person){
        personDao.save(person);
        return "Person with id: "+person.getId()+" was saved.";
    }

    @GetMapping("/update/{id}")
    public String editPerson(Model m, @PathVariable Long id){
        Person person = personDao.getById(id);
        m.addAttribute("person",person);
        return "person_update_form";
    }

    @RequestMapping("/show/{id}")
    public String showPerson(Model m, @PathVariable Long id){
        Person person = personDao.getById(id);
        m.addAttribute("person",person);
        return "show_person";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable Long id){
        Person person = personDao.getById(id);
        personDao.delete(person);
        return "Person with id: "+id+" was removed.";
    }

    @ModelAttribute("countries")
    public String[] countries(){
        return personDTO.getCountries();
    }

    @ModelAttribute("genders")
    public String[] genders(){
        return personDTO.getGenders();
    }

}
