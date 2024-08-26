//import javafx classes
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import spframework classes for bootstrapping + managing 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class Main extends Application{
	private ConfigurableApplicationContext context;
	
	@Override//overrides init() from Application class(extended bfore) Spring context is set up
	public void init() {
	    try {
	        context = SpringApplication.run(Main.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	        Platform.exit();  // Ensure the application exits if the Spring context fails to start
	    }
	}

	@Override//calls javafx user interface - loads fx file(bookcatalogapp) for UI layout + gets the beans.
	public void start(Stage primaryStage) throws Exception {
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bookcatalogapp.fxml"));
	        fxmlLoader.setControllerFactory(context::getBean);
	        primaryStage.setScene(new Scene(fxmlLoader.load()));
	        primaryStage.setTitle("Book Catalog App");
	        primaryStage.show();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Platform.exit();  // Ensure the application exits if the FXML loading fails
	    }
	}
	
	@Override//ends bean cycle
	public void stop() {
		context.close();
	}
	
	
	//entry point for java app triggering javafx.
	public static void main(String[] args) {
		launch(args);
	}

}
