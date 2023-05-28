package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    private Button checkButton;
    private Button loginButton;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
        // Create GUI components
        checkButton = new Button("Check");
        loginButton = new Button("Login");

        // Configure event handlers
        checkButton.setOnAction(event -> moveToCheckPage());
        loginButton.setOnAction(event -> moveToLoginPage());

        
        
        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                checkButton,
                loginButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Engine Oil Supply Chain");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveToCheckPage() {
    	CheckPage checkPage = new CheckPage();
    	checkPage.display();
    }
    
    private void moveToLoginPage() {
    	LoginPage loginPage = new LoginPage();
    	loginPage.display();
    }

}
