package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

@Component
public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    public AuthorConverter(){

    }

    @Override
    public Author convert(String source) {
        Author author = authorDao.getAuthorById(Integer.parseInt(source));
        return  author;
    }
}
