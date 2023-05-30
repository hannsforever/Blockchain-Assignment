package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LandingPage extends Application {
	private Button checkButton;
	private Button loginButton;
	private Button exitButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create GUI components
        checkButton = new Button("Check");
        loginButton = new Button("Login");
        exitButton = new Button("Exit");

        // Configure event handlers
        checkButton.setOnAction(event -> moveToCheckPage(primaryStage));
        loginButton.setOnAction(event -> moveToLoginPage(primaryStage));
        exitButton.setOnAction(event -> System.exit(0));

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(checkButton, loginButton, exitButton);

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Engine Oil Supply Chain");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveToCheckPage(Stage primaryStage) {
    	primaryStage.close(); // Close the LandingPage stage
    	
        CheckPage checkPage = new CheckPage(primaryStage);
        checkPage.display();
    }

    private void moveToLoginPage(Stage primaryStage) {
    	primaryStage.close(); // Close the LandingPage stage
    	
        LoginPage loginPage = new LoginPage(primaryStage);
        loginPage.display();
    }
}
