package by.ilya.bookShop.exception;

public class BookNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "error.book_not_found";

    public BookNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
