package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    private Button checkButton;
    private Button loginManufacturerButton;
    private Button loginSupplierButton;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
        // Create GUI components
        checkButton = new Button("Check");
        loginManufacturerButton = new Button("Login as Manufacturer");
        loginSupplierButton = new Button("Login as Supplier");

        // Configure event handlers
        checkButton.setOnAction(event -> moveToCheckPage());
        loginManufacturerButton.setOnAction(event -> moveToMLoginPage());
        loginSupplierButton.setOnAction(event -> moveToSLoginPage());

        
        
        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                checkButton,
                loginManufacturerButton,
                loginSupplierButton
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
    
    private void moveToMLoginPage() {
    	LoginPage loginPage = new LoginPage();
    	loginPage.display();
    }
    
    private void moveToSLoginPage() {
    	LoginPage loginPage = new LoginPage();
    	loginPage.display();
    }

}
