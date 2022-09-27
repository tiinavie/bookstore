package hh.swd20.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	// Show all books
	@RequestMapping(value = "/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	// Add new book
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	// Save new book to the booklist
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}

	// Delete a book from booklist
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}

//	// Edit a book from booklist
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public String editBook(@PathVariable("id") Long bookId, Model model) {
//		bookRepository.save(book);
//		return "redirect:../booklist";
//	}

}
