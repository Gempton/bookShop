package by.ilya.bookShop.service;

import by.ilya.bookShop.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book findById(Integer id);

    void checkExistsById(Integer id);

    List<Book> findAll();

    void delete(Integer id);
}
