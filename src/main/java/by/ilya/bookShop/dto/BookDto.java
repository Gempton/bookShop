package by.ilya.bookShop.dto;

import javax.validation.constraints.NotBlank;

// use lombok
public class BookDto {

    private Integer id;

    @NotBlank
    private String author;

    @NotBlank
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
