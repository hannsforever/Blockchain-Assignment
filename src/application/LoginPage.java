package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage{
	private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button backButton;

    public void display() {
    	Stage loginPage = new Stage();
    	
        // Create GUI components
        usernameField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        backButton = new Button("Back");

        // Configure event handlers
        loginButton.setOnAction(event -> handleLogin());
        backButton.setOnAction(event -> {
        	loginPage.close();
        });

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Username:"),
                usernameField,
                new Label("Password:"),
                passwordField,
                loginButton,
                backButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 200);
        loginPage.setTitle("Login");
        loginPage.setScene(scene);
        loginPage.show();
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Perform login authentication logic here
        // You can use a database or hardcoded credentials for simplicity
        if (authenticate(username, password)) {

        } else {
            // Clear fields and show error message
            usernameField.clear();
            passwordField.clear();
            // Show login error message
            // You can display it in a dialog or label, for example
        }
    }

    private boolean authenticate(String username, String password) {
        // Perform login authentication logic here
        // You can use a database or hardcoded credentials for simplicity
        // Return true if authentication is successful, false otherwise
        // You can replace this with your own authentication logic
        return username.equals("admin") && password.equals("password");
    }
}
