package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public String validate(Model model){

        Book book = new Book();
        book.setPages(1);
        List<String> list = new ArrayList<>();

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        if(!violations.isEmpty()){
            for(ConstraintViolation<Book> constraintViolation : violations){
               list.add(constraintViolation.getPropertyPath()+" : "+constraintViolation.getMessage());
            }
        }
        model.addAttribute("list",list);

        return "validate_messages";
    }
}
