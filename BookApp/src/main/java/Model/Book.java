package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


	@Entity
	public class Book {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    //changed to javafx properties for the gui//changed this(year is not a String is an Intenger!!!
	    private final StringProperty title = new SimpleStringProperty();
	    private final StringProperty author = new SimpleStringProperty();
	    private final IntegerProperty year = new SimpleIntegerProperty();
	    private final StringProperty isbn = new SimpleStringProperty();


	    //bc of JPA we need a constructor with no arguments
	    public Book() {
	    	
	    }
	    //here is the constructor w parameters for future instantiation
	    public Book(String title, String author, int year, String isbn) {
	    	this.title.set(title);
	    	this.author.set(author);
	    	this.year.set(year);
	    	this.isbn.set(isbn);
	    }
	    
	    // Getters and setters for properties
	    public String getTitle() {
	        return title.get();
	    }

	    public void setTitle(String title) {
	        this.title.set(title);
	    }

	    public StringProperty titleProperty() {
	        return title;
	    }

	    public String getAuthor() {
	        return author.get();
	    }

	    public void setAuthor(String author) {
	        this.author.set(author);
	    }

	    public StringProperty authorProperty() {
	        return author;
	    }

	    public int getYear() {
	        return year.get();
	    }

	    public void setYear(int year) {
	        this.year.set(year);
	    }

	    public IntegerProperty yearProperty() {
	        return year;
	    }

	    public String getIsbn() {
	        return isbn.get();
	    }

	    public void setIsbn(String isbn) {
	        this.isbn.set(isbn);
	    }

	    public StringProperty isbnProperty() {
	        return isbn;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	}
	    

