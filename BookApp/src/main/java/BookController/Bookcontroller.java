package BookController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import BookService.BookServive;
import Model.Book;

public class Bookcontroller {
	@Autowired
	private BookServive bookService;
	
	@FXML
	private TextField titleField;
	
	@FXML
	private TextField authorField;
	
	@FXML
	private TextField yearField;
	
	@FXML
	private TextField isbnField;
	
	@FXML
	private TextField readField;
	
			@FXML
			private TableView<Book> bookTable;
		    @FXML
		    private TableColumn<Book, Long> idColumn;
		    @FXML
		    private TableColumn<Book, String> titleColumn;
		    @FXML
		    private TableColumn<Book, String> authorColumn;
		    @FXML
		    private TableColumn<Book, Integer> yearColumn;
		    @FXML
		    private TableColumn<Book, String> isbnColumn;

	        private ObservableList<Book> bookList;
	        
	   @FXML
	   public void initialize() {
		     idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		     titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		     authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
		     yearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
		     isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());

		     bookList = FXCollections.observableArrayList();
		     bookTable.setItems(bookList);

		     viewBooks();
		    }
	   
	   @FXML
	   private void addBook() {
		   Book book = new Book();
		   book.setTitle(titleField.getText());
		   book.setAuthor(authorField.getText());
		   book.setYear(Integer.parseInt(yearField.getText()));
		   book.setIsbn(isbnField.getText());
		   //book.setRead(readField.getText());
		   
		   bookService.save(book);
		   viewBooks();
	   }
	   
	   @FXML
	   private void updateBook() {
		   Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
		   if(selectedBook != null) {
			   selectedBook.setTitle(titleField.getText());
			   selectedBook.setAuthor(authorField.getText());
			   selectedBook.setYear(Integer.parseInt(yearField.getText()));
			   selectedBook.setISBN(isbnField.getText());
			   //selectedBook.setRead(readField.getText());
			   
			   bookService.save(selectedBook);
			   viewBooks();
		   }
		   }
		   
		   @FXML
		   private void deleteBook() {
			   Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
			   
			   if (selectedBook != null) {
				   bookService.deleteById(selectedBook.getId());
				   viewBooks();
			   }
		   }
			   
			   @FXML
			   private void viewBooks() {
				   List<Book> books = bookService.findAll();
				   bookList.setAll(books);

			   }
	   }
	
	
	
	

}
