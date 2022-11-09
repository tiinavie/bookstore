package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookDepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRepository.findByAuthor("Neil Gaiman");

		assertThat(books).hasSize(3);
		assertThat(books.get(0).getTitle()).isEqualTo("Coraline");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Café Con Lychee", "Emery Lee", 2022, "9780053210271", 13.19, null);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
