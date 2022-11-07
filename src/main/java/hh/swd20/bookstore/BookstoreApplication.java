package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			bookRepository.save(new Book("Alice Isn\'t Dead", "Joseph Fink", 2018, "978-0062844132", 18.68, null));
			bookRepository.save(new Book("Welcome to Night Vale", "Joseph Fink & Jeffrey Cranor", 2015,
					"978-0062351425", 15.99, null));
			bookRepository
					.save(new Book("It Devours!", "Joseph Fink & Jeffrey Cranor", 2017, "978-0062476050", 16.99, null));
			bookRepository.save(new Book("Coraline", "Neil Gaiman", 2002, "0-380-97778-8", 15.99, null));
			bookRepository.save(new Book("The Graveyard Book", "Neil Gaiman", 2008, "978-0-7475-9862-6", 7.99, null));
			bookRepository.save(new Book("American Gods", "Neil Gaiman", 2001, "0-7472-6374-4", 6.99, null));

			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("YA"));
			categoryRepository.save(new Category("Historical"));
			categoryRepository.save(new Category("Romance"));
		};
	};
}