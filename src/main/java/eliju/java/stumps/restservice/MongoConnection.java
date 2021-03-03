/**
 * 
 */
package eliju.java.stumps.restservice;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
/**
 * @author elina
 *
 */
public class MongoConnection {
	private MongoClient client = null;
	private MongoDatabase database =  null;
	private MongoCollection<Document> books = null;
	
	public MongoConnection() {
		this.client = MongoClients.create("mongodb://localhost:27017");
		this.database = client.getDatabase("Library");
		this.books = database.getCollection("LibraryCollection");
	}
	
	public List<Document>  getBookByTitle(String title) {
		List<Document> books = this.books.find(Filters.regex("Title", title, "i")).into(new ArrayList<>());
		books.addAll(this.books.find(Filters.regex("Titel", title, "i")).into(new ArrayList<>()));
		return books;
	}

	public List<Document>  getBookByAuthor(String author) {
		List<Document> books = this.books.find(Filters.regex("Author", author, "i")).into(new ArrayList<>());
		books.addAll(this.books.find(Filters.regex("Autor/in", author, "i")).into(new ArrayList<>()));
		books.addAll(this.books.find(Filters.regex("Tekijä", author, "i")).into(new ArrayList<>()));
		books.addAll(this.books.find(Filters.regex("Lisätiedot", author, "i")).into(new ArrayList<>()));
		return books;
	}

	public List<Document>  getBookByText(String text) {
		String iName = this.books.createIndex(Indexes.text("$**"));
		List<Document> books = this.books.find(Filters.text(text)).into(new ArrayList<>());
		this.books.dropIndex(iName);
		return books;
	}
}
