package com.Graphql.Practice.graphqllearn.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long book_id;


    @jakarta.validation.constraints.NotBlank(message = "title can't be null")
    @jakarta.validation.constraints.NotNull(message = "title can't be null")
    private String title;

    @jakarta.validation.constraints.NotNull(message = "description can't be null")
    private String description;

    @jakarta.validation.constraints.NotNull(message = "author can't be null")
    private String author;

    @jakarta.validation.constraints.Max(value = 2000,message = "price should not exceed 2000")
    @NotNull(message = "price can't be null")
    private double price;

    @jakarta.validation.constraints.Min(value = 100,message = "minimum 100 pages required")
    @jakarta.validation.constraints.NotNull(message = "pages can't be null")
    private int pages;

}
