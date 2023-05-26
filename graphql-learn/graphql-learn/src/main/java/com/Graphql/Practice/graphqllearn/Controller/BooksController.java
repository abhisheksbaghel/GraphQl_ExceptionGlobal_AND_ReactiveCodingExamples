package com.Graphql.Practice.graphqllearn.Controller;

import com.Graphql.Practice.graphqllearn.Model.Books;
import com.Graphql.Practice.graphqllearn.Service.BooksService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/books")

@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;


//    @GetMapping("/getbook/{id}")
    @QueryMapping("getBook")
    public Optional<Books> getbyid(@Argument int bookid)
    {
        return booksService.getBook(bookid);
    }

//    @GetMapping("/getall")
    @QueryMapping("allBooks")
    public List<Books> getAll()
    {
        return booksService.getAllBooks();
    }

//    @PostMapping("/addbook")

    @MutationMapping("createBook")
    public Books addbook(@Argument BookInput book)
    {
        Books b1=new Books();
        b1.setAuthor(book.getAuthor());
        b1.setTitle(book.getTitle());
        b1.setDescription(book.getDescription());
        b1.setPrice(book.getPrice());
        b1.setPages(book.getPages());

        return booksService.create(b1);
    }

    @MutationMapping("deleteBook")
    public String deleteBooks(@Argument int bookid)
    {
        booksService.delete(bookid);
        return "Book with book_id : "+bookid+" deleted!!!";
    }

}

@Data
class BookInput
{
    private String title;

    private String description;

    private String author;

    private double price;

    private int pages;
}
