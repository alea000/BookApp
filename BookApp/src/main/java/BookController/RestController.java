package BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import BookService.BookServive;
import Model.Book;

import java.util.List;

@Controller
@RequestMapping("/books")
public class RestController {
	
	@Autowired
	private BookServive bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.findAll();
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		return bookService.save(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteById(id);
		
	}
	

}
