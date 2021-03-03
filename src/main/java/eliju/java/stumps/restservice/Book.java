/**
 * 
 */
package eliju.java.stumps.restservice;

/**
 * @author elina
 *
 */
public class Book {
	private final String title;
	private final String author;
	private final String description;
	
	public Book(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	public String getTitle() {
		return new String(this.title);
	}
	
	public String getAuthor() {
		return new String(this.author);
	}
	
	public String getDescription() {
		return new String(this.description);
	}

}
