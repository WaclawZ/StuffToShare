package pl.coderslab.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PersonDTO {

    public String[] getCountries(){
        return new String[] {"Polska", "Niemcy", "Czechy"};
    }

    public String[] getGenders(){
        return new String[] {"Male", "Female", "FTM", "MTF"};
    }

}
