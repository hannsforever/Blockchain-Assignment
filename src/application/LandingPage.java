package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LandingPage extends Application {
 private TextField searchField;
 private Button searchButton;
 private Button loginButton;
 private Button exitButton;

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("exports")
 @Override
    public void start(Stage primaryStage) {
        // Create GUI components
     searchField = new TextField();
     searchField.setPromptText("Enter code (eg. 12345, 24680, 09876)");
     searchButton = new Button("Search Product by Code");
        loginButton = new Button("Login");
        exitButton = new Button("Exit");

        // Configure event handlers
        searchButton.setOnAction(event -> {
            String productCode = searchField.getText();
            searchProductInformation(productCode);
        });
        loginButton.setOnAction(event -> moveToLoginPage(primaryStage));
        exitButton.setOnAction(event -> System.exit(0));

        // Create layout
        VBox root = new VBox(10);
        VBox.setMargin(loginButton, new Insets(20, 0, 0, 0));
        root.setPadding(new Insets(10));
        root.getChildren().addAll(searchField, searchButton, loginButton, exitButton);

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        root.requestFocus();
        primaryStage.setTitle("Engine Oil Supply Chain");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveToLoginPage(Stage primaryStage) {
     primaryStage.close(); // Close the LandingPage stage
     
        LoginPage loginPage = new LoginPage(primaryStage);
        loginPage.display();
    }
    
    public void searchProductInformation(String productCode) {
        AssignSupplierPage assignSupplierPage = new AssignSupplierPage("product_information.txt");

        try {
            ProductInformation productInfo = assignSupplierPage.getProductInformation(productCode);

            if (productInfo != null) {
                // Product information found
                String brand = productInfo.getBrand();
                String name = productInfo.getName();
                String code = productInfo.getCode();
                String specifications = productInfo.getSpecifications();
                String factory = productInfo.getFactory();
                String manufacturingDate = productInfo.getManufacturingDate();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Search Product");
                alert.setHeaderText(null);
                alert.setContentText(
                		"Brand: " + brand + "\n" +
                        "Name: " + name + "\n" +
                        "Code: " + code + "\n" +
                        "Specifications: " + specifications + "\n" +
                        "Factory: " + factory + "\n" +
                        "Manufacturing Date: " + manufacturingDate + "\n"
                        );
                alert.showAndWait();                
                
            } else {
            
            	// Product information not found
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Search Product");
                alert.setHeaderText(null);
                alert.setContentText("Product information not found for code: " + productCode);
                alert.showAndWait();
            
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during the retrieval of product information
            e.printStackTrace();
        }
    }
    
}