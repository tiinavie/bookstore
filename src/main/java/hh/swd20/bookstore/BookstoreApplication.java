package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("Alice Isn\'t Dead", "Joseph Fink", 2018, "978-0062844132", 18.68));
			bookRepository.save(
					new Book("Welcome to Night Vale", "Joseph Fink & Jeffrey Cranor", 2015, "978-0062351425", 15.99));
			bookRepository.save(new Book("It Devours!", "Joseph Fink & Jeffrey Cranor", 2017, "978-0062476050", 16.99));
			bookRepository.save(new Book("Coraline", "Neil Gaiman", 2002, "0-380-97778-8", 15.99));
			bookRepository.save(new Book("The Graveyard Book", "Neil Gaiman", 2008, "978-0-7475-9862-6", 7.99));
			bookRepository.save(new Book("American Gods", "Neil Gaiman", 2001, "0-7472-6374-4", 6.99));

		};
	}
}