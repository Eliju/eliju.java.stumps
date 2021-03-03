/**
 * 
 */
package eliju.java.stumps.restservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
/**
 * @author elina
 *
 */
@RestController
public class LibraryController {
	private final MongoConnection mongo = new MongoConnection();
	
	@GetMapping("/get-by-title")
	public List<Book> getBookByTitle(@RequestParam(value = "title", defaultValue = "all") String title) {
		List Books = mongo.getBookByTitle(title);
		return Books;
	}
	
	@GetMapping("/get-by-author")
	public List<Book> getBookByAuthor(@RequestParam(value = "author", defaultValue = "all") String author) {
		List Books = mongo.getBookByAuthor(author);
		return Books;
	}

	@GetMapping("/get-by-text")
	public List<Book> getBookByText(@RequestParam(value = "text", defaultValue = "all") String text) {
		List Books = mongo.getBookByText(text);
		return Books;
	}

}
