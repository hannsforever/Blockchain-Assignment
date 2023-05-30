package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class MainPage {
    private Stage primaryStage;
    

    @SuppressWarnings("exports")
	public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void display() {
        Stage stage = new Stage();

        // Create GUI components
        Button addProductButton = new Button("Add Product");
        Button assignSupplierButton = new Button("Assign Supplier");
        Button downloadLedgerButton = new Button("Download Ledger");
        Button logoutButton = new Button("Logout");

        // Configure event handlers
        addProductButton.setOnAction(event -> openAddProductPage());
        assignSupplierButton.setOnAction(event -> {
			try {
				openAssignSupplierPage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
        downloadLedgerButton.setOnAction(event -> getLedger());
        logoutButton.setOnAction(event -> {
        	stage.close();
        	logout(); 
        	primaryStage.show();
        });

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(addProductButton, assignSupplierButton, downloadLedgerButton, logoutButton);

        // Set up scene and stage
        Scene scene = new Scene(root, 200, 150);
        stage.setTitle("Main Page");
        stage.setScene(scene);
        stage.show();
    }

    private void getLedger() {
    	Blockchain blockchain;
        
        // Check if the master folder exists, create it if it doesn't
        if(!new File("master").exists()) {
			new File("master").mkdir();
			
			// Initialize the blockchain with a genesis block
	        blockchain = Blockchain.getInstance("master/chain.bin");
	        blockchain.genesis();
		} else {
			blockchain = Blockchain.getInstance("master/chain.bin");
		}

        blockchain.downloadLedger();
	}

	private void openAddProductPage() {
        AddProductPage addProductPage = new AddProductPage();
        addProductPage.display();
    }

    private void openAssignSupplierPage() throws Exception {
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
