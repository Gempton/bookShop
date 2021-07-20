package by.ilya.bookShop.controller.mapper;

import by.ilya.bookShop.dto.BookDto;
import by.ilya.bookShop.model.Book;
import org.springframework.stereotype.Component;

// todo use mapstruct
@Component
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        var book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());

        return book;
    }

    public BookDto mapToBookDto(Book book) {
        var bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());

        return bookDto;
    }

}
