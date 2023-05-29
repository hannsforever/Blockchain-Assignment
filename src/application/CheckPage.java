package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPage{

    private TextField codeField;
    private Button checkButton;
    private Button backButton;

    public void display() {
    	Stage stage = new Stage();
    	
        // Create GUI components
        codeField = new TextField();
        checkButton = new Button("Check");
        backButton = new Button("Back");

        // Configure event handlers
        checkButton.setOnAction(event -> checkProduct());
        backButton.setOnAction(event -> {
        	stage.close();
        });

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Code:"),
                codeField,
                checkButton,
                backButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Check Engine Oil Validity");
        stage.setScene(scene);
        stage.show();
    }

    private void checkProduct() {
        String code = codeField.getText();
        // Perform checking logic here
        // You can use a database or hardcoded credentials for simplicity
    }
	
}
