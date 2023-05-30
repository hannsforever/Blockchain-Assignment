package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class MainPage {
    private Stage primaryStage;
    

    public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        Stage stage = new Stage();

        // Create GUI components
        Button addProductButton = new Button("Add Product");
        Button assignSupplierButton = new Button("Assign Supplier");
        Button logoutButton = new Button("Logout");

        // Configure event handlers
        addProductButton.setOnAction(event -> openAddProductPage());
        assignSupplierButton.setOnAction(event -> openAssignSupplierPage());
        logoutButton.setOnAction(event -> {
        	stage.close();
        	logout(); 
        	primaryStage.show();
        });

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(addProductButton, assignSupplierButton, logoutButton);

        // Set up scene and stage
        Scene scene = new Scene(root, 200, 150);
        stage.setTitle("Main Page");
        stage.setScene(scene);
        stage.show();
    }

    private void openAddProductPage() {
        AddProductPage addProductPage = new AddProductPage();
        addProductPage.display();
    }

    private void openAssignSupplierPage() {
        AssignSupplierPage assignSupplierPage = new AssignSupplierPage("product_information.txt");
        assignSupplierPage.display();
    }

    private void logout() {
        // Delete the session information file
        File sessionFile = new File("session.txt");
        boolean deleted = sessionFile.delete();
        System.out.println("Session file deleted: " + deleted); // Debug print statement
    }
}
