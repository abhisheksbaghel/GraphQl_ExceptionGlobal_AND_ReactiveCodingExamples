package com.Graphql.Practice.graphqllearn.Controller;

import com.Graphql.Practice.graphqllearn.Exception.NotFoundException;
import com.Graphql.Practice.graphqllearn.Model.Books;
import com.Graphql.Practice.graphqllearn.Service.BooksService;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;


    @GetMapping("/getbook/{bookid}")
    public Optional<Books> getbyid(@PathVariable int bookid) throws NotFoundException {
        Optional<Books> opbook = booksService.getBook(bookid);
        if(!(opbook==null)) {
            return booksService.getBook(bookid);
        }
        else
        {
            throw new NotFoundException("Book with id "+bookid+" not found ");
        }
    }

    @GetMapping("/getall")
    public List<Books> getAll()
    {
        return booksService.getAllBooks();
    }

    @PostMapping("/addbook")
    public Books addbook(@Valid @RequestBody Books book)
    {

        return booksService.create(book);
    }

    @DeleteMapping("/deleteBook/{bookid}")
    public String deleteBooks(@PathVariable int bookid)
    {
        booksService.delete(bookid);
        return "Book with book_id : "+bookid+" deleted!!!";
    }

}