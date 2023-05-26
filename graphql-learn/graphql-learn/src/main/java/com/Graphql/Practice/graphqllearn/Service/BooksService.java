package com.Graphql.Practice.graphqllearn.Service;

import com.Graphql.Practice.graphqllearn.Model.Books;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    Books create(Books book);

    List<Books> getAllBooks();

    Optional<Books> getBook(int id);

    void delete(int id);

}
