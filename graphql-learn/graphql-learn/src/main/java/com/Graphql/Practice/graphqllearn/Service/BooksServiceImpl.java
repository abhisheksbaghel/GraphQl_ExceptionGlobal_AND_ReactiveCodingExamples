package com.Graphql.Practice.graphqllearn.Service;

import com.Graphql.Practice.graphqllearn.Dao.BooksDao;
import com.Graphql.Practice.graphqllearn.Model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService{

    @Autowired
    private BooksDao booksDao;

    @Override
    public Books create(Books book) {
        booksDao.save(book);
        return book;
    }

    @Override
    public List<Books> getAllBooks() {
        return booksDao.findAll();
    }

    @Override
    public Optional<Books> getBook(int id) {
        return booksDao.findById(id);
    }

    @Override
    public void delete(int id) {
        booksDao.deleteById(id);
    }


}
