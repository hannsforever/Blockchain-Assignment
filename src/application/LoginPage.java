package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LoginPage {
	private Stage primaryStage;
	
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button backButton;
    private Label errorLbl;
    
    @SuppressWarnings("exports")
	public LoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        Stage stage = new Stage();

        // Create GUI components
        usernameField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        backButton = new Button("Back");
        errorLbl = new Label("");

        // Configure event handlers
        loginButton.setOnAction(event -> handleLogin());
        backButton.setOnAction(event -> {
        	stage.close();
            primaryStage.show(); // Show the LandingPage
        });

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Username:"),
                usernameField,
                new Label("Password:"),
                passwordField,
                errorLbl,
                loginButton,
                backButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Perform login authentication logic here
        Login login = new Login();

        if (login.authenticate(username, password)) {
            // Authentication successful
            // Save session information to a text file
            saveSessionInformation(username);

            // Proceed to the MainPage
            MainPage mainPage = new MainPage(primaryStage);
            mainPage.display();

            // Close the current login page
            Stage loginPageStage = (Stage) loginButton.getScene().getWindow();
            loginPageStage.close();
        } else {
            // Clear fields and show error message
            usernameField.clear();
            passwordField.clear();
            errorLbl.setText("Authentication failed");
        }
    }


    private static class Login {
        private static final String FILENAME = "user_data.txt";

        public boolean authenticate(String username, String password) {
            String hashedPassword = getHashedPasswordFromDatabase(username);
            if (hashedPassword != null) {
                return BCrypt.checkpw(password, hashedPassword);
            }
            return false; // User not found or error occurred
        }

        private String getHashedPasswordFromDatabase(String username) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 2 && data[0].equals(username)) {
                        return data[1];
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null; // User not found or error occurred
        }
    }
    
    private void saveSessionInformation(String username) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("session.txt"))) {
            writer.write(username);

            System.out.println("Session information saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
