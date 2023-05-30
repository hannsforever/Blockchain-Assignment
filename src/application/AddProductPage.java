package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProductPage {
    private TextField productNameField;
    private TextField brandField;
    private TextField codeField;
    private TextField specificationsField;
    private TextField factoryField;
    private Button saveButton;
    private Button backButton;

    public void display() {
        Stage stage = new Stage();

        // Create GUI components
        productNameField = new TextField();
        brandField = new TextField();
        codeField = new TextField();
        specificationsField = new TextField();
        factoryField = new TextField();
        saveButton = new Button("Save");
        backButton = new Button("Back");

        // Configure event handlers
        saveButton.setOnAction(event -> {
			try {
				saveProductInformation(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
        backButton.setOnAction(event -> stage.close());

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Product Name:"),
                productNameField,
                new Label("Brand:"),
                brandField,
                new Label("Code:"),
                codeField,
                new Label("Specifications:"),
                specificationsField,
                new Label("Factory:"),
                factoryField,
                saveButton,
                backButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("Add Product Information");
        stage.setScene(scene);
        stage.show();
    }
    
    private void saveProductInformation(Stage stage) throws Exception {
    	PredefinedCharsSecretKey preSKey = new PredefinedCharsSecretKey();
    	
    	//Prefefined Secret Key and Random Secret Key
    	Key preSecretKey = preSKey.getPreSecretKey();
    	
    	if (preSecretKey != null) {
    		System.out.println("Predefined secret key generation successful.");
		} else {
			System.out.println("Failed to generate predefined secret key.");
		}
		
		//Symmetric key
		Symmetric symm = new Symmetric();
		
        String productName = productNameField.getText();
        String brand = brandField.getText();
        String code = codeField.getText();
        String specifications = specificationsField.getText();
        String factory = factoryField.getText();
        String manufacturingDate = getCurrentDate();

        // Create a new instance of ProductInformation
        ProductInformation productInformation = new ProductInformation(brand, productName, code, specifications, factory, manufacturingDate);

        // Save the product information to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("product_information.txt", true))) {
        	String info = productInformation.toString().replaceAll("\\[|\\]", "");
        	String encryptedInfo = symm.encrypt(info, preSecretKey);
            writer.write(encryptedInfo);
            writer.newLine();

            showSuccessDialog(); //showing product added successfull
            
            System.out.println("Product information saved successfully.");
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    
    private void showSuccessDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add Product");
        alert.setHeaderText(null);
        alert.setContentText("Product added successfully.");
        alert.showAndWait();
    }
    
}
