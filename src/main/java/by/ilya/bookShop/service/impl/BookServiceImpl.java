package by.ilya.bookShop.service.impl;

import by.ilya.bookShop.exception.BookNotFoundException;
import by.ilya.bookShop.model.Book;
import by.ilya.bookShop.repository.BookRepository;
import by.ilya.bookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// todo write tests on service & controller
// for service use mockito
// for controller use spring mock mvc
// todo write tests with db
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public void checkExistsById(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        }
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        var book = findById(id);

        bookRepository.delete(book);
    }
}
