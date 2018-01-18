package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Component
public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao publisherDao;

    public PublisherConverter() {

    }

    @Override
    public Publisher convert(String source) {
        Publisher publisher = publisherDao.getPublisherById(Integer.parseInt(source));
        return publisher;
    }
}

