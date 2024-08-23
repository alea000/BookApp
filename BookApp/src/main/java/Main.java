
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main extends Application{
	private ConfigurableApplicationContext context;
	
	@Override
	public void init() {
		context = SpringApplication.run(Main.class);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bookcatalogapp.fxml"));
		fxmlLoader.setControllerFactory(context::getBean);
		primaryStage.setScene(new Scene(fxmlLoader.load()));
		primaryStage.setTitle("Book Catalog App");
		primaryStage.show();
	}
	
	@Override
	public void stop() {
		context.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
