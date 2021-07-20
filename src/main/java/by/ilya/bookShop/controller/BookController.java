package by.ilya.bookShop.controller;


import by.ilya.bookShop.controller.mapper.BookMapper;
import by.ilya.bookShop.dto.BookDto;
import by.ilya.bookShop.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

// todo create github repository and push project to github
@Api(value = "API to search Book from a Book Repository by different search parameters",
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController //- это как @Controller и @ResponseBody вместе
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    // Create new book
    @ApiOperation(value = "Create new Book")
    @PostMapping
    public BookDto addNew(@RequestBody @Valid BookDto bookDto) {
        var book = bookMapper.mapToBook(bookDto);
        var newBook = bookService.save(book);
        return bookMapper.mapToBookDto(newBook);
    }

    // Get book by id
    @ApiOperation(value = "Get Book by id")
    @GetMapping("/{id}")
    public BookDto getBookById(
            @ApiParam(name = "id",value = "The Id of the Book to be viewed", required = true)
            @PathVariable("id") Integer id) {
        var book = bookService.findById(id);
        return bookMapper.mapToBookDto(book);
    }

    // Get all books
    @ApiOperation(value = "Get All Books")
    @GetMapping
    public List<BookDto> getAllBooks() {
        var books = bookService.findAll();
        return books.stream().map(bookMapper::mapToBookDto).collect(Collectors.toList());
    }

    // Delete by id
    @ApiOperation(value = "Delete Book")
    @DeleteMapping("/{id}")
    public void deleteBook(
            @ApiParam(
                    name = "id",
                    value = "The Id of the Book to be deleted",
                    required = true)
            @PathVariable("id") Integer id) {
        bookService.delete(id);
    }

    // Update book
    // todo remove unauthorized, forbidden, etc. (not used)
    @ApiOperation(value = "Update book")
    @PostMapping("/{id}")
    public BookDto updateBook(
            @ApiParam(
                    name = "id",
                    value = "The Id of the Book to be updated",
                    required = true)
            @PathVariable("id") Integer id,
            @Valid @RequestBody BookDto bookDto) {
        bookService.checkExistsById(id);

        var newBook = bookMapper.mapToBook(bookDto);
        newBook.setId(id);
        return bookMapper.mapToBookDto(bookService.save(newBook));
    }
}
// todo future add global exception handler