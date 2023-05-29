package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddProductPage {
    private TextField productNameField;
    private TextField brandField;
    private TextField codeField;
    private TextField specificationsField;
    private TextField manufacturingDateField;
    private Button saveButton;
    private Button backButton;

    public void display() {
        Stage stage = new Stage();

     // Create GUI components
        productNameField = new TextField();
        brandField = new TextField();
        codeField = new TextField();
        specificationsField = new TextField();
        manufacturingDateField = new TextField();
        saveButton = new Button("Save");
        backButton = new Button("Back");

        // Configure event handlers
        saveButton.setOnAction(event -> saveProductInformation());
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
                new Label("Manufacturing Date:"),
                manufacturingDateField,
                saveButton,
                backButton
        );


        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Add Product Information");
        stage.setScene(scene);
        stage.show();
    }

    private void saveProductInformation() {
        String productName = productNameField.getText();
        String brand = brandField.getText();
        String code = codeField.getText();
        String specifications = specificationsField.getText();
        String manufacturingDate = manufacturingDateField.getText();

        // Create a new instance of ProductInformation
        ProductInformation productInformation = new ProductInformation(brand, productName, code, specifications, manufacturingDate);

        // TODO: Store the productInformation object or pass it to another component for further processing

        System.out.println("Product information saved successfully.");
    }

}
