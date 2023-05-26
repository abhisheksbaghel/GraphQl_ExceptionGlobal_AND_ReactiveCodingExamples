package com.Graphql.Practice.graphqllearn;

import com.Graphql.Practice.graphqllearn.Model.Books;
import com.Graphql.Practice.graphqllearn.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlLearnApplication implements CommandLineRunner {

	@Autowired
	BooksService booksService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Books b1= new Books();

		b1.setAuthor("Abhishek");
		b1.setDescription("kharghar");
		b1.setTitle("javadeveloper");
		b1.setPages(1000);
		b1.setPrice(1010);

		Books b2= new Books();

		b2.setAuthor("Arbaaz");
		b2.setDescription("YCP");
		b2.setTitle("javadeveloper");
		b2.setPages(1000);
		b2.setPrice(1010);

		Books b3= new Books();

		b3.setAuthor("Acchutam");
		b3.setDescription("Vita");
		b3.setTitle("javadeveloper");
		b3.setPages(1000);
		b3.setPrice(1010);

		booksService.create(b1);
		booksService.create(b2);
		booksService.create(b3);


	}
}
