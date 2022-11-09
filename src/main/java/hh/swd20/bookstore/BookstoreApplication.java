package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {
			bookRepository.save(new Book("Alice Isn\'t Dead", "Joseph Fink", 2018, "9780062844132", 18.68, null));
			bookRepository.save(new Book("Welcome to Night Vale", "Joseph Fink & Jeffrey Cranor", 2015, "9780062351425",
					15.99, null));
			bookRepository
					.save(new Book("It Devours!", "Joseph Fink & Jeffrey Cranor", 2017, "9780062476050", 16.99, null));
			bookRepository.save(new Book("Coraline", "Neil Gaiman", 2002, "0380977788", 15.99, null));
			bookRepository.save(new Book("The Graveyard Book", "Neil Gaiman", 2008, "9780747598626", 7.99, null));
			bookRepository.save(new Book("American Gods", "Neil Gaiman", 2001, "0747263744", 6.99, null));

			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("YA"));
			categoryRepository.save(new Category("Romance"));

			// users: admin/admin and user/user
			User user1 = new User("admin", "$2a$10$XShpBG.aRgR1fU2mN5PjyOOzAu8NUm4iXEM5SBJNKEF.b4LJQGMOK", "ADMIN");
			User user2 = new User("user", "$2a$10$H8xNB3WJCaJ6/X.JwmPVoeJtpTXly1Y2VJgNOuImTA7zpNhtDE23e", "USER");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	};
}