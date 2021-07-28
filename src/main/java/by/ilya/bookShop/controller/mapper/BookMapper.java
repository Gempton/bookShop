package by.ilya.bookShop.controller.mapper;

import by.ilya.bookShop.dto.BookDto;
import by.ilya.bookShop.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

// todo use mapstruct
@Component
@Mapper(componentModel = "spring")
public interface BookMapper {

    Book mapToBook(BookDto bookDto);
    BookDto mapToBookDto(Book book);
}
