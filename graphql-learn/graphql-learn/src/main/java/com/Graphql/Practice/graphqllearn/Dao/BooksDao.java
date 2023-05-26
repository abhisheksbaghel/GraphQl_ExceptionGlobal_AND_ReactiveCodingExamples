package com.Graphql.Practice.graphqllearn.Dao;

import com.Graphql.Practice.graphqllearn.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksDao extends JpaRepository<Books,Integer> {

}
