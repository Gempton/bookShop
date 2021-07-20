package by.ilya.bookShop.repository;

import by.ilya.bookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
